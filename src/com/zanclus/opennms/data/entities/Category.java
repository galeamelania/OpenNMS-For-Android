package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="categories")
@Root(name="categories")
public class Category {

	@DatabaseField(id=true)
	@Attribute
	private long id ;

	@DatabaseField(canBeNull=false)
	@Attribute
	private String name ;

	@ElementList(inline=true, name="authorizedGroups", required=false)
	private List<AuthorizedGroup> authorizedGroups ;

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

	public List<AuthorizedGroup> getAuthorizedGroups() {
		return authorizedGroups;
	}

	public void setAuthorizedGroups(List<AuthorizedGroup> authorizedGroups) {
		this.authorizedGroups = authorizedGroups;
	}
}
