/**
 * 
 */
package com.zanclus.opennms.adapters;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.zanclus.opennms.R;
import com.zanclus.opennms.api.Nodes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author dphillips
 *
 */
public class OutageListAdapter extends BaseAdapter {

	protected JSONObject outageData ;
	protected Context ctx ;

	public OutageListAdapter(Context ctx, JSONObject outages) {
		super() ;
		this.ctx = ctx ;
		outageData = outages ;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		try {
			int itemCount = outageData.getInt("@count") ;
			Log.d("OutageListAdapter", "Outage item count: "+itemCount) ;
			return itemCount ;
		} catch (JSONException e) {
			Log.e("OutageListAdapter","Failed to get outage item count from JSON data.", e) ;
		}
		Log.e("OutageListAdapter","Returning an item count of '0'") ;
		return 0 ;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		try {
			Log.d("OutageListAdapter", "Returning object for index '"+position+"'") ;
			return outageData.getJSONArray("outage").get(position) ;
		} catch (JSONException e) {
			Log.e("OutageListAdapter","Failed to get outage item for item '"+position+"' from JSONArray int the JSON data.", e) ;
		}
		return null ;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return (position) ;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.d("OutageListAdapter", "View at position "+position+" requested.") ;
		if (convertView==null) {
			LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.outage_row, null) ;
		}

		try {
			JSONObject currentOutage = (JSONObject)getItem(position) ;
			final TextView outageNode = (TextView) convertView.findViewById(R.id.nodeLabel) ;
			final int nodeId = currentOutage.getJSONObject("serviceLostEvent").getInt("nodeId") ;
			outageNode.setText(currentOutage.getString("ipAddress")) ;
			Nodes.getNode(nodeId, new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(String content) {
					super.onSuccess(content);
					try {
						JSONObject nodeInfo = new JSONObject(new JSONTokener(content)) ;
						outageNode.setText(nodeInfo.getString("@label")) ;
					} catch (JSONException e) {
						Log.d("OutageListAdapter", content) ;
						Log.e("OutageListAdapter", "Unable to retrieve node label for id '"+nodeId+"'", e) ;
					}
				}

				@Override
				public void onFailure(Throwable error) {
					super.onFailure(error);
					Log.e("OutageListAdapter","Error getting REST data from OpenNMS",error) ;
				}
			}) ;

			TextView outageSvc = (TextView) convertView.findViewById(R.id.service) ;
			String svcName = currentOutage.getJSONObject("monitoredService").getJSONObject("serviceType").getString("name") ;
			outageSvc.setText(svcName) ;
			Log.d("OutageListAdapter", "Set the service name to '"+svcName+"'") ;

			TextView severity = (TextView) convertView.findViewById(R.id.severity) ;
			String sevStr = currentOutage.getJSONObject("serviceLostEvent").getString("@severity") ;
			severity.setText(sevStr) ;
			Log.d("OutageListAdapter", "Set the severity to '"+sevStr+"'") ;

			if (sevStr.contentEquals("MAJOR")) {
				severity.setTextColor(R.color.major) ;
			} else if (sevStr.contentEquals("MINOR")) {
				severity.setTextColor(R.color.minor) ;
			} else if (sevStr.contentEquals("NORMAL")) {
				severity.setTextColor(R.color.normal) ;
			} else if (sevStr.contentEquals("WARNING")) {
				severity.setTextColor(R.color.warning) ;
			} else {
				severity.setTextColor(R.color.unknown) ;
			}
			Log.d("OutageListAdapter", "Set the background color for the severity display.") ;
		} catch (JSONException e) {
			Log.e("OutageListAdapter","JSON error for outage with id '"+position+"'", e) ;
			try {
				Log.d("OutageListAdapter", ((JSONObject)getItem(position)).toString(4)) ;
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		} catch (NullPointerException npe) {
			try {
				Log.d("OutageListAdapter", ((JSONObject)getItem(position)).toString(4), npe) ;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		return convertView ;
	}

}
