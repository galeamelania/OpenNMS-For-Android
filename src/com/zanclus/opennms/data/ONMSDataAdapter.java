package com.zanclus.opennms.data;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

	/**
	 * Given a JSON object which contains a collection of node data, add the nodes to the database.
	 * @param nodeData A {@link JSONObject} containing a collection of node information
	 */
	public void addNodes(JSONObject nodeData) {
		try {
			int nodeCount = nodeData.getInt("count") ;
			JSONArray nodes = nodeData.getJSONArray("nodes") ;
			for (int x=0; x<nodeCount; x++) {
				JSONObject nodeDetail = (JSONObject) nodes.get(x) ;
				ContentValues values = new ContentValues() ;
				values.put("id", nodeDetail.getInt("id")) ;
				values.put("nodelabel", nodeDetail.has("label")?nodeDetail.getString("label"):null) ;
				values.put("foreignsource", nodeDetail.has("foreignSource")?nodeDetail.getString("foreignSource"):null) ;
				values.put("foreignid", nodeDetail.has("foreignId")?nodeDetail.getInt("foreignId"):null) ;
				Date lastPollTime ;
				if (nodeDetail.has("lastCapsdPoll")) {
					lastPollTime = new Date(nodeDetail.getString("lastCapsdPoll"));
				} else {
					lastPollTime = null ;
				}
				values.put("lastpoll", lastPollTime==null?0:lastPollTime.getTime());
				if (db.insertWithOnConflict("nodes", null, values, SQLiteDatabase.CONFLICT_REPLACE)<0) {
					Log.e("ONMSDataAdapter","Failed to insert row with the following data: "+nodeDetail.toString(4)) ;
				}
			}
		} catch (JSONException jsone) {
			Log.e("ONMSDataAdapter","JSONException occurred while trying to import node data.", jsone) ;
		}
	}

	public void updateNode(JSONObject nodeDetail) {
		try {
			ContentValues values = new ContentValues() ;
			values.put("id", nodeDetail.getInt("id")) ;
			values.put("nodelabel", nodeDetail.has("label")?nodeDetail.getString("label"):null) ;
			values.put("foreignsource", nodeDetail.has("foreignSource")?nodeDetail.getString("foreignSource"):null) ;
			values.put("foreignid", nodeDetail.has("foreignId")?nodeDetail.getInt("foreignId"):null) ;
			Date lastPollTime ;
			if (nodeDetail.has("lastCapsdPoll")) {
				lastPollTime = new Date(nodeDetail.getString("lastCapsdPoll"));
			} else {
				lastPollTime = null ;
			}
			values.put("lastpoll", lastPollTime==null?0:lastPollTime.getTime());
			if (db.insertWithOnConflict("nodes", null, values, SQLiteDatabase.CONFLICT_REPLACE)<0) {
				Log.e("ONMSDataAdapter","Failed to update row with the following data: "+nodeDetail.toString(4)) ;
			}
		} catch (JSONException jsone) {
			Log.e("ONMSDataAdapter","JSONException occurred while trying to read node data.", jsone) ;
		}
	}

	public void insertIpInterfaces(JSONObject intfData) {
		try {
			int nodeCount = intfData.getInt("count") ;
			JSONArray nodes = intfData.getJSONArray("nodes") ;
			for (int x=0; x<nodeCount; x++) {
				JSONObject intfDetail = (JSONObject) nodes.get(x) ;
				ContentValues ipIfValues = new ContentValues() ;
				int ipIfId = intfData.has("id")?intfData.getInt("id"):0 ; 
				if (ipIfId>0) {
					ipIfValues.put("id", ipIfId) ;
					ipIfValues.put("nodeid", intfDetail.has("nodeId")?intfDetail.getInt("nodeId"):0) ;
					ipIfValues.put("ipaddress", intfDetail.has("ipAddress")?intfDetail.getString("ipAddress"):null) ;
					Date lastPoll = null ;
					if (intfDetail.has("lastCapsdPoll")) {
						lastPoll = new Date(intfDetail.getString("lastCapsdPoll")) ;
					} else {
						lastPoll = new Date(0) ;
					}
					ipIfValues.put("lastpoll", lastPoll.getTime()) ;
					if (db.insertWithOnConflict("ipinterface", null, ipIfValues, SQLiteDatabase.CONFLICT_REPLACE)<0) {
						Log.e("ONMSDataAdapter","Failed to update IP interface with data: \n"+intfDetail.toString(4)) ;
					}

					if (intfDetail.has("snmpInterface")) {
						JSONObject snmpData = intfDetail.getJSONObject("snmpInterface") ;
						if (snmpData.has("id")) {
							ContentValues snmpValues = new ContentValues() ;
							snmpValues.put("id", snmpData.getInt("id")) ;
							snmpValues.put("poll", snmpData.has("poll")?snmpData.getString("poll"):null) ;
							snmpValues.put("pollflag", snmpData.has("pollFlag")?snmpData.getString("pollFlag"):null) ;
							snmpValues.put("ifindex", snmpData.has("ifIndex")?snmpData.getInt("ifIndex"):0) ;
							snmpValues.put("collect", snmpData.has("collect")?snmpData.getString("collect"):null) ;
							snmpValues.put("collectflag", snmpData.has("collectFlag")?snmpData.getString("collectFlag"):null) ;
							snmpValues.put("ifadminstatus", snmpData.has("ifAdminStatus")?snmpData.getInt("ifAdminStatus"):0) ;
							snmpValues.put("ifalias", snmpData.has("ifAlias")?snmpData.getString("ifAlias"):null) ;
							snmpValues.put("ifdesc", snmpData.has("ifDescr")?snmpData.getString("ifDescr"):null) ;
							snmpValues.put("ifname", snmpData.has("ifName")?snmpData.getString("ifName"):null) ;
							snmpValues.put("ifoperstatus", snmpData.has("")?snmpData.getInt(""):0) ;
							snmpValues.put("ifspeed", snmpData.has("ifOperStatus")?snmpData.getInt("ifOperStatus"):0) ;
							snmpValues.put("iftype", snmpData.has("ifSpeed")?snmpData.getInt("ifSpeed"):0) ;
							snmpValues.put("ipinterface", ipIfId) ;
							Date lastSnmpPoll ;
							if (snmpData.has("lastCapsdPoll")) {
								lastSnmpPoll = new Date(snmpData.getString("lastCapsdPoll")) ;
							} else {
								lastSnmpPoll = new Date(0) ;
							}
							snmpValues.put("lastpoll", lastSnmpPoll.getTime()) ;
							snmpValues.put("netmask", snmpData.has("netMask")?snmpData.getString("netMask"):null) ;
							snmpValues.put("nodeid", snmpData.has("nodeId")?snmpData.getInt("nodeId"):0) ;
							snmpValues.put("macaddress", snmpData.has("physAddr")?snmpData.getString("physAddr"):null) ;
							if (db.insertWithOnConflict("snmpinterfaces", null, snmpValues, SQLiteDatabase.CONFLICT_REPLACE)<0) {
								Log.e("ONMSDataAdapter","Failed to update SNMP interface with data: \n"+snmpData.toString(4)) ;
							}
						}
					}
				}
			}
		} catch (JSONException jsone) {
			Log.e("ONMSDataAdapter","JSONException occurred while trying to import node data.", jsone) ;
		}
	}

	public void updateIpInterface(JSONObject interface) {
		
	}
}
