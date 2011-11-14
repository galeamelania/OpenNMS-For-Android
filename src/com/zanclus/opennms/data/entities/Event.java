package com.zanclus.opennms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="events")
public class Event {

	@DatabaseField(id=true,unique=true)
	private long id;

	@DatabaseField(columnName="createtime")
	private long createTime ;

	@DatabaseField
	private String description;

	@DatabaseField(columnName="nmshost")
	private String onmsHost ;

	@DatabaseField(columnName="logmessage")
	private String logMessage ;

	@DatabaseField
	private String source ;

	@DatabaseField
	private long time ;

	@DatabaseField
	private String uei ;

	@DatabaseField(columnName="ipaddress")
	private String ipAddress ;

	@DatabaseField
	private String severity ;

	@DatabaseField
	private String parms ;

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
}
