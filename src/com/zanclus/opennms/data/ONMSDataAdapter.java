package com.zanclus.opennms.data;

import org.json.JSONObject;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ONMSDataAdapter {

	private Context ctx ;
	private ONMSDataHelper dbHelper ;
	private SQLiteDatabase db ;

	public ONMSDataAdapter(Context context) {
		ctx = context ;
	}

	public ONMSDataAdapter open() throws SQLException {
		dbHelper = new ONMSDataHelper(ctx) ;
		db = dbHelper.getWritableDatabase() ;
		return this ;
	}

	public void close() {
		dbHelper.close() ;
	}

	public void addNodes(JSONObject nodeData) {
		
	}
}
