package com.zanclus.opennms.data.entities;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="events")
@Root(name="event")
public class Event {

	@DatabaseField(id=true,unique=true)
	@Attribute(name="id")
	private long id;

	@Attribute(name="log")
	private String logYN ;

	@Attribute(name="display")
	private String displayYN ;

	@DatabaseField(columnName="createtime")
	@Element(name="createTime")
	private long createTime ;

	@DatabaseField
	@Element(name="description")
	private String description;

	@DatabaseField(columnName="nmshost")
	@Element(name="host")
	private String onmsHost ;

	@DatabaseField(columnName="logmessage")
	@Element(name="logMessage")
	private String logMessage ;

	@DatabaseField
	@Element(name="source")
	private String source ;

	@DatabaseField
	@Element(name="time")
	private long time ;

	@DatabaseField
	@Element(name="uei")
	private String uei ;

	@DatabaseField(columnName="ipaddress")
	@Element(name="ipAddress")
	private String ipAddress ;

	@DatabaseField
	@Attribute(name="severity")
	private String severity ;

	@DatabaseField
	@Element(name="parms")
	private String parms ;

	@Element(name="snmp", required=false)
	private String snmp ;

	@Element(name="snmpHost", required=false)
	private String snmpHost ;

	@Element(name="nodeId")
	@DatabaseField(columnName="nodeid")
	private int nodeId ;

	@DatabaseField(canBeNull=true, foreign=true, columnName="nodeid")
	private Node node ;

	public Event() {
		// Default constructor for ORM-lite
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOnmsHost() {
		return onmsHost;
	}

	public void setOnmsHost(String onmsHost) {
		this.onmsHost = onmsHost;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getUei() {
		return uei;
	}

	public void setUei(String uei) {
		this.uei = uei;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getParms() {
		return parms;
	}

	public void setParms(String parms) {
		this.parms = parms;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public String getSnmp() {
		return snmp;
	}

	public void setSnmp(String snmp) {
		this.snmp = snmp;
	}

	public String getSnmpHost() {
		return snmpHost;
	}

	public void setSnmpHost(String snmpHost) {
		this.snmpHost = snmpHost;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public String getLogYN() {
		return logYN;
	}

	public void setLogYN(String logYN) {
		this.logYN = logYN;
	}

	public String getDisplayYN() {
		return displayYN;
	}

	public void setDisplayYN(String displayYN) {
		this.displayYN = displayYN;
	}
}
