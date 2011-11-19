package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="services")
@Root(name="serviceType")
public class ServiceType {

	@DatabaseField(id=true)
	@Attribute(name="id")
	private long id ;

	@DatabaseField(canBeNull=false)
	@Element(name="name")
	private String name ;

	@DatabaseField(foreign=true)
	private List<InterfaceService> ifServices = new ArrayList<InterfaceService>() ;

	public ServiceType() {
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

	public List<InterfaceService> getIfServices() {
		return ifServices;
	}

	public void setIfServices(List<InterfaceService> ifServices) {
		this.ifServices = ifServices;
	}
}
