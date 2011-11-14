package com.zanclus.opennms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="assetrecords")
public class AssetRecord {

	@DatabaseField(id=true, columnName="nodeid")
	private long nodeId ;

	@DatabaseField
	private String addr1 ;

	@DatabaseField
	private String addr2 ;

	@DatabaseField
	private String autoenable ;

	@DatabaseField
	private String building ;

	@DatabaseField
	private String category ;

	@DatabaseField
	private String circuitId ;

	@DatabaseField
	private String city ;

	@DatabaseField
	private String comment ;

	@DatabaseField
	private String connection ;

	@DatabaseField
	private String dateInstalled ;

	@DatabaseField
	private String department ;

	@DatabaseField
	private String description ;

	@DatabaseField
	private String displayCategory ;

	@DatabaseField
	private String division ;

	@DatabaseField
	private String enable ;

	@DatabaseField
	private String floor ;

	@DatabaseField
	private String lastModifiedBy ;

	@DatabaseField
	private String lastModifiedDate ;

	@DatabaseField
	private String lease ;

	@DatabaseField
	private String leaseExpires ;

	@DatabaseField
	private String maintContractExpires ;

	@DatabaseField
	private String maintContractNum ;

	@DatabaseField
	private String modelNumber ;

	@DatabaseField
	private String manufacturer ;

	@DatabaseField
	private String notifyCategory ;

	@DatabaseField
	private String operatingSystem ;

	@DatabaseField
	private String password ;

	@DatabaseField
	private String pollerCategory ;

	@DatabaseField
	private String port ;

	@DatabaseField
	private String rack ;

	@DatabaseField
	private String region ;

	@DatabaseField
	private String room ;

	@DatabaseField
	private String serialNumber ;

	@DatabaseField
	private String slot ;

	@DatabaseField
	private String state ;

	@DatabaseField
	private String supportPhone ;

	@DatabaseField
	private String thresholdCategory ;

	@DatabaseField
	private String username ;

	@DatabaseField
	private String vendor ;

	@DatabaseField
	private String vendorAssetNumber ;

	@DatabaseField
	private String vendorFax ;

	@DatabaseField
	private String vendorPhone ;

	@DatabaseField
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
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
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
		return maintContractExpires;
	}

	public void setMaintContractExpires(String maintContractExpires) {
		this.maintContractExpires = maintContractExpires;
	}

	public String getMaintContractNum() {
		return maintContractNum;
	}

	public void setMaintContractNum(String maintContractNum) {
		this.maintContractNum = maintContractNum;
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
}
