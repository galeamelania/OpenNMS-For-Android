package com.zanclus.opennms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="outages")
public class Outage {

	@DatabaseField(id=true, columnName="id")
	private long outageId ;

	@DatabaseField(columnName="iflostservice")
	private Long ifLostService ;

	@DatabaseField(canBeNull=true)
	private Long ifRegainedService ;

	@DatabaseField(columnName="ipaddress")
	private String ipAddress ;

	@DatabaseField(columnName="serviceid", canBeNull=true, foreign=true)
	private Service service ;

	@DatabaseField(columnName="servicelostevent", foreign=true)
	private Event serviceLostEvent ;

	@DatabaseField(columnName="serviceregainedevent", canBeNull=true, foreign=true)
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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
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
