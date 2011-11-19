package com.zanclus.opennms.data.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="assetrecords")
@Root(name="assetRecord")
public class AssetRecord {

	@DatabaseField(id=true, columnName="nodeid")
	@Element(required=false, name="node")
	private long nodeId ;

	@DatabaseField(columnName="assetnumber", canBeNull=true)
	@Element(required=false)
	private String assetNumber ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String address1 ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String address2 ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String autoenable ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String building ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String category ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String circuitId ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String city ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String comment ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String connection ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String dateInstalled ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String department ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String description ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String displayCategory ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String division ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String enable ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String floor ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String lastModifiedBy ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String lastModifiedDate ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String lease ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String leaseExpires ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String maintContractExpiration ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String maintContractNumber ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String modelNumber ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String manufacturer ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String notifyCategory ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String operatingSystem ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String password ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String pollerCategory ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String port ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String rack ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String region ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String room ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String serialNumber ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String slot ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String state ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String supportPhone ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String thresholdCategory ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String username ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String vendor ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String vendorAssetNumber ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String vendorFax ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String vendorPhone ;

	@DatabaseField(canBeNull=true)
	@Element(required=false)
	private String zip ;

	public AssetRecord() {
		// Default constructor for ORM-lite
	}

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public String getAddr1() {
		return address1;
	}

	public void setAddr1(String addr1) {
		this.address1 = addr1;
	}

	public String getAddr2() {
		return address2;
	}

	public void setAddr2(String addr2) {
		this.address2 = addr2;
	}

	public String getAutoenable() {
		return autoenable;
	}

	public void setAutoenable(String autoenable) {
		this.autoenable = autoenable;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCircuitId() {
		return circuitId;
	}

	public void setCircuitId(String circuitId) {
		this.circuitId = circuitId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getDateInstalled() {
		return dateInstalled;
	}

	public void setDateInstalled(String dateInstalled) {
		this.dateInstalled = dateInstalled;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayCategory() {
		return displayCategory;
	}

	public void setDisplayCategory(String displayCategory) {
		this.displayCategory = displayCategory;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLease() {
		return lease;
	}

	public void setLease(String lease) {
		this.lease = lease;
	}

	public String getLeaseExpires() {
		return leaseExpires;
	}

	public void setLeaseExpires(String leaseExpires) {
		this.leaseExpires = leaseExpires;
	}

	public String getMaintContractExpires() {
		return maintContractExpiration;
	}

	public void setMaintContractExpires(String maintContractExpires) {
		this.maintContractExpiration = maintContractExpires;
	}

	public String getMaintContractNum() {
		return maintContractNumber;
	}

	public void setMaintContractNum(String maintContractNum) {
		this.maintContractNumber = maintContractNum;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getNotifyCategory() {
		return notifyCategory;
	}

	public void setNotifyCategory(String notifyCategory) {
		this.notifyCategory = notifyCategory;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPollerCategory() {
		return pollerCategory;
	}

	public void setPollerCategory(String pollerCategory) {
		this.pollerCategory = pollerCategory;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getRack() {
		return rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSupportPhone() {
		return supportPhone;
	}

	public void setSupportPhone(String supportPhone) {
		this.supportPhone = supportPhone;
	}

	public String getThresholdCategory() {
		return thresholdCategory;
	}

	public void setThresholdCategory(String thresholdCategory) {
		this.thresholdCategory = thresholdCategory;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendorAssetNumber() {
		return vendorAssetNumber;
	}

	public void setVendorAssetNumber(String vendorAssetNumber) {
		this.vendorAssetNumber = vendorAssetNumber;
	}

	public String getVendorFax() {
		return vendorFax;
	}

	public void setVendorFax(String vendorFax) {
		this.vendorFax = vendorFax;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}
}
