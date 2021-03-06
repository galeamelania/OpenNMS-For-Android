package com.zanclus.opennms.api;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.rest.RestClient;

/**
 * A set of static methods for manipulating OpenNMS alarms
 * @author <A HREF="mailto:deven.phillips@gmail.com">Deven Phillips</a>
 *
 */
public class Acknowledgments {

	/**
	 * Returns a list of acknowledgments which match the parameters specified
	 * @param params An instance of {@link RequestParams} which can be empty, but if not, will be used to filter results
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getAcks(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/acks", params, handler) ;
	}

	/**
	 * Returns the acknowledgments specified by id
	 * @param id The numeric ID of the acknowledgment to be retrieved
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getAck(long id, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/acks/"+id, new RequestParams(), handler) ;
	}

	/**
	 * Return a count of acks which match the specifies parameters. This could be terribly slow. Avoid!!! This method supplies plain text to the handler
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getAckCount(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/acks/count", params, handler) ;
	}

	/**
	 * Acknowledges the notification given by notificationId
	 * @param notificationId The numeric identifier of the notification for which to retrieve details
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void AckNotification(long notificationId, AsyncHttpResponseHandler handler) {
		RestClient.restPutRequest("/acks?notifId="+notificationId, new RequestParams(), handler) ;
	}

	/**
	 * Acknowledges the alarm given by alarmId
	 * @param alarmId The numeric identifier of the alarm for which to retrieve details
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void ackAlarm(long alarmId, AsyncHttpResponseHandler handler) {
		RestClient.restPutRequest("/acks?alarmId="+alarmId, new RequestParams(), handler) ;
	}
}
