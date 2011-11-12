package com.zanclus.opennms.api;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.rest.RestClient;

/**
 * A set of static methods for viewing OpenNMS outages
 * @author <A HREF="mailto:deven.phillips@gmail.com">Deven Phillips</a>
 *
 */
public class Outages {

	/**
	 * Returns the 10 most recent outages
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getOutages(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/outages", params, handler) ;
	}

	/**
	 * Return a count of ALL outages in the database. This could be terribly slow. Avoid!!! This method supplies plain text to the handler
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getOutageCount(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/outages/count", params, handler) ;
	}

	/**
	 * Return details about the outage specified by outageId
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param outageId The numeric ID of the outage for which to retrieve information
	 */
	public static void getOutage(long outageId, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/outages/"+outageId, new RequestParams(), handler) ;
	}

	/**
	 * Returns the 10 most recent outages for the specified node ID
	 * @param nodeId The numeric ID of the node for which to retrieve outage information
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getOutagesForNode(long nodeId, RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/outages/forNode/"+nodeId, params, handler) ;
	}
}
