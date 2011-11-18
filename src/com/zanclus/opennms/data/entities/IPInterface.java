package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="ipinterface")
public class IPInterface {

	@DatabaseField(id=true)
	private long id ;

	@DatabaseField(columnName="ipaddress")
	private String ipAddress ;

	@DatabaseField(columnName="nodeid", foreign=true, canBeNull=true)
	private Node node ;

	@DatabaseField(columnName="lastpoll", canBeNull=true)
	private long lastPoll ;

	@DatabaseField(foreign=true, canBeNull=true)
	private List<InterfaceServices> services = new ArrayList<InterfaceServices>() ;

	public IPInterface() {
		// Default constructor for ORM-lite
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public long getLastPoll() {
		return lastPoll;
	}

	public void setLastPoll(long lastPoll) {
		this.lastPoll = lastPoll;
	}

	public List<InterfaceServices> getServices() {
		return services;
	}

	public void addService(InterfaceServices service) {
		this.services.add(service) ;
	}
}
