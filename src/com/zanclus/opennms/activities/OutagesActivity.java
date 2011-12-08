package com.zanclus.opennms.activities;

import java.io.IOException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.ConfigurationActivity;
import com.zanclus.opennms.R;
import com.zanclus.opennms.data.entities.Event;
import com.zanclus.opennms.data.entities.Node;
import com.zanclus.opennms.data.entities.Outage;
import com.zanclus.opennms.data.entities.OutageList;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class OutagesActivity extends Activity {

    protected RequestParams params = new RequestParams("ifRegainedService", "null") ;
	protected List<Outage> outages = null ;
	protected String authString = null ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.outages) ;

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this) ;
        if (sp.getString("onms.host", "").contentEquals("") || 
        		sp.getString("onms.username","").contentEquals("") ||
        		sp.getString("onms.password", "").contentEquals("") ||
        		sp.getString("onms.port","").contentEquals("") ||
        		sp.getString("onms.app_path","").contentEquals("")) {
        	startActivity(new Intent(this, ConfigurationActivity.class)) ;
        }

        String username = sp.getString("onms.username", "admin") ;
        String password = sp.getString("onms.password", "admin") ;
        String authTemp = username+":"+password ;
        authString = Base64.encodeToString(authTemp.getBytes(), Base64.NO_WRAP) ;

        String protocol = sp.getBoolean("onms.use_ssl", false)?"https":"http" ;
        String baseUrl = protocol+"://"+sp.getString("onms.host", "opennms.org")+":"+sp.getString("onms.port", "8980")+sp.getString("onms.app_path", "/opennms") ;

		StringBuilder params = new StringBuilder() ;
		params.append(baseUrl+"/rest/outages|") ;
		params.append(baseUrl+"/rest/nodes|") ;
		params.append("limit=20|") ;

		final ListView outageList = (ListView) findViewById(R.id.list) ;
		AsyncTask<String, Void, OutageList> outageTask = new AsyncTask<String, Void, OutageList>() {

			@Override
			protected OutageList doInBackground(String... params) {
				// Build a GET query string from the params

				String url = params[0].split("\\|")[0] + "?" + params[0].split("\\|")[2] ;
				HttpClient client = AndroidHttpClient.newInstance("ONMSDroid") ;
				HttpGet get = new HttpGet(url) ;
				get.setHeader("Authorization", "Basic "+OutagesActivity.this.authString) ;
				try {
					Log.d("OutagesActivity","Sending GET request '"+url+"'") ;
					HttpResponse response = client.execute(get) ;
					Strategy strategy = new AnnotationStrategy() ;
					Serializer parser = new Persister(strategy) ;
					HttpEntity entity = response.getEntity() ;
					OutageList list = null ;
					if (entity != null) {
						list = parser.read(OutageList.class, entity.getContent()) ;
						if (list!=null) {
							outages = list.getOutages() ;
							for (int x=0; x<outages.size(); x++) {
								Outage outage = outages.get(x) ;
								Log.d("OutagesActivity","Processing outage ID: "+outage.getOutageId()) ;
								if (outage != null) {
									Event evt = outage.getServiceLostEvent();
									int nodeId = evt.getNodeId();
									url = params[0].split("\\|")[1] + "/" + nodeId;
									get = new HttpGet(url);
									Log.d("OutagesActivity", "Sending GET request '" + url + "'");
									get.setHeader("Authorization", "Basic "+OutagesActivity.this.authString);
									response = client.execute(get);
									Node node = parser.read(Node.class, response.getEntity().getContent());
									evt.setNode(node);
									outage.setServiceLostEvent(evt) ;
								}
								outages.set(x, outage) ;
							}
							list.setOutages(outages) ;
							Log.d("OutagesActivity","Return OutagesList object for post request processing.") ;
							return list ;
						}
					} else {
						Log.e("OutagesActivity","HTTP Response entity was null.") ;
					}
				} catch (ClientProtocolException e) {
					Log.e("OutagesActivity", "ClientProtocolException encountered while performing API request.", e) ;
				} catch (IOException e) {
					Log.e("OutagesActivity", "IOException encountered while performing API request.", e) ;
				} catch (IllegalStateException e) {
					Log.e("OutagesActivity", "IllegalStateException encountered reading HTTP(S) response", e) ;
				} catch (Exception e) {
					Log.e("OutagesActivity", "Exception encountered while parsing XML response.", e) ;
				}

				return null ;
			}

			@Override
			protected void onPostExecute(OutageList result) {
				super.onPostExecute(result);

				Log.d("OutagesActivity","Got a result from the ReST request.") ;

				final OutageList outages = result ;

				ListAdapter adapter = new BaseAdapter() {
					
					@Override
					public View getView(int position, View convertView, ViewGroup parent) {
						if (convertView==null) {
							convertView = new LinearLayout(parent.getContext()) ;
						}
						if (!LinearLayout.class.isInstance(convertView)) {
							convertView = new LinearLayout(parent.getContext()) ;
						}

						String nodeLabel = outages.getOutages().get(position).getServiceLostEvent().getNode().getNodeLabel() ;
						TextView name = new TextView(convertView.getContext()) ;
						name.setText(nodeLabel) ;
						((LinearLayout)convertView).addView(name) ;

						String serviceName = outages.getOutages().get(position).getService().getServiceType().getName() ;
						TextView service = new TextView(convertView.getContext()) ;
						service.setText(serviceName) ;
						((LinearLayout)convertView).addView(service) ;
						
						return convertView ;
					}
					
					@Override
					public long getItemId(int position) {
						return outages.getOutages().get(position).getOutageId() ;
					}
					
					@Override
					public Object getItem(int position) {
						return outages.getOutages().get(position) ;
					}
					
					@Override
					public int getCount() {
						Log.d("OutagesActivity","Number of outages: "+outages.getOutages().size()) ;
						return outages.getOutages().size() ;
					}
				};

				Log.d("OutagesActivity","Setting up list view adapter.") ;
				outageList.setAdapter(adapter) ;

				Log.d("OutagesActivity","Invalidating list view.") ;
				outageList.invalidate() ;
			}
		};

		Log.d("OutagesActivity","Calling AsyncTask to perform ReST request.") ;
		outageTask.execute(params.toString()) ;

		Log.d("OutagesActivity","Calling AsyncTask to perform ReST request.") ;
		outageList.invalidate() ;
	}
}
