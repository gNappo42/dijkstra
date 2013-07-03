package lib;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> nodes;
	private List<Edge> edges;
		
	public Graph(List<Node> nodes, List<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public Graph(Node[] nodes, List<Edge> edges){
		List<Node> nodes_list = new ArrayList<Node>();
		for(int i=0;i<nodes.length;i++){
			nodes_list.add(nodes[i]);
		}
		this.nodes = nodes_list;
		this.edges = edges;
	}
	
	public List<Node> getNodes() {
		return this.nodes;
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
}
