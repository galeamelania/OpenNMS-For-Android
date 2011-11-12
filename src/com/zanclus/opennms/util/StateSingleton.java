package com.zanclus.opennms.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class StateSingleton {

	private static StateSingleton instance ;
	private SharedPreferences prefs = null ;

	protected StateSingleton(Context ctx) {
		super() ;
		prefs = PreferenceManager.getDefaultSharedPreferences(ctx) ;
	}

	public static StateSingleton getInstance(Activity activity) {
		if (instance==null) {
			instance = new StateSingleton(activity) ;
		}

		return instance ;
	}

	public static StateSingleton getInstance() throws NullPointerException {
		if (instance==null) {
			throw new NullPointerException("The current preferences are not initialized. You must call the getInstance(Activity) method at least once before retrieving this instance without arguments.") ;
		}
		return instance ;
	}

	public void setBoolean(String name, boolean value) {
		prefs.edit().putBoolean(name, value).commit() ;
	}

	public void setFloat(String name, float value) {
		prefs.edit().putFloat(name, value).commit() ;
	}

	public void setInt(String name, int value) {
		prefs.edit().putInt(name, value).commit() ;
	}

	public void setLong(String name, long value) {
		prefs.edit().putLong(name, value).commit() ;
	}

	public void setString(String name, String value) {
		prefs.edit().putString(name, value).commit() ;
	}

	public int getInt(String name, int defaultVal) {
		return prefs.getInt(name, defaultVal) ;
	}

	public long getLong(String name, long defaultVal) {
		return prefs.getLong(name, defaultVal) ;
	}

	public boolean getBoolean(String name, boolean defaultVal) {
		return prefs.getBoolean(name, defaultVal) ;
	}

	public String getString(String name, String defaultVal) {
		return prefs.getString(name, defaultVal) ;
	}
}
