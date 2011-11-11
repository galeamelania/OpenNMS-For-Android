package com.zanclus.opennms;

import com.zanclus.opennms.activities.AcknowledgmentsActivity;
import com.zanclus.opennms.activities.AlarmsActivity;
import com.zanclus.opennms.activities.EventsActivity;
import com.zanclus.opennms.activities.NodesActivity;
import com.zanclus.opennms.activities.NotificationsActivity;
import com.zanclus.opennms.activities.OutagesActivity;
import com.zanclus.opennms.util.StateSingleton;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

        ListView mainMenuList = (ListView) findViewById(R.id.mainMenu) ;
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
}