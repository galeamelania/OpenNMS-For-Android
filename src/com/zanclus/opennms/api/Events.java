package com.zanclus.opennms.api;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.rest.RestClient;

/**
 * A set of static methods for manipulating OpenNMS events
 * @author <A HREF="mailto:deven.phillips@gmail.com">Deven Phillips</a>
 *
 */
public class Events {

	/**
	 * Get a list of all events. By default, this method only returns the 10 most recent events so as not to overwhelm the database
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getEvents(AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/events", new RequestParams(), handler) ;
	}

	/**
	 * Get a list of all events. By default, this method only returns the 10 most recent events so as not to overwhelm the database
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getEvents(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/events", params, handler) ;
	}

	/**
	 * Return a count of ALL events in the database. This could be terribly slow. Avoid!!! This method supplies plain text to the handler
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getEventCount(AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/events/count", new RequestParams(), handler) ;
	}

	/**
	 * Return a count of events which match the specifies parameters. This could be terribly slow. Avoid!!! This method supplies plain text to the handler
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getEventCount(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/events/count", params, handler) ;
	}

	/**
	 * Returns the details about the event indicated by eventId
	 * @param eventId The numeric identifier of the event for which to retrieve details
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getEvent(long eventId, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/events/"+eventId, new RequestParams(), handler) ;
	}
}
