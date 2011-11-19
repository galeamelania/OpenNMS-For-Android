package com.zanclus.opennms.data.entities;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.zanclus.opennms.data.converters.DateConverter;

@DatabaseTable(tableName="alarms")
@Root(name="alarm")
public class Alarm {

	@DatabaseField(id=true, columnName="id")
	@Attribute(name="id")
	private int id ;
	
	@DatabaseField
	@Attribute(name="severity")
	private String severity ;

	@DatabaseField(columnName="acktime", canBeNull=true)
	@Element(required=false)
	@Convert(DateConverter.class)
	private Long ackTime ;

	@DatabaseField(columnName="ackuser", canBeNull=true)
	@Element(required=false)
	private String ackUser ;

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

	@DatabaseField(columnName="lastautotime", canBeNull=true)
	@Element(required=false)
	@Convert(DateConverter.class)
	private Long lastAutomationTime ;

	@DatabaseField(columnName="firstautotime", canBeNull=true)
	@Element(required=false)
	@Convert(DateConverter.class)
	private Long firstAutomationTime ;
	
	@DatabaseField(columnName="firsteventtime")
	@Element
	@Convert(DateConverter.class)
	private Long firstEventTime ;
	
	@DatabaseField(columnName="ipaddress")
	@Element(required=false)
	private String ipAddress ;
	
	@DatabaseField(foreign=true, canBeNull=true, columnName="lastevent")
	@Element(type=Event.class, required=false)
	private Event lastEvent ;

	@DatabaseField(columnName="lasteventtime")
	@Element
	@Convert(DateConverter.class)
	private Long lastEventTime ;
	
	@DatabaseField(columnName="logmessage")
	@Element
	private String logMessage ;
	
	@DatabaseField(columnName="reductionkey")
	@Element
	private String reductionKey ;
	
	@DatabaseField(columnName="suppressedtime")
	@Element
	@Convert(DateConverter.class)
	private Long suppressedTime ;
	
	@DatabaseField(columnName="suppresseduntil")
	@Element
	@Convert(DateConverter.class)
	private Long suppressedUntil ;
	
	@DatabaseField
	@Element
	private String uei ;
	
	@DatabaseField(canBeNull=true, columnName="probablecause")
	@Element(name="x733ProbableCause")
	private Long probableCause ;

	@DatabaseField(canBeNull=true, columnName="parms")
	@Element(required=false)
	private String parms ;

	public Alarm() {
		// Default constructor for ORM-lite
	}

	public int getAlarmId() {
		return id;
	}

	public void setAlarmId(int alarmId) {
		this.id = alarmId;
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

	public String getParms() {
		return parms;
	}

	public void setParms(String parms) {
		this.parms = parms;
	}

	public String getAckUser() {
		return ackUser;
	}

	public void setAckUser(String ackUser) {
		this.ackUser = ackUser;
	}

	public long getAckTime() {
		return ackTime;
	}

	public void setAckTime(long ackTime) {
		this.ackTime = ackTime;
	}

	public long getLastAutomationTime() {
		return lastAutomationTime;
	}

	public void setLastAutomationTime(long lastAutomationTime) {
		this.lastAutomationTime = lastAutomationTime;
	}

	public Long getFirstAutomationTime() {
		return firstAutomationTime;
	}

	public void setFirstAutomationTime(Long firstAutomationTime) {
		this.firstAutomationTime = firstAutomationTime;
	}

	public Long getLastEventTime() {
		return lastEventTime;
	}

	public void setLastEventTime(Long lastEventTime) {
		this.lastEventTime = lastEventTime;
	}
}
