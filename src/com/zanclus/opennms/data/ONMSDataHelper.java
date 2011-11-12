package com.zanclus.opennms.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ONMSDataHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "opennms" ;
	private static final int DATABASE_VERSION = 1 ;

	public ONMSDataHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION) ;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE node (" +
				"id integer primary key," +
				"nodelabel text," +
				"foreignsource text," +
				"foreignid integer," +
				"lastpoll integer," +
				"createtime integer," +
				"syscontact text," +
				"location text," +
				"sysdescription text," +
				"sysname text" +
			");") ;
		db.execSQL("CREATE TABLE ipinterface (" +
				"id integer primary key," +
				"ipaddress TEXT,"+
				"nodeid integer not null," +
				"lastpoll integer" +
			");") ;
		db.execSQL("CREATE TABLE interface_services (" +
				"id integer primary key autoincrement," +
				"interface integer not null," +
				"service integer not null" +
			");") ;
		db.execSQL("CREATE TABLE services (" +
				"id integer primary key," +
				"name text not null" +
			") ;") ;

		db.execSQL("CREATE TABLE categories (" +
				"id integer primary key," +
				"name text not null" +
			");") ;

		db.execSQL("CREATE TABLE nodecategories (" +
				"nodeid integer primary key," +
				"category integer not null" +
			");") ;

		db.execSQL("CREATE TABLE assetrecord (" +
				"nodeid integer primary key," +
				"address1 text," +
				"address2 text," +
				"autoenable text," +
				"building text," +
				"category text," +
				"circuitid text," +
				"city text," +
				"comment text," +
				"connection text," +
				"dateinstalled text," +
				"department text," +
				"description text," +
				"displaycategory text," +
				"division text," +
				"enable text," +
				"floor text," +
				"lastmodifiedby text," +
				"lastmodifieddate text," +
				"lease text," +
				"leaseexpires text," +
				"maintcontractexpires text," +
				"maintcontractnumber text," +
				"modelnumber text," +
				"manufacturer text," +
				"notifycategory text," +
				"operatingsystem text," +
				"password text," +
				"pollercategory text," +
				"port text," +
				"rack text," +
				"region text," +
				"room text," +
				"serialnumber text," +
				"slot text," +
				"state text," +
				"supportphone text," +
				"threshcategory text," +
				"username text," +
				"vendor text," +
				"vendorassetnum text," +
				"vendorfax text," +
				"vendorphone text," +
				"zip text" +
			") ;") ;
		
		db.execSQL("CREATE DATABASE events (" +
				"id integer primary key," +
				"createtime integer," +
				"description text," +
				"nmshost text," +
				"logmessage text," +
				"source text," +
				"time integer," +
				"uei text," +
				"ipaddress text," +
				"nodeid integer" +
			") ;") ;
		
		db.execSQL("CREATE TABLE alarms (" +
				"id integer primary key," +
				"severity text," +
				"type integer," +
				"clearkey text," +
				"description text," +
				"firsteventtime integer," +
				"ipaddress text," +
				"lastevent integer," +
				"logmessage text," +
				"reductionkey text," +
				"suppressedtime integer," +
				"suppresseduntil integer," +
				"uei text," +
				"probablecause integer" +
			") ;") ;
		
		db.execSQL("CREATE TABLE acks (" +
				"action text," +
				"acktime integer," +
				"type text," +
				"user text," +
				"id integer primary key," +
				"reference integer" +
			") ;") ;
		
		db.execSQL("CREATE TABLE notifications (" +
				"id integer primary key," +
				"uei text," +
				"command text," +
				"numericmessage text," +
				"pagetime integer," +
				"queueid text," +
				"respondtime integer," +
				"subject text," +
				"message text" +
			") ;") ;
		
		db.execSQL("CREATE TABLE outages (" +
				"id integer primary key," +
				"iflostservice integer," +
				"ifregainedservice integer," +
				"ipaddress text," +
				"serviceid integer," +
				"servicelostevent integer," +
				"regainedevent integer" +
			") ;") ;
		
		db.execSQL("CREATE TABLE snmpinterfaces (" +
				"id integer primary key," +
				"poll text," +
				"pollflag text," +
				"ifindex integer," +
				"collect text," +
				"collectflag text," +
				"ifadminstatus integer," +
				"ifalias text," +
				"ifdesc text," +
				"ifname text," +
				"ifoperstatus integer," +
				"ifspeed integer," +
				"iftype integer," +
				"ipinterface integer," +
				"lastpoll integer," +
				"netmask text," +
				"nodeid integer," +
				"macaddress text" +
			") ;") ;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
