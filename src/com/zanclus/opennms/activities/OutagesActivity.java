package com.zanclus.opennms.activities;

import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.j256.ormlite.dao.Dao;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.R;
import com.zanclus.opennms.data.ORMDataHelper;
import com.zanclus.opennms.data.entities.Outage;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

		ORMDataHelper dbHelper = this.getHelper() ;
		try {
			Dao<Outage, Integer> outageDao = dbHelper.getOutageDao() ;
			outages = outageDao.queryForEq("serviceRegainedEvent", null) ;
		} catch (SQLException sqle) {
			Log.e("OutagesActivity","SQLException encountered while attempting to poll outages from database.",sqle) ;
		}

		if (outages!=null) {
			if (outages.size()>0) {
				ListView outageView = (ListView) findViewById(android.R.id.list) ;
				ListAdapter adapter = new BaseAdapter() {
					
					@Override
					public View getView(int position, View convertView, ViewGroup parent) {
						// TODO Auto-generated method stub
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
				outageView.setAdapter(adapter) ;
			}
		}
	}
}
