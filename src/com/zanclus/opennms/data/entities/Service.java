package com.zanclus.opennms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="services")
public class Service {

	@DatabaseField(id=true)
	private long id ;

	@DatabaseField(canBeNull=false)
	private String name ;

	public Service() {
		// Default constructor for ORM-lite
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
