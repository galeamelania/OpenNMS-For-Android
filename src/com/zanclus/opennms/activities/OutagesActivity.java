package com.zanclus.opennms.activities;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.R;
import com.zanclus.opennms.adapters.OutageListAdapter;
import com.zanclus.opennms.api.Outages;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class OutagesActivity extends Activity {

    protected RequestParams params = new RequestParams("ifRegainedService", "null") ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.outages) ;

        Outages.getOutages(params, new AsyncHttpResponseHandler() {
        	@Override
        	public void onSuccess(String content) {
        		super.onSuccess(content);
        		try {
        			JSONObject outageData = new JSONObject(new JSONTokener(content)) ;
        			ListView outagesList = (ListView) findViewById(R.id.outageListView) ;
        			outagesList.setAdapter(new OutageListAdapter(OutagesActivity.this, outageData)) ;
				} catch (JSONException e) {
	        		Log.e("OutageCount",e.getLocalizedMessage(),e) ;
				}
        	}

        	@Override
        	public void onFailure(Throwable error) {
        		super.onFailure(error);
        		OutagesActivity.this.findViewById(R.id.busyIndicator).setVisibility(View.INVISIBLE) ;
        		Log.e("OutageActivity",error.getLocalizedMessage(),error) ;
        	}
        }) ;
	}
}
