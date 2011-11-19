package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.zanclus.opennms.data.converters.DateConverter;

@DatabaseTable(tableName="nodes")
@Root(name="node")
public class Node {

	@DatabaseField(columnName="id", id=true, unique=true)
	@Attribute(name="id")
	private long nodeId ;

	@DatabaseField(columnName="nodelabel")
	@Attribute(name="label")
	private String nodeLabel ;

	@DatabaseField(columnName="foreignsource", canBeNull=true)
	@Attribute(required=false)
	private String foreignSource ;

	@DatabaseField(columnName="foreignid", id=true, unique=true, canBeNull=true)
	@Attribute(required=false)
	private long foreignId ;

	@DatabaseField(canBeNull=true)
	@Attribute(required=false)
	private String type ;

	@DatabaseField(columnName="lastpoll")
	@Element(required=false, name="lastCapsdPoll")
	@Convert(DateConverter.class)
	private Long lastPoll ;

	@DatabaseField(columnName="createtime")
	@Element(required=false)
	@Convert(DateConverter.class)
	private Long createTime ;

	@DatabaseField(columnName="labelsource")
	@Element(required=false)
	private String labelSource ;

	@DatabaseField(columnName="syscontact")
	@Element(required=false)
	private String sysContact ;

	@DatabaseField
	@Element(required=false, name="sysLocation")
	private String location ;

	@DatabaseField(columnName="sysdescription")
	@Element(required=false)
	private String sysDescription ;
	
	@DatabaseField(columnName="sysname")
	@Element(required=false)
	private String sysName ;

	@DatabaseField(columnName="sysobjid")
	@Element(required=false)
	private String sysObjectId ;

	@DatabaseField(canBeNull=true, foreign=true, columnName="categories")
	private List<NodeCategories> dbCategories = new ArrayList<NodeCategories>() ;

	@ElementList(required=false, name="categories", inline=true)
	private List<Category> xmlCategories = new ArrayList<Category>() ;

	@DatabaseField(canBeNull=true, foreign=true)
	@Element(required=false)
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

	public Long getLastPoll() {
		return lastPoll;
	}

	public void setLastPoll(Long lastPoll) {
		this.lastPoll = lastPoll;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
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

	public List<NodeCategories> getCategories() {
		return dbCategories;
	}

	public void addCategory(NodeCategories cat) {
		this.dbCategories.add(cat);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabelSource() {
		return labelSource;
	}

	public void setLabelSource(String labelSource) {
		this.labelSource = labelSource;
	}

	public String getSysObjectId() {
		return sysObjectId;
	}

	public void setSysObjectId(String sysObjectId) {
		this.sysObjectId = sysObjectId;
	}

	public List<Category> getXmlCategories() {
		return xmlCategories;
	}

	public void setXmlCategories(List<Category> xmlCategories) {
		this.xmlCategories = xmlCategories;
	}
}
