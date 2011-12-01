package com.zanclus.opennms;

import com.zanclus.opennms.activities.AcknowledgmentsActivity;
import com.zanclus.opennms.activities.AlarmsActivity;
import com.zanclus.opennms.activities.EventsActivity;
import com.zanclus.opennms.activities.NodesActivity;
import com.zanclus.opennms.activities.NotificationsActivity;
import com.zanclus.opennms.activities.OutagesActivity;
import com.zanclus.opennms.adapters.MainMenuListAdapter;
import com.zanclus.opennms.util.StateSingleton;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class OpenNMSActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;

        // Initialize the state singleton so that it can be retrieved elsewhere without having to provide the Activity instance
        StateSingleton.getInstance(this) ;

        setContentView(R.layout.main);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this) ;
        if (sp.getString("onms.host", "").contentEquals("") || 
        		sp.getString("onms.username","").contentEquals("") ||
        		sp.getString("onms.password", "").contentEquals("") ||
        		sp.getString("onms.port","").contentEquals("") ||
        		sp.getString("onms.app_path","").contentEquals("")) {
        	startActivity(new Intent(this, ConfigurationActivity.class)) ;
        }

        final ListView mainMenuList = (ListView) findViewById(R.id.mainMenu) ;
        mainMenuList.setAdapter(new MainMenuListAdapter(this)) ;
        mainMenuList.invalidate() ;
        mainMenuList.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int itemNum, long arg3) {
				@SuppressWarnings("rawtypes")
				Class targetActivity = null ;
				Intent i = new Intent("android.intent.action.VIEW") ;
				switch (itemNum) {
					case 0 :
						targetActivity = OutagesActivity.class ;
						break ;
					case 1 :
						targetActivity = AlarmsActivity.class ;
						break ;
					case 2 :
						targetActivity = NotificationsActivity.class ;
						break ;
					case 3 :
						targetActivity = EventsActivity.class ;
						break ;
					case 4 :
						targetActivity = AcknowledgmentsActivity.class ;
						break ;
					case 5 :
						targetActivity = NodesActivity.class ;
						break ;
					default :
						AlertDialog.Builder builder = new AlertDialog.Builder(OpenNMSActivity.this) ;
						builder.setTitle(R.string.unkMenuOptionAlertTitle) ;
						builder.setMessage(OpenNMSActivity.this.getResources().getString(R.string.unkMenuOptionMsg).replaceAll("||REPLACE||", arg1.toString())) ;
						builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss() ;
							}
						}) ;
						builder.show();
				}

				i.setClass(OpenNMSActivity.this.getApplicationContext(), targetActivity) ;
				startActivity(i) ;
			}
        	
		}) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuItem settings = menu.add(Menu.NONE, 0, 0, "Preferences") ;
    	settings.setIcon(android.R.drawable.ic_menu_preferences) ;
    	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
	    	case 0: 
	    		startActivity(new Intent(this, ConfigurationActivity.class)) ;
	    		return true ;
    	}

    	return false ;
    }

    @Override
    protected void onResume() {
    	super.onResume();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this) ;
        if (sp.getString("onms.host", "").contentEquals("") || 
        		sp.getString("onms.username","").contentEquals("") ||
        		sp.getString("onms.password", "").contentEquals("") ||
        		sp.getString("onms.port","").contentEquals("") ||
        		sp.getString("onms.app_path","").contentEquals("")) {
        	startActivity(new Intent(this, ConfigurationActivity.class)) ;
        }
    }
}