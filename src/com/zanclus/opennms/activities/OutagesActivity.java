package com.zanclus.opennms.activities;

import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.R;
import com.zanclus.opennms.data.ORMDataHelper;
import com.zanclus.opennms.data.entities.Outage;

import android.database.Cursor;
import android.os.Bundle;

public class OutagesActivity extends OrmLiteBaseListActivity<ORMDataHelper> {

    protected RequestParams params = new RequestParams("ifRegainedService", "null") ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.outages) ;

		ORMDataHelper dbHelper = this.getHelper() ;
		try {
			QueryBuilder<Outage, Integer> queryBuilder = dbHelper.getOutageDao().queryBuilder() ;
			queryBuilder.where().eq("ifRegainedService", null) ;
			PreparedQuery<Outage> pQuery = queryBuilder.prepare() ;
			
		} catch (SQLException sqle) {
			
		}
	}
}
