package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="nodes")
public class Node {

	@DatabaseField(columnName="id", id=true, unique=true)
	private long nodeId ;

	@DatabaseField(columnName="nodelabel")
	private String nodeLabel ;

	@DatabaseField(columnName="foreignsource")
	private String foreignSource ;

	@DatabaseField(columnName="foreignid", id=true, unique=true)
	private long foreignId ;

	@DatabaseField(columnName="lastpoll")
	private long lastPoll ;

	@DatabaseField(columnName="createtime")
	private long createTime ;

	@DatabaseField(columnName="syscontact")
	private String sysContact ;

	@DatabaseField
	private String location ;

	@DatabaseField(columnName="sysdescription")
	private String sysDescription ;
	
	@DatabaseField(columnName="sysname")
	private String sysName ;

	@DatabaseField(canBeNull=true, foreign=true)
	private List<Category> categories = new ArrayList<Category>() ;

	@DatabaseField(canBeNull=true, foreign=true)
	private AssetRecord assetRecord ;

	@DatabaseField(canBeNull=true, foreign=true)
	private List<Event> events = new ArrayList<Event>() ;

	public Node() {
		// Default constructor for ORM-lite
	}

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeLabel() {
		return nodeLabel;
	}

	public void setNodeLabel(String nodeLabel) {
		this.nodeLabel = nodeLabel;
	}

	public String getForeignSource() {
		return foreignSource;
	}

	public void setForeignSource(String foreignSource) {
		this.foreignSource = foreignSource;
	}

	public long getForeignId() {
		return foreignId;
	}

	public void setForeignId(long foreignId) {
		this.foreignId = foreignId;
	}

	public long getLastPoll() {
		return lastPoll;
	}

	public void setLastPoll(long lastPoll) {
		this.lastPoll = lastPoll;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getSysContact() {
		return sysContact;
	}

	public void setSysContact(String sysContact) {
		this.sysContact = sysContact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSysDescription() {
		return sysDescription;
	}

	public void setSysDescription(String sysDescription) {
		this.sysDescription = sysDescription;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void addCategory(Category cat) {
		this.categories.add(cat);
	}

	public AssetRecord getAssetRecord() {
		return assetRecord;
	}

	public void setAssetRecord(AssetRecord assetRecord) {
		this.assetRecord = assetRecord;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
