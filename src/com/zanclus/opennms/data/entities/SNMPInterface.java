package com.zanclus.opennms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class SNMPInterface {

	@DatabaseField(columnName="id", id=true)
	private long snmpId ;

	@DatabaseField
	private String poll ;

	@DatabaseField(columnName="pollflag")
	private String pollFlag ;

	@DatabaseField(columnName="ifindex")
	private Integer ifIndex ;

	@DatabaseField
	private String collect ;

	@DatabaseField(columnName="collectflag")
	private String collectFlag ;

	@DatabaseField(columnName="ifadminstatus")
	private Integer ifAdminStatus ;

	@DatabaseField(columnName="ifalias")
	private String ifAlias ;

	@DatabaseField(columnName="ifdescription")
	private String ifDescription ;

	@DatabaseField(columnName="ifname")
	private String ifName ;

	@DatabaseField(columnName="ifoperstatus")
	private Integer ifOperatorStatus ;

	@DatabaseField(columnName="ifspeed")
	private Integer ifSpeed ;

	@DatabaseField(columnName="iftype")
	private Integer ifType ;

	@DatabaseField(columnName="ipinterface")
	private Integer ipInterface ;
	
	@DatabaseField(columnName="lastpoll")
	private Integer lastPoll ;
	
	@DatabaseField
	private String netmask ;
	
	@DatabaseField(foreign=true, canBeNull=true)
	private Node node ;

	@DatabaseField(columnName="macaddr")
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
		return ipInterface;
	}

	public void setIpInterface(Integer ipInterface) {
		this.ipInterface = ipInterface;
	}

	public Integer getLastPoll() {
		return lastPoll;
	}

	public void setLastPoll(Integer lastPoll) {
		this.lastPoll = lastPoll;
	}

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
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
}
