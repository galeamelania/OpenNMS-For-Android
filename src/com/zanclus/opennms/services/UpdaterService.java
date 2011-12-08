package com.zanclus.opennms.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class UpdaterService extends Service {

	private static final String TAG = UpdaterService.class.getSimpleName() ;

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG,"Bind requested") ;
		return null;
	}

	@Override
	public void onCreate() {
		Log.d(TAG, "UpdaterService created.") ;
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.d(TAG, "UpdaterService started.") ;
		super.onStart(intent, startId);
		
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "UpdaterService is shutting down.") ;
		super.onDestroy();
	}
}
