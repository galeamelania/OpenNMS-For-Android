/**
 * 
 */
package com.zanclus.opennms;

import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;

/**
 * @author dphillips
 * 
 */
public class ConfigurationActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.preferences);

		SharedPreferences sp = getPreferenceScreen().getSharedPreferences();

		Preference password = (Preference) findPreference("onms.password");
		password.setSummary(sp.getString("onms.password", "").replaceAll(".", "*"));

		Preference hostname = (Preference) findPreference("onms.host");
		hostname.setSummary(sp.getString("onms.host", getResources().getString(R.string.prefsOnmsHostDialogMessage)));

		Preference username = (Preference) findPreference("onms.username");
		username.setSummary(sp.getString("onms.username", getResources().getString(R.string.prefsUsernameSummary)));

		Preference appPath = (Preference) findPreference("onms.app_path");
		appPath.setSummary(sp.getString("onms.app_path", getResources().getString(R.string.prefsOnmsAppPathSummary)));

		Preference onmsPort = (Preference) findPreference("onms.port");
		int sslDefaultPort = 0 ;
		if (sp.getBoolean("onms.use_ssl", false)) {
			sslDefaultPort = 443 ;
		} else {
			sslDefaultPort = 80 ;
		}
		if (sp.getString("onms.port", "").contentEquals("")) {
			sp.edit().putString("onms.port", sslDefaultPort+"").commit() ;
		} else {
			try {
				sslDefaultPort = Integer.parseInt(sp.getString("onms.port", sslDefaultPort+"")) ;
			} catch (NumberFormatException nfe) {
				Log.e("ConfigurationActivity", getResources().getString(R.string.prefsInvalidPortMessage)) ;
				if (sp.getBoolean("onms.use_ssl", false)) {
					sslDefaultPort = 443 ;
				} else {
					sslDefaultPort = 80 ;
				}
				AlertDialog.Builder builder = new AlertDialog.Builder(this) ;
				builder.setTitle(R.string.prefsInvalidPortTitle) ;
				builder.setMessage(getResources().getString(R.string.prefsInvalidPortMessage).replaceAll("REPLACE", sp.getString("onms.port",""))) ;
				builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss() ;
					}
				}) ;
				builder.show() ;
				sp.edit().putString("onms.port", sslDefaultPort+"").commit() ;
			}
		}
		String portString = sp.getString("onms.port", sslDefaultPort+"") ;
		onmsPort.setSummary(portString);
	}

	@Override
	protected void onPause() {
		getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
		finish();
		super.onPause();
	}

	protected void onResume() {
		super.onResume();
		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}

	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		Preference pref = findPreference(key);
		if (EditTextPreference.class.isInstance(pref)) {
			EditTextPreference etp = (EditTextPreference) pref;
			if (pref.getKey().equals("password")) {
				pref.setSummary(etp.getText().replaceAll(".", "*"));
			} else if (pref.getKey().equals("onms.use_ssl")) {
				String sslDefaultPort = "0" ;
				if (sharedPreferences.getBoolean("onms.use_ssl", false)) {
					sslDefaultPort = "443" ;
				} else {
					sslDefaultPort = "80" ;
				}
				if (sharedPreferences.getString("onms.port", "0").contentEquals("0")) {
					sharedPreferences.edit().putString("onms.port", sslDefaultPort).commit() ;
				}
			} else if (pref.getKey().contentEquals("onms.port")) {
				try {
					Integer.parseInt(etp.getText()) ;
					pref.setSummary(etp.getText()) ;
				} catch (NumberFormatException nfe) {
					Log.e("ConfigurationActivity", getResources().getString(R.string.prefsInvalidPortMessage)) ;
					AlertDialog.Builder builder = new AlertDialog.Builder(this) ;
					builder.setTitle(R.string.prefsInvalidPortTitle) ;
					builder.setMessage(getResources().getString(R.string.prefsInvalidPortMessage).replaceAll("REPLACE", etp.getText())) ;
					String sslDefaultPort = "0" ;
					builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss() ;
						}
					}) ;
					builder.show() ;
					if (sharedPreferences.getBoolean("onms.use_ssl", false)) {
						sslDefaultPort = "443" ;
					} else {
						sslDefaultPort = "80" ;
					}
					sharedPreferences.edit().putString("onms.port", sslDefaultPort+"").commit() ;
				}
			} else {
				pref.setSummary(etp.getText()) ;
			}
		}
	}
}
