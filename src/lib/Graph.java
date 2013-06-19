package lib;

import java.util.List;

public class Graph {

	private List<Node> nodes;
	private List<Edge> edges;
		
	public Graph(List<Node> nodes, List<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public List<Node> getNodes() {
		return this.nodes;
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
}
