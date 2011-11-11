package com.zanclus.opennms.rest;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zanclus.opennms.util.StateSingleton;

public final class RestClient {

	/**
	 * Given a ReST request path, connect the configured OpenNMS server and perform the request and return the resulting De-serialized XML Object
	 * @param requestString The path for the ReST request, it will be appended to the protocol, hostname, port, and "/opennms/rest" to create a complete URL.
	 * @param params An instance of RequestParams which contains any HTTP query string parameters for the request
	 * @param callback A class which implements AsyncHttpResponseHandler which should receive the response once the HTTP request is complete.
	 */
	public static void restGetRequest(String requestString, RequestParams params, AsyncHttpResponseHandler callback) {
		AsyncHttpClient client = new AsyncHttpClient() ;
		StateSingleton prefs = StateSingleton.getInstance() ;
		String onmsBaseURL = prefs.getString("protocol", "http")+"://"+prefs.getString("opennms.username","admin")+":"+prefs.getString("opennms.password", "admin")+"@"+prefs.getString("opennms.host", "localhost")+"/opennms/rest" ;
		client.get(onmsBaseURL+requestString, params, callback) ;
	}

	/**
	 * Given a ReST request path, connect the configured OpenNMS server and perform the request and return the resulting De-serialized XML Object
	 * @param requestString The path for the ReST request, it will be appended to the protocol, hostname, port, and "/opennms/rest" to create a complete URL.
	 * @param params An instance of RequestParams which contains any HTTP POST parameters for the request
	 * @param callback A class which implements AsyncHttpResponseHandler which should receive the response once the HTTP request is complete.
	 */
	public static void restPostRequest(String requestString, RequestParams params, AsyncHttpResponseHandler callback) {
		AsyncHttpClient client = new AsyncHttpClient() ;
		StateSingleton prefs = StateSingleton.getInstance() ;
		String onmsBaseURL = prefs.getString("protocol", "http")+"://"+prefs.getString("opennms.username","admin")+":"+prefs.getString("opennms.password", "admin")+"@"+prefs.getString("opennms.host", "localhost")+"/opennms/rest" ;
		client.post(onmsBaseURL+requestString, params, callback) ;
	}

	/**
	 * Given a ReST request path, connect the configured OpenNMS server and perform the request and return the resulting De-serialized XML Object
	 * @param requestString The path for the ReST request, it will be appended to the protocol, hostname, port, and "/opennms/rest" to create a complete URL.
	 * @param params An instance of RequestParams which contains any HTTP POST parameters for the request
	 * @param callback A class which implements AsyncHttpResponseHandler which should receive the response once the HTTP request is complete.
	 */
	public static void restPutRequest(String requestString, RequestParams params, AsyncHttpResponseHandler callback) {
		AsyncHttpClient client = new AsyncHttpClient() ;
		StateSingleton prefs = StateSingleton.getInstance() ;
		String onmsBaseURL = prefs.getString("protocol", "http")+"://"+prefs.getString("opennms.username","admin")+":"+prefs.getString("opennms.password", "admin")+"@"+prefs.getString("opennms.host", "localhost")+"/opennms/rest" ;
		client.put(onmsBaseURL+requestString, params, callback) ;
	}

	/**
	 * Given a ReST request path, connect the configured OpenNMS server and perform the request and return the resulting De-serialized XML Object
	 * @param requestString The path for the ReST request, it will be appended to the protocol, hostname, port, and "/opennms/rest" to create a complete URL.
	 * @param callback A class which implements AsyncHttpResponseHandler which should receive the response once the HTTP request is complete.
	 */
	public static void restDeleteRequest(String requestString, RequestParams params, AsyncHttpResponseHandler callback) {
		AsyncHttpClient client = new AsyncHttpClient() ;
		StateSingleton prefs = StateSingleton.getInstance() ;
		String onmsBaseURL = prefs.getString("protocol", "http")+"://"+prefs.getString("opennms.username","admin")+":"+prefs.getString("opennms.password", "admin")+"@"+prefs.getString("opennms.host", "localhost")+"/opennms/rest" ;
		client.delete(onmsBaseURL+requestString, callback) ;
	}
}
