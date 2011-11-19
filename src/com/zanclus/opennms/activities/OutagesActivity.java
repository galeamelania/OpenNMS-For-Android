package com.zanclus.opennms.activities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.R;
import com.zanclus.opennms.data.ORMDataHelper;
import com.zanclus.opennms.data.entities.Outage;
import com.zanclus.opennms.data.entities.OutageList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class OutagesActivity extends OrmLiteBaseListActivity<ORMDataHelper> {

    protected RequestParams params = new RequestParams("ifRegainedService", "null") ;
	protected List<Outage> outages = null ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.outages) ;

		ArrayList<String> params = new ArrayList<String>() ; 

		final ListView outageList = (ListView) findViewById(android.R.id.list) ;
		AsyncTask<String, Void, OutageList> outageTask = new AsyncTask<String, Void, OutageList>() {

			@Override
			protected OutageList doInBackground(String... params) {
				// Build a GET query string from the params
				StringBuilder queryString = new StringBuilder() ;
				for (int x=1; x<params.length; x++) {
					if (x==0) {
						queryString.append("?") ;
					}
					queryString.append(params[x]) ;
					if ((x+1)!=params.length) {
						queryString.append("?") ;
					}
				}

				String url = params[0] + queryString.toString() ;
				HttpClient client = new DefaultHttpClient() ;
				HttpGet get = new HttpGet(url) ;
				try {
					HttpResponse response = client.execute(get) ;
					Strategy strategy = new AnnotationStrategy() ;
					Serializer parser = new Persister(strategy) ;
					OutageList list = parser.read(OutageList.class, response.getEntity().getContent()) ;
					return list ;
				} catch (ClientProtocolException e) {
					Log.e("OutagesActivity", "ClientProtocolException encountered while performing API request.", e) ;
				} catch (IOException e) {
					Log.e("OutagesActivity", "IOException encountered while performing API request.", e) ;
				} catch (IllegalStateException e) {
					Log.e("OutagesActivity", "IllegalStateException encountered while parsing XML response.", e) ;
				} catch (Exception e) {
					Log.e("OutagesActivity", "Exception encountered while  parsing XML response.", e) ;
				}

				return null;
			}

			@Override
			protected void onPostExecute(OutageList result) {
				super.onPostExecute(result);

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
						String nodeAddr = outages.getOutages().get(position).getIpAddress() ;
						return null;
					}
					
					@Override
					public long getItemId(int position) {
						// TODO Auto-generated method stub
						return 0;
					}
					
					@Override
					public Object getItem(int position) {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public int getCount() {
						// TODO Auto-generated method stub
						return 0;
					}
				};

				outageList.setAdapter(adapter) ;
			}
		};

		outageTask.execute((String[])params.toArray()) ;
	}
}
