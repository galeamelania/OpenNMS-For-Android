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

	/**
	 * Default constructor
	 * @param context The application's {@link Context}
	 */
	public ONMSDataAdapter(Context context) {
		ctx = context ;
	}

	/**
	 * Opens the database connection and returns an instance of the database adapter.
	 * @return The {@link ONMSDataAdapter} which allow manipulation of the database
	 * @throws SQLException If there is an error connecting to the database
	 */
	public ONMSDataAdapter open() throws SQLException {
		dbHelper = new ONMSDataHelper(ctx) ;
		db = dbHelper.getWritableDatabase() ;
		return this ;
	}

	/**
	 * Closes the database connection
	 */
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

			// Iterate through the node data and insert/update each node in the database
			for (int x=0; x<nodeCount; x++) {
				JSONObject nodeDetail = (JSONObject) nodes.get(x) ;
				ContentValues values = new ContentValues() ;
				long nodeId = nodeDetail.getInt("@id") ;
				values.put("id", nodeId) ;
				values.put("nodelabel", nodeDetail.has("@label")?nodeDetail.getString("@label"):null) ;
				values.put("foreignsource", nodeDetail.has("@foreignSource")?nodeDetail.getString("@foreignSource"):null) ;
				values.put("foreignid", nodeDetail.has("@foreignId")?nodeDetail.getInt("@foreignId"):null) ;
				Date lastPollTime ;
				if (nodeDetail.has("lastCapsdPoll")) {
					lastPollTime = new Date(nodeDetail.getString("lastCapsdPoll"));
				} else {
					lastPollTime = null ;
				}
				values.put("lastpoll", lastPollTime==null?0:lastPollTime.getTime());

				Date createTime ;
				if (nodeDetail.has("createTime")) {
					createTime = new Date(nodeDetail.getString("createTime"));
				} else {
					createTime = null ;
				}
				values.put("createtime", createTime==null?0:createTime.getTime());
				values.put("syscontact", nodeDetail.has("sysContact")?nodeDetail.getString("sysContact"):null) ;
				values.put("location", nodeDetail.has("sysLocation")?nodeDetail.getString("sysLocation"):null) ;
				values.put("sysdescription", nodeDetail.has("sysDescription")?nodeDetail.getString("sysDescription"):null) ;
				values.put("sysname", nodeDetail.has("sysName")?nodeDetail.getString("sysName"):null) ;
				if (db.insertWithOnConflict("nodes", null, values, SQLiteDatabase.CONFLICT_REPLACE)<0) {
					Log.e("ONMSDataAdapter","Failed to insert row with the following data: "+nodeDetail.toString(4)) ;
				}

				// If categories are associated with this node, store that in the categories and nodecategories tables
				if (nodeData.has("categories")) {
					JSONArray categories = nodeData.getJSONArray("categories") ;
					int catCount = categories.length() ;
					for (int y=0; y<catCount; y++) {
						JSONObject category = categories.getJSONObject(y) ;
						if (category.has("@id")) {
							ContentValues catValues = new ContentValues() ;
							ContentValues catNode = new ContentValues() ;
							long catId = category.getInt("@id") ;
							catValues.put("id", catId) ;
							catValues.put("name", category.has("@name")?category.getString("@name"):null) ;
							catNode.put("nodeid", nodeId) ;
							catNode.put("category", catId) ;
							if (db.insertWithOnConflict("categories", null, catValues, SQLiteDatabase.CONFLICT_IGNORE)<0) {
								Log.e("ONMSDataAdapter","Failed to insert/update category with data: \n"+category.toString(4)) ;
							}
							if (db.insertWithOnConflict("nodecategories", null, catNode, SQLiteDatabase.CONFLICT_IGNORE)<0) {
								Log.e("ONMSDataAdapter","Failed to insert/update node/category with data: \n"+category.toString(4)) ;
							}
						}
					}
				}

				// If asset information is associated with this node, store that in the assetrecord table and associate it with this node
				if (nodeData.has("assetRecord")) {
					JSONObject asset = nodeData.getJSONObject("assetRecord") ;
					if (asset.has("node")) {
						ContentValues assetVals = new ContentValues() ;
						assetVals.put("nodeid", asset.getInt("node")) ;
						assetVals.put("address1", asset.has("address1")?asset.getString("address1"):null) ;
						assetVals.put("address2", asset.has("address2")?asset.getString("address2"):null) ;
						assetVals.put("autoenable", asset.has("autoenable")?asset.getString("autoenable"):null) ;
						assetVals.put("building", asset.has("building")?asset.getString("building"):null) ;
						assetVals.put("category", asset.has("category")?asset.getString("category"):null) ;
						assetVals.put("circuitid", asset.has("circuitId")?asset.getString("circuitId"):null) ;
						assetVals.put("city", asset.has("city")?asset.getString("city"):null) ;
						assetVals.put("comment", asset.has("comment")?asset.getString("comment"):null) ;
						assetVals.put("connection", asset.has("connection")?asset.getString("connection"):null) ;
						assetVals.put("dateinstalled", asset.has("dateInstalled")?asset.getString("dateInstalled"):null) ;
						assetVals.put("department", asset.has("department")?asset.getString("department"):null) ;
						assetVals.put("description", asset.has("description")?asset.getString("description"):null) ;
						assetVals.put("displaycategory", asset.has("displayCategory")?asset.getString("displayCategory"):null) ;
						assetVals.put("division", asset.has("division")?asset.getString("division"):null) ;
						assetVals.put("enable", asset.has("enable")?asset.getString("enable"):null) ;
						assetVals.put("floor", asset.has("floor")?asset.getString("floor"):null) ;
						assetVals.put("lastmodifiedby", asset.has("lastModifiedBy")?asset.getString("lastModifiedBy"):null) ;
						assetVals.put("lastmodifieddate", asset.has("lastModifiedDate")?asset.getString("lastModifiedDate"):null) ;
						assetVals.put("lease", asset.has("lease")?asset.getString("lease"):null) ;
						assetVals.put("leaseexpires", asset.has("leaseExpires")?asset.getString("leaseExpires"):null) ;
						assetVals.put("maintcontractexpires", asset.has("maintContractExpiration")?asset.getString("maintContractExpiration"):null) ;
						assetVals.put("maintcontractnumber", asset.has("maintContractNumber")?asset.getString("maintContractNumber"):null) ;
						assetVals.put("modelnumber", asset.has("modelNumber")?asset.getString("modelNumber"):null) ;
						assetVals.put("manufacturer", asset.has("manufacturer")?asset.getString("manufacturer"):null) ;
						assetVals.put("notifycategory", asset.has("notifyCategory")?asset.getString("notifyCategory"):null) ;
						assetVals.put("operatingsystem", asset.has("operatingSystem")?asset.getString("operatingSystem"):null) ;
						assetVals.put("password", asset.has("password")?asset.getString("password"):null) ;
						assetVals.put("pollercategory", asset.has("pollerCategory")?asset.getString("pollerCategory"):null) ;
						assetVals.put("port", asset.has("port")?asset.getString("port"):null) ;
						assetVals.put("rack", asset.has("rack")?asset.getString("rack"):null) ;
						assetVals.put("region", asset.has("region")?asset.getString("region"):null) ;
						assetVals.put("room", asset.has("room")?asset.getString("room"):null) ;
						assetVals.put("serialnumber", asset.has("serialNumber")?asset.getString("serialNumber"):null) ;
						assetVals.put("slot", asset.has("slot")?asset.getString("slot"):null) ;
						assetVals.put("state", asset.has("state")?asset.getString("state"):null) ;
						assetVals.put("supportphone", asset.has("supportPhone")?asset.getString("supportPhone"):null) ;
						assetVals.put("threshcategory", asset.has("thresholdCategory")?asset.getString("thresholdCategory"):null) ;
						assetVals.put("username", asset.has("username")?asset.getString("username"):null) ;
						assetVals.put("vendor", asset.has("vendor")?asset.getString("vendor"):null) ;
						assetVals.put("vendorassetnum", asset.has("vendorAssetNumber")?asset.getString("vendorAssetNumber"):null) ;
						assetVals.put("vendorfax", asset.has("vendorFax")?asset.getString("vendorFax"):null) ;
						assetVals.put("vendorphone", asset.has("vendorPhone")?asset.getString("vendorPhone"):null) ;
						assetVals.put("zip", asset.has("zip")?asset.getString("zip"):null) ;
						if (db.insertWithOnConflict("assetrecord", null, assetVals, SQLiteDatabase.CONFLICT_REPLACE)<0) {
							Log.e("ONMSDataAdapter","Unable to insert/update asset record with data: \n"+asset.toString(4)) ;
						}
					}
				}
			}
		} catch (JSONException jsone) {
			Log.e("ONMSDataAdapter","JSONException occurred while trying to import node data.", jsone) ;
		}
	}

	/**
	 * Update a single node with the data from the {@link JSONObject}
	 * @param nodeDetail A {@link JSONObject} containing details about a single node
	 */
	public void updateNode(JSONObject nodeDetail) {
		try {
			ContentValues values = new ContentValues() ;
			values.put("@id", nodeDetail.getInt("id")) ;
			values.put("nodelabel", nodeDetail.has("@label")?nodeDetail.getString("@label"):null) ;
			values.put("foreignsource", nodeDetail.has("@foreignSource")?nodeDetail.getString("@foreignSource"):null) ;
			values.put("foreignid", nodeDetail.has("@foreignId")?nodeDetail.getInt("@foreignId"):null) ;
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

	/**
	 * Return information about the node specified by nodeId
	 * @param nodeId The numeric ID for the node to retrieve data for
	 * @return A {@link JSONObject} containing the details about the specified node
	 */
	public JSONObject getNodeById(long nodeId) {
		//TODO: Stub Method
		return null ;
	}

	/**
	 * Return information about the node specified by nodeId
	 * @param nodeLabel The text name for the node to retrieve data for
	 * @return A {@link JSONObject} containing the details about the specified node
	 */
	public JSONObject getNodeByName(String nodeLabel) {
		//TODO: Stub Method
		return null ;
	}

	/**
	 * Insert a group of IP interface details into the database
	 * @param intfData A {@link JSONObject} containing 1 or more sets of IP interface details
	 */
	public void insertIpInterfaces(JSONObject intfData) {
		try {
			int nodeCount = intfData.getInt("count") ;
			JSONArray nodes = intfData.getJSONArray("nodes") ;
			for (int x=0; x<nodeCount; x++) {
				JSONObject intfDetail = (JSONObject) nodes.get(x) ;
				ContentValues ipIfValues = new ContentValues() ;
				int ipIfId = intfData.has("@id")?intfData.getInt("@id"):0 ; 
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
						if (snmpData.has("@id")) {
							ContentValues snmpValues = new ContentValues() ;
							snmpValues.put("id", snmpData.getInt("@id")) ;
							snmpValues.put("poll", snmpData.has("@poll")?snmpData.getString("@poll"):null) ;
							snmpValues.put("pollflag", snmpData.has("@pollFlag")?snmpData.getString("@pollFlag"):null) ;
							snmpValues.put("ifindex", snmpData.has("@ifIndex")?snmpData.getInt("@ifIndex"):0) ;
							snmpValues.put("collect", snmpData.has("@collect")?snmpData.getString("@collect"):null) ;
							snmpValues.put("collectflag", snmpData.has("@collectFlag")?snmpData.getString("@collectFlag"):null) ;
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

	/**
	 * Updates a single IP inteface with the data contained in the provided {@link JSONObject} 
	 * @param ipIface A {@link JSONObject} containing details about a single IP interface
	 */
	public void updateIpInterface(JSONObject ipIface) {
		//TODO: Stub Method
	}

	/**
	 * Get the details about a all IP interfaces for a node specified by nodeId
	 * @param nodeId The numeric id for the node to retrieve interface information for
	 * @return A {@link JSONArray} containing the details about the node's IP interfaces
	 */
	public JSONArray getIpInterfacesForNode(long nodeId) {
		//TODO: Stub Method
		return null ;
	}

	/**
	 * Retrieve the details about a single IP interface given it's IP address
	 * @param ipAddr The IP address for which detailed information will be retrieved
	 * @returnA {@link JSONArray} containing the details about the IP interface
	 */
	public JSONObject getInterfaceForAddr(String ipAddr) {
		//TODO: Stub Method
		return null ;
	}

	/**
	 * Associate services with an IP interface specified in the {@link JSONObject}
	 * @param services A {@link JSONObject} containing details about services and their associated interface IDs
	 */
	public void addServicesForInterface(JSONObject services) {
		//TODO: Stub Method
	}

	/**
	 * Returns a {@link JSONArray} containing all associated services for the specified interface ID
	 * @param ifId The numeric ID of the interface for which to retrieve services information
	 * @return A {@link JSONArray} containing the details about the services associated with the given interface ID
	 */
	public JSONArray getServicesForInterface(long ifId) {
		//TODO: Stub Method
		return null ;
	}

	/**
	 * Retrieve a {@link JSONArray} containing information about all nodes associated with a given category
	 * @param category The numeric category identifier for which to filter the node list
	 * @return A {@link JSONArray} containing the details about the nodes which are associated with the specified category
	 */
	public JSONArray getNodesByCategory(int category) {
		//TODO: Stub Method
		return null ;
	}
}
