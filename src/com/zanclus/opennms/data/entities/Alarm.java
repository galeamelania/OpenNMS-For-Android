package com.zanclus.opennms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="alarms")
public class Alarm {

	@DatabaseField(id=true, columnName="id")
	private long alarmId ;
	
	@DatabaseField
	private String severity ;

	@DatabaseField
	private long type ;
	
	@DatabaseField
	private String clearKey ;
	
	@DatabaseField
	private String description ;
	
	@DatabaseField(foreign=true, canBeNull=true, columnName="firsteventtime")
	private Event firstTimeEvent ;
	
	@DatabaseField(columnName="ipaddress")
	private String ipAddress ;
	
	@DatabaseField(foreign=true, canBeNull=true, columnName="lastevent")
	private Event lastEvent ;
	
	@DatabaseField(columnName="logmessage")
	private String logMessage ;
	
	@DatabaseField(columnName="reductionkey")
	private String reductionKey ;
	
	@DatabaseField(columnName="suppressedtime")
	private long suppressedTime ;
	
	@DatabaseField(columnName="suppresseduntil")
	private long suppressedUntil ;
	
	@DatabaseField
	private String uei ;
	
	@DatabaseField(canBeNull=true, columnName="probablecause")
	private Long probableCause ;

	public Alarm() {
		// Default constructor for ORM-lite
	}

	public long getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(long alarmId) {
		this.alarmId = alarmId;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public String getClearKey() {
		return clearKey;
	}

	public void setClearKey(String clearKey) {
		this.clearKey = clearKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Event getFirstTimeEvent() {
		return firstTimeEvent;
	}

	public void setFirstTimeEvent(Event firstTimeEvent) {
		this.firstTimeEvent = firstTimeEvent;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Event getLastEvent() {
		return lastEvent;
	}

	public void setLastEvent(Event lastEvent) {
		this.lastEvent = lastEvent;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public String getReductionKey() {
		return reductionKey;
	}

	public void setReductionKey(String reductionKey) {
		this.reductionKey = reductionKey;
	}

	public long getSuppressedTime() {
		return suppressedTime;
	}

	public void setSuppressedTime(long suppressedTime) {
		this.suppressedTime = suppressedTime;
	}

	public long getSuppressedUntil() {
		return suppressedUntil;
	}

	public void setSuppressedUntil(long suppressedUntil) {
		this.suppressedUntil = suppressedUntil;
	}

	public String getUei() {
		return uei;
	}

	public void setUei(String uei) {
		this.uei = uei;
	}

	public Long getProbableCause() {
		return probableCause;
	}

	public void setProbableCause(Long probableCause) {
		this.probableCause = probableCause;
	}
}
