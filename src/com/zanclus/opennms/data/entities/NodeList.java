package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="nodes")
public class NodeList {

	@ElementList(name="node", inline=true)
	private List<Node> nodes = new ArrayList<Node>() ;

	@SuppressWarnings("unused")
	@Attribute(name="totalCount")
	private int totalCount ;

	@SuppressWarnings("unused")
	@Attribute(name="count")
	private int count ;

	public NodeList() {
		super() ;
	}

	public int getTotalCount() {
		return nodes.size() ;
	}

	public int getCount() {
		return nodes.size() ;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node node) {
		this.nodes.add(node) ;
	}
}
