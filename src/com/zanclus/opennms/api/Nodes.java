package com.zanclus.opennms.api;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.rest.RestClient;

/**
 * A series of static methods for making Async ReST requests to manipulate OpenNMS nodes
 * @author <a href="mailto: deven.phillips@gmail.com">Deven Phillips</a>
 *
 */
public class Nodes {

	/**
	 * Get a list of nodes from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getNodes(AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes", new RequestParams(), handler) ;
	}

	/**
	 * Get a list of nodes from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNodes(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes", params, handler) ;
	}

	/**
	 * Get a node's details from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 */
	public static void getNode(long nodeId, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId, new RequestParams(), handler) ;
	}

	/**
	 * Get a node's details from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNode(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId, params, handler) ;
	}

	/**
	 * Get a list of node interfaces from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 */
	public static void getNodeIpInterfaces(long nodeId, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/ipinterfaces", new RequestParams(), handler) ;
	}

	/**
	 * Get a list of node interfaces from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNodeIpInterfaces(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/ipinterfaces", params, handler) ;
	}

	/**
	 * Get the details of a node interface from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param ipAddress The IP address of the interface for which you would like details retrieved.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 */
	public static void getNodeIpInterface(long nodeId, String ipAddress, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddress, new RequestParams(), handler) ;
	}

	/**
	 * Get the details of a node interface from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param ipAddress The IP address of the interface for which you would like details retrieved.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNodeIpInterface(long nodeId, String ipAddress, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddress, params, handler) ;
	}

	/**
	 * Get a list of services of an IP interface from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param ipAddress The IP address of the interface for which you would like details retrieved.
	 */
	public static void getInterfaceServices(long nodeId, String ipAddress, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddress+"/services", new RequestParams(), handler) ;
	}

	/**
	 * Get a list of services of an IP interface from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param ipAddress The IP address of the interface for which you would like details retrieved.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getInterfaceServices(long nodeId, String ipAddress, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/ipinterfaces"+ipAddress+"/services", params, handler) ;
	}

	/**
	 * Get the details of a service from an OpenNMS IP Interface and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param ipAddress The IP address of the interface for which you would like details retrieved.
	 */
	public static void getInterfaceService(long nodeId, String ipAddress, String service, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddress+"/services/"+service, new RequestParams(), handler) ;
	}

	/**
	 * Get the details of a service from an OpenNMS IP Interface and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param ipAddress The IP address of the interface for which you would like details retrieved.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getInterfaceService(long nodeId, String ipAddress, String service, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddress+"/services"+service, params, handler) ;
	}

	/**
	 * Get a list of SNMP Interfaces for a node from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 */
	public static void getNodeSnmpInterfaces(long nodeId, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/snmpinterfaces", new RequestParams(), handler) ;
	}

	/**
	 * Get a list of SNMP Interfaces for a node from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNodeSnmpInterfaces(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/snmpinterfaces", params, handler) ;
	}

	/**
	 * Get details of an SNMP interface for a node from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param ifIndex The name of the interface for which you would like the SNMP details retrieved
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 */
	public static void getNodeSnmpInterface(long nodeId, String ifIndex, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/snmpinterfaces/"+ifIndex, new RequestParams(), handler) ;
	}

	/**
	 * Get details of an SNMP interface for a node from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param ifIndex The name of the interface for which you would like the SNMP details retrieved
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNodeSnmpInterface(long nodeId, String ifIndex, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/snmpinterfaces/"+ifIndex, params, handler) ;
	}

	/**
	 * Get a list of cetegories for a node from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 */
	public static void getNodeCategories(long nodeId, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/categories", new RequestParams(), handler) ;
	}

	/**
	 * Get a list of cetegories for a node from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNodeCategories(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/categories", params, handler) ;
	}

	/**
	 * Get a category's details for a node from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param category The category for which you would like details retrieved.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 */
	public static void getNodeCategory(long nodeId, String category, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/categories/"+category, new RequestParams(), handler) ;
	}

	/**
	 * Get a category's details for a node from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param category The category for which you would like details retrieved.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNodeCategory(long nodeId, String category, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/categories/"+category, params, handler) ;
	}

	/**
	 * Get a node's asset information from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 */
	public static void getNodeAssetRecord(long nodeId, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/assetRecord", new RequestParams(), handler) ;
	}

	/**
	 * Get a node's asset information from OpenNMS and have the results returned to the "handler" asynchronously
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param nodeId The numeric identifier for the node which you want the details retrieved.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNodeAssetRecord(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/nodes/"+nodeId+"/assetRecord", params, handler) ;
	}

	/**
	 * POST an XML document which represents a new node to be added to OpenNMS for monitoring
	 * @param params The POST parameters/values to be uploaded, including the XML document describing the host to be added
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void addNode(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPostRequest("/nodes", params, handler) ;
	}

	/**
	 * POST an XML document which represents a new interface to be added to an OpenNMS node for monitoring
	 * @param params The POST parameters/values to be uploaded, including the XML document describing the interface to be added
	 * @param nodeId The numeric ID of the node to which you wish to add the specified interface
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void addIpInterface(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPostRequest("/nodes/"+nodeId, params, handler) ;
	}

	/**
	 * POST an XML document which represents a new service on the specified node/interface
	 * @param params The POST parameters/values to be uploaded, including the XML document describing the service to be added
	 * @param nodeId The numeric ID of the node to which you wish to add the specified service
	 * @param ipAddr The IP address of the interface that you would like to have the specified service monitored on
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void addIpService(long nodeId, String ipAddr, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPostRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddr+"/services", params, handler) ;
	}

	/**
	 * POST an XML document which represents a new interface to be added to an OpenNMS node for monitoring
	 * @param params The POST parameters/values to be uploaded, including the XML document describing the interface to be added
	 * @param nodeId The numeric ID of the node to which you wish to add the specified interface
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void addSnmpInterface(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPostRequest("/nodes/"+nodeId+"/snmpinterfaces", params, handler) ;
	}

	/**
	 * POST an XML document which represents a new interface to be added to an OpenNMS node for monitoring
	 * @param params The POST parameters/values to be uploaded, including the XML document describing the categories to be added
	 * @param nodeId The numeric ID of the node to which you wish to add the specified category
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void addCategory(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPostRequest("/nodes/"+nodeId+"/categories", params, handler) ;
	}

	/**
	 * Delete the node specified by the nodeId
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void deleteNode(long nodeId, AsyncHttpResponseHandler handler) {
		RestClient.restDeleteRequest("/nodes/"+nodeId, new RequestParams(), handler) ;
	}

	/**
	 * Delete the IP interface specified by the node Id and IP address
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param ipAddress The IP address of the interface to be modified
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void deleteIpInterface(long nodeId, String ipAddress, AsyncHttpResponseHandler handler) {
		RestClient.restDeleteRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddress, new RequestParams(), handler) ;
	}

	/**
	 * Delete the service specified by the node ID, IP address, and service name
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param ipAddress The IP address of the interface to be modified
	 * @param service The name of the service to be modified
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void deleteService(long nodeId, String ipAddress, String service, AsyncHttpResponseHandler handler) {
		RestClient.restDeleteRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddress+"/services/"+service, new RequestParams(), handler) ;
	}

	/**
	 * Delete the SNMP interface specified by the node ID and interface name
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param params The form data to be PUT via the HTTP request
	 * @param ifIndex The name of the interface to be modified
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void deleteSnmpInterface(long nodeId, String ifIndex, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restDeleteRequest("/nodes/"+nodeId+"/snmpinterface/"+ifIndex, params, handler) ;
	}

	/**
	 * Remove the specified category from the node identified by node ID
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param params The form data to be PUT via the HTTP request
	 * @param category The name of the category to be modified
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void deleteCategory(long nodeId, String category, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restDeleteRequest("/nodes/"+nodeId+"/categories/"+category, params, handler) ;
	}

	/**
	 * PUT form encoded parameters to modify the specified node ID
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param params The form data to be PUT via the HTTP request
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void setNodeDetails(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPutRequest("/nodes/"+nodeId, params, handler) ;
	}

	/**
	 * PUT form encoded parameters to modify the specified interface ID
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param params The form data to be PUT via the HTTP request
	 * @param ipAddress The IP address of the interface to be modified
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void setIpInterfaceDetails(long nodeId, String ipAddress, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPutRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddress, params, handler) ;
	}

	/**
	 * PUT form encoded parameters to modify the specified service ID
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param params The form data to be PUT via the HTTP request
	 * @param ipAddress The IP address of the interface to be modified
	 * @param service The name of the service to be modified
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void setServiceDetails(long nodeId, String ipAddress, String service, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPutRequest("/nodes/"+nodeId+"/ipinterfaces/"+ipAddress+"/services/"+service, params, handler) ;
	}

	/**
	 * PUT form encoded parameters to modify the specified SNMP interface ID
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param params The form data to be PUT via the HTTP request
	 * @param ifIndex The name of the interface to be modified
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void setSnmpInterfaceDetails(long nodeId, String ifIndex, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPutRequest("/nodes/"+nodeId+"/snmpinterface/"+ifIndex, params, handler) ;
	}

	/**
	 * PUT form encoded parameters to modify the specified category
	 * @param nodeId The numeric identifier for the node to be updated
	 * @param params The form data to be PUT via the HTTP request
	 * @param category The name of the category to be modified
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void setCategory(long nodeId, String category, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPutRequest("/nodes/"+nodeId+"/categories/"+category, params, handler) ;
	}
}
