package com.zanclus.opennms.rest;

import android.util.Base64;
import android.util.Log;
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
		StateSingleton prefs = StateSingleton.getInstance() ;
		AsyncHttpClient client = new AsyncHttpClient() ;
		String authString = Base64.encodeToString((new String(prefs.getString("onms.username", "admin")+":"+prefs.getString("onms.password", "admin")).getBytes()), Base64.DEFAULT) ;
		Log.d("GET_REQUEST","AuthString: "+authString) ;
		client.addHeader("Authorization", "Basic "+authString) ;
//		client.addHeader("Accept", "application/json") ;
		String protocol = prefs.getBoolean("onms.use_ssl", false)?"https":"http" ;
		String onmsBaseURL = protocol+"://"+prefs.getString("onms.host", "localhost")+":"+prefs.getString("onms.port","80")+"/opennms/rest" ;
		Log.d("GET_REQUEST","BaseURL: "+onmsBaseURL) ;
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
		String authString = Base64.encodeToString((new String(prefs.getString("onms.username", "admin")+":"+prefs.getString("onms.password", "admin")).getBytes()), Base64.DEFAULT) ;
		Log.d("GET_REQUEST","AuthString: "+authString) ;
		client.addHeader("Authorization", "Basic "+authString) ;
//		client.addHeader("Accept", "application/json") ;
		String protocol = prefs.getBoolean("onms.use_ssl", false)?"https":"http" ;
		String onmsBaseURL = protocol+"://"+prefs.getString("onms.host", "localhost")+":"+prefs.getString("onms.port","80")+"/opennms/rest" ;
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
		String authString = Base64.encodeToString((new String(prefs.getString("onms.username", "admin")+":"+prefs.getString("onms.password", "admin")).getBytes()), Base64.DEFAULT) ;
		Log.d("GET_REQUEST","AuthString: "+authString) ;
		client.addHeader("Authorization", "Basic "+authString) ;
//		client.addHeader("Accept", "application/json") ;
		String protocol = prefs.getBoolean("onms.use_ssl", false)?"https":"http" ;
		String onmsBaseURL = protocol+"://"+prefs.getString("onms.host", "localhost")+":"+prefs.getString("onms.port","80")+"/opennms/rest" ;
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
		String authString = Base64.encodeToString((new String(prefs.getString("onms.username", "admin")+":"+prefs.getString("onms.password", "admin")).getBytes()), Base64.DEFAULT) ;
		Log.d("GET_REQUEST","AuthString: "+authString) ;
		client.addHeader("Authorization", "Basic "+authString) ;
//		client.addHeader("Accept", "application/json") ;
		String protocol = prefs.getBoolean("onms.use_ssl", false)?"https":"http" ;
		String onmsBaseURL = protocol+"://"+prefs.getString("onms.host", "localhost")+":"+prefs.getString("onms.port","80")+"/opennms/rest" ;
		client.delete(onmsBaseURL+requestString, callback) ;
	}
}
