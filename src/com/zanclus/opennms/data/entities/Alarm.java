package com.zanclus.opennms.data.entities;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="alarms")
@Root(name="alarm")
public class Alarm {

	@DatabaseField(id=true, columnName="id")
	@Attribute(name="id")
	private long alarmId ;
	
	@DatabaseField
	@Attribute(name="severity")
	private String severity ;

	@Attribute(name="count")
	private int count ;

	@DatabaseField
	@Attribute(name="type")
	private long type ;
	
	@DatabaseField
	@Element(name="clearKey", required=false)
	private String clearKey ;
	
	@DatabaseField
	@Element
	private String description ;
	
	@DatabaseField(columnName="firsteventtime")
	@Element(type=Date.class)
	private long firstEventTime ;
	
	@DatabaseField(columnName="ipaddress")
	@Element(required=false)
	private String ipAddress ;
	
	@DatabaseField(foreign=true, canBeNull=true, columnName="lastevent")
	@Element(type=Event.class)
	private Event lastEvent ;
	
	@DatabaseField(columnName="logmessage")
	@Element
	private String logMessage ;
	
	@DatabaseField(columnName="reductionkey")
	@Element
	private String reductionKey ;
	
	@DatabaseField(columnName="suppressedtime")
	@Element(type=Date.class)
	private long suppressedTime ;
	
	@DatabaseField(columnName="suppresseduntil")
	@Element(type=Date.class)
	private long suppressedUntil ;
	
	@DatabaseField
	@Element
	private String uei ;
	
	@DatabaseField(canBeNull=true, columnName="probablecause")
	@Element
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

	public long getFirstTimeEvent() {
		return firstEventTime;
	}

	public void setFirstTimeEvent(long firstEventTime) {
		this.firstEventTime = firstEventTime;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
