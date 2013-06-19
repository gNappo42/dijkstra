package test;

import java.util.*;
import junit.framework.TestCase;
import lib.*;

public class Testclass extends TestCase {

	private List<Node> pNodes = new ArrayList<Node>();
	private List<Edge> pEdges = new ArrayList<Edge>();
	private Graph pGraph;	
	
	protected void setUp() {
		pNodes.add(new Node(0, "London"));
		pNodes.add(new Node(1, "Berlin"));
		pNodes.add(new Node(2, "Wien"));
		pNodes.add(new Node(3, "Rom"));
		pNodes.add(new Node(4, "Paris"));
		
//		pEdges.add(new Edge(a, b, distance))
	}
	
	public void testNode() {
		Node pNode = new Node(0, "Keks");
		assertEquals(pNode.getName(), "Keks");
		assertEquals(pNode.getId(), 0);
	}
	
	public void testEdge() {
		Edge pEdge = new Edge(0, new Node("Berlin"), new Node("Aachen"), 800);
		assertTrue(pEdge.getA() instanceof Node);
		assertTrue(pEdge.getB() instanceof Node);
		assertEquals(pEdge.getDistance(), 800);
		assertEquals(pEdge.getId(), 0);
	}
	
	public void testGraph() {
		List<Node> pNodes = new ArrayList<Node>();
		pNodes.add(new Node("Berlin"));
		
		List<Edge> pEdges = new ArrayList<Edge>();
		pEdges.add(new Edge(new Node("Berlin"), new Node("Aachen"), 800));
		
		Graph pGraph = new Graph(pNodes, pEdges);
		
		assertTrue(pGraph.getEdges() instanceof ArrayList<?>);
		assertTrue(pGraph.getNodes() instanceof ArrayList<?>);
	}
	
	public void testDijkstraAlg() {
		
	}
	
}
