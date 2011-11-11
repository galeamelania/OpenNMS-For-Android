package com.zanclus.opennms;

import com.zanclus.opennms.util.StateSingleton;
import android.app.Activity;
import android.os.Bundle;

public class OpenNMSActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;

        // Initialize the state singleton so that it can be retrieved elsewhere without having to provide the Activity instance
        StateSingleton.getInstance(this) ;

        setContentView(R.layout.main);
    }
}