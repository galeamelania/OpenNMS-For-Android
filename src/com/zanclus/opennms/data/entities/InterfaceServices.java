package com.zanclus.opennms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="interfaceservices")
public class InterfaceServices {

	@DatabaseField(generatedId=true, id=true)
	private int id ;

	@DatabaseField(foreign=true)
	private Service service ;

	@DatabaseField(foreign=true)
	private IPInterface iface ;

	public InterfaceServices() {
		// Default constructor for use with ORM-lite
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public IPInterface getIface() {
		return iface;
	}

	public void setIface(IPInterface iface) {
		this.iface = iface;
	}
}
