package com.zanclus.opennms.data.entities;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="outages")
@Root(name="outage")
public class Outage {

	@DatabaseField(id=true, columnName="id")
	@Attribute(name="id")
	private long outageId ;

	@DatabaseField(columnName="iflostservice")
	@Element(name="ifLostService",type=Date.class)
	private Long ifLostService ;

	@DatabaseField(canBeNull=true)
	@Element(name="ifRegainedService", type=Date.class)
	private Long ifRegainedService ;

	@DatabaseField(columnName="ipaddress")
	@Element(name="ipAddress")
	private String ipAddress ;

	@DatabaseField(foreign=true)
	@Element(name="monitoredService")
	private InterfaceService service ;

	@DatabaseField(columnName="servicelostevent", foreign=true)
	@Element(name="serviceLostEvent")
	private Event serviceLostEvent ;

	@DatabaseField(columnName="serviceregainedevent", canBeNull=true, foreign=true)
	@Element(name="serviceRegainedEvent", required=false)
	private Event serviceRegainedEvent ;

	public Outage() {
		// Default constructor for ORM-lite
	}

	public long getOutageId() {
		return outageId;
	}

	public void setOutageId(long outageId) {
		this.outageId = outageId;
	}

	public Long getIfLostService() {
		return ifLostService;
	}

	public void setIfLostService(Long ifLostService) {
		this.ifLostService = ifLostService;
	}

	public Long getIfRegainedService() {
		return ifRegainedService;
	}

	public void setIfRegainedService(Long ifRegainedService) {
		this.ifRegainedService = ifRegainedService;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public InterfaceService getService() {
		return service;
	}

	public void setService(InterfaceService service) {
		this.service = service;
	}

	public Event getServiceLostEvent() {
		return serviceLostEvent;
	}

	public void setServiceLostEvent(Event serviceLostEvent) {
		this.serviceLostEvent = serviceLostEvent;
	}

	public Event getServiceRegainedEvent() {
		return serviceRegainedEvent;
	}

	public void setServiceRegainedEvent(Event serviceRegainedEvent) {
		this.serviceRegainedEvent = serviceRegainedEvent;
	}
}
