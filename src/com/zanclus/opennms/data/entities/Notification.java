package com.zanclus.opennms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="notifications")
public class Notification {
	@DatabaseField(columnName="id", id=true)
	private long notificationId ;

	@DatabaseField
	private String uei ;

	@DatabaseField
	private String command ;

	@DatabaseField(columnName="numericmessage")
	private String numericMessage ;

	@DatabaseField(columnName="pagetime")
	private Integer pageTime ;

	@DatabaseField(columnName="queueid")
	private String queueId ;

	@DatabaseField(columnName="respondtime")
	private Long respondTime ;

	@DatabaseField
	private String subject ;

	@DatabaseField
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

	public Integer getPageTime() {
		return pageTime;
	}

	public void setPageTime(Integer pageTime) {
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
}
