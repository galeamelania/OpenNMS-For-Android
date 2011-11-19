package com.zanclus.opennms.data.entities;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="interfaceservices")
@Root(name="services")
public class InterfaceService {

	@DatabaseField(generatedId=true, id=true)
	@Attribute(name="id")
	private int id ;

	@DatabaseField(foreign=true)
	@Element(name="service")
	private ServiceType service ;

	@DatabaseField(foreign=true, columnName="ipifaceid")
	@Element(name="ipInterfaceId")
	private IPInterface iface ;

	@DatabaseField(columnName="status")
	@Attribute(name="status", required=false)
	private String status ;

	public InterfaceService() {
		// Default constructor for use with ORM-lite
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ServiceType getService() {
		return service;
	}

	public void setService(ServiceType service) {
		this.service = service;
	}

	public IPInterface getIface() {
		return iface;
	}

	public void setIface(IPInterface iface) {
		this.iface = iface;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
