package com.zanclus.opennms.api;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.rest.RestClient;

/**
 * A set of static methods for manipulating OpenNMS alarms
 * @author <A HREF="mailto:deven.phillips@gmail.com">Deven Phillips</a>
 *
 */
public class Alarms {

	/**
	 * Returns the 10 most recent alarms
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getAlarms(AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/alarms", new RequestParams(), handler) ;
	}

	/**
	 * Return a count of ALL alarms in the database. This could be terribly slow. Avoid!!! This method supplies plain text to the handler
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void getAlarmCount(AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/alarms/count", new RequestParams(), handler) ;
	}

	/**
	 * Return a count of alarms which match the specifies parameters. This could be terribly slow. Avoid!!! This method supplies plain text to the handler
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getAlarmCount(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/alarms/count", params, handler) ;
	}

	/**
	 * Returns the details about the alarm indicated by alarmId
	 * @param alarmId The numeric identifier of the event for which to retrieve details
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 * @param params A Map<String,String> of request parameters to be passed to the HTTP GET request
	 * 		These parameters can be used to filter/order/limit the results of the request.
	 */
	public static void getEvent(long alarmId, AsyncHttpResponseHandler handler) {
		RestClient.restGetRequest("/alarms/"+alarmId, new RequestParams(), handler) ;
	}

	/**
	 * Acknowledges the alarm specified by alarmId
	 * @param alarmId The numeric identifier of the alarm to be acknowledged
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void acknowledgeAlarm(long alarmId, AsyncHttpResponseHandler handler) {
		RestClient.restPutRequest("/alarms/"+alarmId, new RequestParams("ack","true"), handler) ;
	}

	/**
	 * Acknowledges all alarms which match the provided parameters
	 * @param params A Map of parameters to filter which alarms will be acknowledged. 
	 * @param handler An implementation of the AsyncHttpResponseHandler which will handle the results of this request.
	 */
	public static void acknowledgeAlarm(RequestParams params, AsyncHttpResponseHandler handler) {
		RestClient.restPutRequest("/alarms", params, handler) ;
	}
}
