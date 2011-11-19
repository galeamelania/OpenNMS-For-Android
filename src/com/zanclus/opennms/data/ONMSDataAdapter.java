package com.zanclus.opennms.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.j256.ormlite.dao.Dao;
import com.zanclus.opennms.data.entities.Category;
import com.zanclus.opennms.data.entities.IPInterface;
import com.zanclus.opennms.data.entities.IPInterfaceList;
import com.zanclus.opennms.data.entities.InterfaceService;
import com.zanclus.opennms.data.entities.Node;
import com.zanclus.opennms.data.entities.NodeCategories;
import com.zanclus.opennms.data.entities.NodeList;
import com.zanclus.opennms.data.entities.Service;
import com.zanclus.opennms.data.entities.ServiceList;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ONMSDataAdapter {

	private Context ctx ;
	private ORMDataHelper dbHelper ;
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
		dbHelper = new ORMDataHelper(ctx) ;
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
	 * Given a {@link NodeList} object which contains a collection of node data, add the nodes to the database.
	 * @param nodeData A {@link NodeList} containing a collection of node information
	 */
	public void addNodes(NodeList nodeData) {

		Dao<Node, Integer> nodeDao = null ;
		try {
			nodeDao = dbHelper.getNodeDao() ;
		} catch (SQLException sqle) {
			Log.e("ONMSDataAdapter", "SQLException encountered while trying to retrieve Node DAO", sqle) ;
		}

		if (nodeDao!=null) {
			for (Node next: nodeData.getNodes()) {
				try {
					if (nodeDao.update(next)==0) {
						nodeDao.createIfNotExists(next) ;
					}
				} catch (SQLException sqle) {
					Log.e("ONMSDataAdapter", "SQLException encountered while inserting/updating records", sqle) ;
				}
			}
		}
	}

	/**
	 * Update a single node with the data from the {@link Node}
	 * @param nodeDetail A {@link Node} containing details about a single node
	 */
	public void updateNode(Node nodeDetail) {
		try {
			dbHelper.getNodeDao().update(nodeDetail) ;
		} catch (SQLException sqle) {
			Log.e("ONMSDataAdapter","SQLException occurred while trying to update node data.", sqle) ;
		}
	}

	/**
	 * Return information about the node specified by nodeId
	 * @param nodeId The numeric ID for the node to retrieve data for
	 * @return A {@link Node} containing the details about the specified node
	 */
	public Node getNodeById(int nodeId) {
		try {
			return dbHelper.getNodeDao().queryForId(nodeId) ;
		} catch (SQLException sqle) {
			Log.e("ONMSDataAdapter","SQLException occurred while trying to retrieve node data.", sqle) ;
		}
		return null ;
	}

	/**
	 * Return information about the node specified by nodeId
	 * @param nodeLabel The text name for the node to retrieve data for
	 * @return A {@link List} of {@link Node} objects containing the details about the matching nodes
	 */
	public List<Node> getNodeByName(String nodeLabel) {
		try {
			Dao<Node, Integer> nodeDao = dbHelper.getNodeDao() ;
			List<Node> nodes = nodeDao.queryForEq("nodeLabel", nodeLabel) ;

			if (nodes!=null) {
				if (nodes.size()!=0) {
					return nodes ;
				}
			}
		} catch (java.sql.SQLException e) {
			Log.e("ONMSDataAdapter","SQLException while attempting to retreive Node", e) ;
		}
		return null ;
	}

	/**
	 * Insert a group of IP interface details into the database
	 * @param intfData A {@link IPInterfaceList} containing 1 or more sets of IP interface details
	 */
	public void insertIpInterfaces(IPInterfaceList intfData) {
		try {
			Dao<IPInterface, Integer> intDao = dbHelper.getIPInterfaceDao() ;
			for (IPInterface next: intfData.getIPInterfaces()) {
				if (intDao.update(next)==0) {
					intDao.createIfNotExists(next) ;
				}
			}
		} catch (SQLException sqle) {
			Log.e("ONMSDataAdapter","SQLException while attempting to load IPInterfaceList", sqle) ;
		}
	}

	/**
	 * Updates a single IP inteface with the data contained in the provided {@link IPInterface} 
	 * @param ipIface A {@link IPInterface} containing details about a single IP interface
	 */
	public void updateIpInterface(IPInterface ipIface) {
		try {
			Dao<IPInterface, Integer> intDao = dbHelper.getIPInterfaceDao() ;
			if (intDao.update(ipIface)==0) {
				intDao.createIfNotExists(ipIface) ;
			}
		} catch (SQLException sqle) {
			Log.e("ONMSDataAdapter","SQLException while attempting to load IPInterfaceList", sqle) ;
		}
	}

	/**
	 * Get the details about a all IP interfaces for a node specified by nodeId
	 * @param nodeId The numeric id for the node to retrieve interface information for
	 * @return A {@link List} of {@link IPInterface} objects containing the details about the node's IP interfaces
	 */
	public List<IPInterface> getIpInterfacesForNode(long nodeId) {
		try {
			Dao<IPInterface, Integer> intfDao = dbHelper.getIPInterfaceDao() ;
			List<IPInterface> interfaces = intfDao.queryForEq("nodeId", nodeId) ;

			if (interfaces!=null) {
				if (interfaces.size()!=0) {
					return interfaces ;
				}
			}
		} catch (java.sql.SQLException e) {
			Log.e("ONMSDataAdapter","SQLException while attempting to retreive IPInterface", e) ;
		}
		return null ;
	}

	/**
	 * Retrieve the details about a single IP interface given it's IP address
	 * @param ipAddr The IP address for which detailed information will be retrieved
	 * @return A {@link IPInterface} containing the details about the IP interface
	 */
	public IPInterface getInterfaceForAddr(String ipAddr) {
		try {
			Dao<IPInterface, Integer> intfDao = dbHelper.getIPInterfaceDao() ;
			List<IPInterface> data = intfDao.queryForEq("ipAddress", ipAddr) ;
			if (data!=null) {
				if (data.size()>0) {
					return data.get(0) ;
				}
			}
		} catch (java.sql.SQLException e) {
			Log.e("ONMSDataAdapter","SQLException while attempting to retreive IPInterface", e) ;
		}
		return null ;
	}

	/**
	 * Associate services with an IP interface specified in the {@link ServiceList}
	 * @param services A {@link ServiceList} containing details about services and their associated interface IDs
	 */
	public void addServicesForInterface(ServiceList services) {
		try {
			Dao<Service, Integer> svcDao = dbHelper.getServiceDao() ;
			for (Service next: services.getService()) {
				if (svcDao.update(next)==0) {
					svcDao.createIfNotExists(next) ;
				}
			}
		} catch (SQLException sqle) {
			Log.e("ONMSDataAdapter","SQLException while attempting to load ServiceList", sqle) ;
		}
	}

	/**
	 * Returns a {@link List} of {@link Service} objects containing all associated services for the specified interface ID
	 * @param ifId The numeric ID of the interface for which to retrieve services information
	 * @return A {@link List} of {@link Service} objects containing the details about the services associated with the given interface ID
	 */
	public List<Service> getServicesForInterface(int ifId) {
		try {
			Dao<IPInterface, Integer> intDao = dbHelper.getIPInterfaceDao() ;
			List<InterfaceService> list = intDao.queryForId(ifId).getServices() ;
			// TODO Complete this method
			for (InterfaceService item: list) {
				
			}
		} catch (SQLException sqle) {
			Log.e("ONMSDataAdapter","SQLException while attempting to load ServiceList", sqle) ;
		}
		return null ;
	}

	/**
	 * Retrieve a {@link List} of {@link Node} objects containing information about all nodes associated with a given category
	 * @param category The numeric category identifier for which to filter the node list
	 * @return A {@link List} of {@link Node} objects containing the details about the nodes which are associated with the specified category
	 */
	public List<Node> getNodesByCategory(int category) {
		try {
			Dao<Category, Integer> catDao = dbHelper.getCategoryDao() ;
			Category cat = catDao.queryForId(category) ;
			List<NodeCategories> catList = cat.getNodes() ;
			if (catList!=null) {
				if (catList.size()>0) {
					ArrayList<Node> nodeList = new ArrayList<Node>() ;
					for (NodeCategories next: catList) {
						nodeList.add(next.getNode()) ;
					}
					return nodeList ;
				}
			}
		} catch (java.sql.SQLException e) {
			Log.e("ONMSDataAdapter","SQLException while attempting to retreive IPInterface", e) ;
		}
		return null ;
	}

	/**
	 * Store the events contained in the {@link JSONObject} events
	 * @param events A {@link JSONObject} containing details about events from OpenNMS
	 */
	public void loadEvents(JSONObject eventData) {
		try {
			if (eventData.has("event")) {
				JSONArray events = eventData.getJSONArray("event") ;
				int eventCount = events.length() ;
				for (int x=0; x<eventCount; x++) {
					JSONObject event = events.getJSONObject(x) ;
					if (event.has("@id")) {
						ContentValues values = new ContentValues() ;
						values.put("id", event.getInt("@id")) ;
						Date createTime ;
						if (event.has("createTime")) {
							createTime = new Date(event.getString("createTime")) ;
						} else {
							createTime = new Date(0) ;
						}
						values.put("createtime", createTime.getTime()) ;
						values.put("description", event.has("description")?event.getString("description"):null) ;
						values.put("nmshost", event.has("host")?event.getString("host"):null) ;
						values.put("logmessage", event.has("logMessage")?event.getString("logMessage"):null) ;
						values.put("source", event.has("source")?event.getString("source"):null) ;
						Date eventTime ;
						if (event.has("time")) {
							eventTime = new Date(event.getString("createTime")) ;
						} else {
							eventTime = new Date(0) ;
						}
						values.put("time", eventTime.getTime()) ;
						values.put("uei", event.has("uei")?event.getString("uei"):null) ;
						values.put("parms", event.has("parms")?event.getString("parms"):null) ;
						values.put("severity", event.has("@severity")?event.getString("@severity"):null) ;
						values.put("ipaddress", event.has("ipAddress")?event.getString("ipAddress"):null) ;
						values.put("nodeid", event.has("")?event.getString(""):null) ;
						if (db.insertWithOnConflict("events", null, values, SQLiteDatabase.CONFLICT_REPLACE)<0) {
							Log.e("ONMSDataAdapter","Failed to add event with data: \n"+event.toString(4)) ;
						}
					}
				}
			}
		} catch (JSONException jsone) {
			Log.e("ONMSDataAdapter","JSONException occurred while trying to import event data.", jsone) ;
		}
	}

	/**
	 * Given a {@link JSONObject}, parse the object and load the outage data into the database
	 * @param outages A {@link JSONObject} containing outage information.
	 */
	public void loadOutages(JSONObject outages) {
		
	}
}
