package com.zanclus.opennms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="nodecategories")
public class NodeCategories {

	@DatabaseField(generatedId=true)
	private int id ;

	@DatabaseField(foreign=true, columnName="nodeId")
	private Node node ;

	@DatabaseField(foreign=true, columnName="categoryId")
	private Category category ;

	public NodeCategories() {
		// Default constructor for use with ORM-lite
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
