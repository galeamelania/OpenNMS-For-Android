package com.zanclus.opennms.data.entities;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="interfaceservice")
@Root(name="service")
public class Service {

	@DatabaseField(columnName="id")
	@Attribute
	private int id ;

	@DatabaseField(columnName="status")
	@Attribute
	private String status ;

	@DatabaseField(columnName="ipifaceid")
	@Element
	private int ipInterfaceId ;

	@DatabaseField(columnName="servicetype")
	@Element
	private ServiceType serviceType ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIpInterfaceId() {
		return ipInterfaceId;
	}

	public void setIpInterfaceId(int ipInterfaceId) {
		this.ipInterfaceId = ipInterfaceId;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
}
