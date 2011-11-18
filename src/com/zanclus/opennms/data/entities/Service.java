package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="services")
public class Service {

	@DatabaseField(id=true)
	private long id ;

	@DatabaseField(canBeNull=false)
	private String name ;

	@DatabaseField(foreign=true)
	private List<InterfaceServices> ifServices = new ArrayList<InterfaceServices>() ;

	public Service() {
		// Default constructor for ORM-lite
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<InterfaceServices> getIfServices() {
		return ifServices;
	}

	public void setIfServices(List<InterfaceServices> ifServices) {
		this.ifServices = ifServices;
	}
}
