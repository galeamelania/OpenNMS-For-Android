package com.zanclus.opennms.data.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="groups")
@Root(name="authorizedGroups")
public class AuthorizedGroup {

	@DatabaseField(columnName="group")
	@Element(required=false)
	private String authorizedGroups ;

	public String getAuthorizedGroups() {
		return authorizedGroups;
	}

	public void setAuthorizedGroups(String authorizedGroups) {
		this.authorizedGroups = authorizedGroups;
	}
}
