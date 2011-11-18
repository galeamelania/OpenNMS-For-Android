package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="categories")
public class Category {

	@DatabaseField(id=true)
	private long id ;

	@DatabaseField(canBeNull=false)
	private String name ;

	@DatabaseField(foreign=true)
	private List<NodeCategories> nodes = new ArrayList<NodeCategories>() ;

	public Category() {
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

	public List<NodeCategories> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodeCategories> nodes) {
		this.nodes = nodes;
	}
}
