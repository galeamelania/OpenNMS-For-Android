package com.zanclus.opennms.data;

import java.sql.SQLException;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.zanclus.opennms.R;
import com.zanclus.opennms.data.entities.* ;

public class ORMDataHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "opennms" ;
	private static final int DATABASE_VERSION = 1 ;
	private Context ctx = null ;
	private Dao<Notification, Integer> notificationDao ;
	private Dao<Node, Integer> nodeDao ;
	private Dao<Event, Integer> eventDao ;
	private Dao<Alarm, Integer> alarmDao ;
	private Dao<Category, Integer> categoryDao ;
	private Dao<Outage, Integer> outageDao ;
	private Dao<IPInterface, Integer> ipInterfaceDao ;
	private Dao<SNMPInterface, Integer> snmpInterfaceDao ;
	private Dao<AssetRecord, Integer> assetRecordDao ;
	private Dao<Service, Integer> serviceDao ;

	/**
	 * Default constructor for the {@link ORMDataHelper} class
	 * @param context The application context
	 */
	public ORMDataHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION) ;
		this.ctx = context ;
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource source) {
		StringBuilder sb = new StringBuilder() ;
		try {
			Log.i("ORMDataHelper", "Creating database for OpenNMS") ;
			sb.append("Node") ;
			TableUtils.createTable(source, Node.class) ;
			sb.setLength(0) ;
			sb.append("Event") ;
			TableUtils.createTable(source, Event.class) ;
			sb.setLength(0) ;
			sb.append("Alarm") ;
			TableUtils.createTable(source, Alarm.class) ;
			sb.setLength(0) ;
			sb.append("AssetRecord") ;
			TableUtils.createTable(source, AssetRecord.class) ;
			sb.setLength(0) ;
			sb.append("Category") ;
			TableUtils.createTable(source, Category.class) ;
			sb.setLength(0) ;
			sb.append("IPInterface") ;
			TableUtils.createTable(source, IPInterface.class) ;
			sb.setLength(0) ;
			sb.append("Outage") ;
			TableUtils.createTable(source, Outage.class) ;
			sb.setLength(0) ;
			sb.append("Service") ;
			TableUtils.createTable(source, Service.class) ;
			sb.setLength(0) ;
			sb.append("SNMPInterface") ;
			TableUtils.createTable(source, SNMPInterface.class) ;
		} catch (SQLException sqle) {
			Log.e("ORMDataHelper","Error creating database table for '"+sb.toString()+"'") ;
			AlertDialog.Builder builder = new AlertDialog.Builder(ctx) ;
			builder.setTitle(ctx.getResources().getString(R.string.onms_db_create_error_title)+sb.toString()) ;
			builder.setMessage(ctx.getResources().getString(R.string.onms_db_create_error_message)+sqle.getLocalizedMessage()) ;
			builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss() ;
					// TODO: Place code here to force the application to close.
				}
			}) ;
			builder.show() ;
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource source, int oldVersion, int newVersion) {
		this.onCreate(db, source) ;
	}

	public Dao<Node,Integer> getNodeDao() throws SQLException {
		if (nodeDao==null) {
			nodeDao = getDao(Node.class) ;
		}

		return nodeDao ;
	}

	public Dao<Event,Integer> getEventDao() throws SQLException {
		if (eventDao==null) {
			eventDao = getDao(Event.class) ;
		}

		return eventDao ;
	}

	public Dao<Alarm,Integer> getAlarmDao() throws SQLException {
		if (alarmDao==null) {
			alarmDao = getDao(Alarm.class) ;
		}

		return alarmDao ;
	}

	public Dao<Notification,Integer> getNotificationDao() throws SQLException {
		if (notificationDao==null) {
			notificationDao = getDao(Notification.class) ;
		}

		return notificationDao ;
	}

	public Dao<Outage,Integer> getOutageDao() throws SQLException {
		if (outageDao==null) {
			outageDao = getDao(Outage.class) ;
		}

		return outageDao ;
	}

	public Dao<Category,Integer> getCategoryDao() throws SQLException {
		if (categoryDao==null) {
			categoryDao = getDao(Category.class) ;
		}

		return categoryDao ;
	}

	public Dao<IPInterface,Integer> getIPInterfaceDao() throws SQLException {
		if (ipInterfaceDao==null) {
			ipInterfaceDao = getDao(IPInterface.class) ;
		}

		return ipInterfaceDao ;
	}

	public Dao<SNMPInterface,Integer> getSNMPInterfaceDao() throws SQLException {
		if (snmpInterfaceDao==null) {
			snmpInterfaceDao = getDao(SNMPInterface.class) ;
		}

		return snmpInterfaceDao ;
	}

	public Dao<AssetRecord,Integer> getAssetRecordDao() throws SQLException {
		if (assetRecordDao==null) {
			assetRecordDao = getDao(AssetRecord.class) ;
		}

		return assetRecordDao ;
	}

	public Dao<Service,Integer> getServiceDao() throws SQLException {
		if (serviceDao==null) {
			serviceDao = getDao(Service.class) ;
		}

		return serviceDao ;
	}
}
