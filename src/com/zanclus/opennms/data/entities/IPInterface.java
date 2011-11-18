package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="ipinterface")
@Root(name="ipInterface")
public class IPInterface {

	@DatabaseField(id=true)
	@Attribute(name="id")
	private long id ;

	@DatabaseField(columnName="ipaddress")
	@Element(name="ipAddress")
	private String ipAddress ;

	@DatabaseField(columnName="nodeid")
	@Element(name="nodeId")
	private int nodeId ;

	@DatabaseField(columnName="nodeid", foreign=true, canBeNull=true)
	private Node node ;

	@DatabaseField(columnName="lastpoll", canBeNull=true)
	@Element(name="lastCapsdPoll", type=Date.class)
	private long lastPoll ;

	@DatabaseField(foreign=true, canBeNull=true)
	private List<InterfaceService> services = new ArrayList<InterfaceService>() ;

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

	public List<InterfaceService> getServices() {
		return services;
	}

	public void addService(InterfaceService service) {
		this.services.add(service) ;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
}
