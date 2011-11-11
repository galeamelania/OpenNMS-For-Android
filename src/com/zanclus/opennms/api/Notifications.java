package com.zanclus.opennms.api;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.rest.RestClient;

/**
 * A set of static methods for manipulating OpenNMS notifications
 * @author <A HREF="mailto:deven.phillips@gmail.com">Deven Phillips</a>
 *
 */
public class Notifications {

	/**
	 * Returns a list of notifications which match the parameters specified
	 * @param params An instance of {@link RequestParams} which can be empty, but if not, will be used to filter results
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getNotifications(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/notifications", params, handler) ;
	}

	/**
	 * Returns the notification specified by id
	 * @param id The numeric ID of the notification to be retrieved
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getNotification(long id, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/notifications/"+id, new RequestParams(), handler) ;
	}

	/**
	 * Return a count of notifications which match the specifies parameters. This could be terribly slow. Avoid!!! This method supplies plain text to the handler
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getNotificationCount(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/notifications/count", params, handler) ;
	}
}
