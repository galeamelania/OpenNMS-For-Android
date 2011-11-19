package com.zanclus.opennms.data.entities;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.zanclus.opennms.data.converters.DateConverter;

@DatabaseTable(tableName="notifications")
@Root(name="notification")
public class Notification {

	@DatabaseField(columnName="id", id=true)
	@Attribute(name="id")
	private long notificationId ;

	@DatabaseField
	@Element
	private String uei ;

	@DatabaseField(columnName="answeredby", canBeNull=true)
	@Element(required=false)
	private String answeredBy ;

	@DatabaseField
	@Element(name="notificationCommand")
	private String command ;

	@DatabaseField(columnName="numericmessage")
	@Element
	private String numericMessage ;

	@DatabaseField(columnName="pagetime")
	@Element
	@Convert(DateConverter.class)
	private Long pageTime ;

	@DatabaseField(columnName="ipaddr", canBeNull=true)
	@Element(required=false)
	private String ipAddress ;

	@DatabaseField(columnName="queueid")
	@Element
	private String queueId ;

	@DatabaseField(columnName="respondtime")
	@Element(required=false)
	@Convert(DateConverter.class)
	private Long respondTime ;

	@DatabaseField
	@Element
	private String subject ;

	@DatabaseField
	@Element(name="textMessage")
	private String message ;

	public Notification() {
		// Default constructor for use with ORM-lite
	}

	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}

	public String getUei() {
		return uei;
	}

	public void setUei(String uei) {
		this.uei = uei;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getNumericMessage() {
		return numericMessage;
	}

	public void setNumericMessage(String numericMessage) {
		this.numericMessage = numericMessage;
	}

	public Long getPageTime() {
		return pageTime;
	}

	public void setPageTime(Long pageTime) {
		this.pageTime = pageTime;
	}

	public String getQueueId() {
		return queueId;
	}

	public void setQueueId(String queueId) {
		this.queueId = queueId;
	}

	public Long getRespondTime() {
		return respondTime;
	}

	public void setRespondTime(Long respondTime) {
		this.respondTime = respondTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAnsweredBy() {
		return answeredBy;
	}

	public void setAnsweredBy(String answeredBy) {
		this.answeredBy = answeredBy;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
