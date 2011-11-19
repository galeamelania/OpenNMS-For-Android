package com.zanclus.opennms.data.entities;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.zanclus.opennms.data.converters.DateConverter;

@DatabaseTable
@Root(name="snmpInterface")
public class SNMPInterface {

	@DatabaseField(columnName="id", id=true)
	@Attribute(name="id")
	private long snmpId ;

	@DatabaseField
	@Attribute
	private String poll ;

	@DatabaseField(columnName="pollflag")
	@Attribute
	private String pollFlag ;

	@DatabaseField(columnName="ifindex")
	@Attribute
	private Integer ifIndex ;

	@DatabaseField
	@Attribute
	private String collect ;

	@DatabaseField(columnName="collectflag")
	@Attribute
	private String collectFlag ;

	@DatabaseField(columnName="ifadminstatus")
	@Element
	private Integer ifAdminStatus ;

	@DatabaseField(columnName="ifalias")
	@Element(required=false)
	private String ifAlias ;

	@DatabaseField(columnName="ifdescription")
	@Element(name="ifDescr")
	private String ifDescription ;

	@DatabaseField(columnName="ifname")
	@Element
	private String ifName ;

	@DatabaseField(columnName="ifoperstatus")
	@Element(name="ifOperStatus")
	private Integer ifOperatorStatus ;

	@DatabaseField(columnName="ifspeed")
	@Element
	private Integer ifSpeed ;

	@DatabaseField(columnName="iftype")
	@Element
	private Integer ifType ;

	@DatabaseField(columnName="ipaddr")
	@Element
	private String ipAddress ;

	@DatabaseField(columnName="ipinterfaces")
	@Element
	private Integer ipInterfaces ;
	
	@DatabaseField(columnName="lastpoll")
	@Element(name="lastCapsdPoll", required=false)
	@Convert(DateConverter.class)
	private Long lastPoll ;
	
	@DatabaseField(columnName="netmask")
	@Element
	private String netMask ;
	
	@DatabaseField(foreign=true, canBeNull=true)
	private Node node ;

	@Element
	private int nodeId ;

	@DatabaseField(columnName="macaddr")
	@Element(name="physAddr", required=false)
	private String macAddress ;

	public SNMPInterface() {
		// Default constructor for ORM-lite
	}

	public long getSnmpId() {
		return snmpId;
	}

	public void setSnmpId(long snmpId) {
		this.snmpId = snmpId;
	}

	public String getPoll() {
		return poll;
	}

	public void setPoll(String poll) {
		this.poll = poll;
	}

	public String getPollFlag() {
		return pollFlag;
	}

	public void setPollFlag(String pollFlag) {
		this.pollFlag = pollFlag;
	}

	public Integer getIfIndex() {
		return ifIndex;
	}

	public void setIfIndex(Integer ifIndex) {
		this.ifIndex = ifIndex;
	}

	public String getCollect() {
		return collect;
	}

	public void setCollect(String collect) {
		this.collect = collect;
	}

	public String getCollectFlag() {
		return collectFlag;
	}

	public void setCollectFlag(String collectFlag) {
		this.collectFlag = collectFlag;
	}

	public Integer getIfAdminStatus() {
		return ifAdminStatus;
	}

	public void setIfAdminStatus(Integer ifAdminStatus) {
		this.ifAdminStatus = ifAdminStatus;
	}

	public String getIfAlias() {
		return ifAlias;
	}

	public void setIfAlias(String ifAlias) {
		this.ifAlias = ifAlias;
	}

	public String getIfDescription() {
		return ifDescription;
	}

	public void setIfDescription(String ifDescription) {
		this.ifDescription = ifDescription;
	}

	public String getIfName() {
		return ifName;
	}

	public void setIfName(String ifName) {
		this.ifName = ifName;
	}

	public Integer getIfOperatorStatus() {
		return ifOperatorStatus;
	}

	public void setIfOperatorStatus(Integer ifOperatorStatus) {
		this.ifOperatorStatus = ifOperatorStatus;
	}

	public Integer getIfSpeed() {
		return ifSpeed;
	}

	public void setIfSpeed(Integer ifSpeed) {
		this.ifSpeed = ifSpeed;
	}

	public Integer getIfType() {
		return ifType;
	}

	public void setIfType(Integer ifType) {
		this.ifType = ifType;
	}

	public Integer getIpInterface() {
		return ipInterfaces;
	}

	public void setIpInterface(Integer ipInterface) {
		this.ipInterfaces = ipInterface;
	}

	public Long getLastPoll() {
		return lastPoll;
	}

	public void setLastPoll(Long lastPoll) {
		this.lastPoll = lastPoll;
	}

	public String getNetMask() {
		return netMask;
	}

	public void setNetMask(String netMask) {
		this.netMask = netMask;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
}
