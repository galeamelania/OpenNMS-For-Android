package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.zanclus.opennms.data.converters.DateConverter;

@DatabaseTable(tableName="ipinterface")
@Root(name="ipInterface")
public class IPInterface {

	@DatabaseField(id=true)
	@Attribute(name="id")
	private long id ;

	@DatabaseField(columnName="snmpprimary")
	@Attribute
	private String snmpPrimary ;

	@DatabaseField(columnName="servicecount")
	@Attribute
	private int monitoredServiceCount ;

	@DatabaseField(columnName="ismonitored")
	@Attribute
	private String isManaged ;

	@DatabaseField(columnName="isdown")
	@Attribute
	private String isDown ;

	@DatabaseField(columnName="ifindex")
	@Attribute(required=false)
	private int ifIndex ;

	@DatabaseField(columnName="ipaddress")
	@Element(name="ipAddress")
	private String ipAddress ;

	@DatabaseField(columnName="nodeid")
	@Element(name="nodeId")
	private int nodeId ;

	@DatabaseField(columnName="hostname")
	@Element
	private String hostName ;

	@DatabaseField(columnName="lastpoll", canBeNull=true)
	@Element(name="lastCapsdPoll")
	@Convert(DateConverter.class)
	private Long lastPoll ;

	@DatabaseField(foreign=true, canBeNull=true)
	private List<InterfaceService> services = new ArrayList<InterfaceService>() ;

	@DatabaseField(foreign=true, canBeNull=true)
	@Element(required=false)
	private SNMPInterface snmpInterface ;

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

	public Long getLastPoll() {
		return lastPoll;
	}

	public void setLastPoll(Long lastPoll) {
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

	public SNMPInterface getSnmpInterface() {
		return snmpInterface;
	}

	public void setSnmpInterface(SNMPInterface snmpInterface) {
		this.snmpInterface = snmpInterface;
	}

	public String getSnmpPrimary() {
		return snmpPrimary;
	}

	public void setSnmpPrimary(String snmpPrimary) {
		this.snmpPrimary = snmpPrimary;
	}

	public int getMonitoredServiceCount() {
		return monitoredServiceCount;
	}

	public void setMonitoredServiceCount(int monitoredServiceCount) {
		this.monitoredServiceCount = monitoredServiceCount;
	}

	public String getIsManaged() {
		return isManaged;
	}

	public void setIsManaged(String isManaged) {
		this.isManaged = isManaged;
	}

	public String getIsDown() {
		return isDown;
	}

	public void setIsDown(String isDown) {
		this.isDown = isDown;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getIfIndex() {
		return ifIndex;
	}

	public void setIfIndex(int ifIndex) {
		this.ifIndex = ifIndex;
	}
}
