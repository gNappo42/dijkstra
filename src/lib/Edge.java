package lib;

public class Edge {

	private static int idCounter = 0;
	private Node a, b;
	private int distance = 0;
	private int id;
	
	public Edge(Node a, Node b, int distance) {
		this.id = idCounter++;
		this.a = a;
		this.b = b;
		this.distance = distance;
	}
	
	public Edge(int id, Node a, Node b, int distance) {
		this.id = id;
		this.a = a;
		this.b = b;
		this.distance = distance;
	}
	
	public Node getA() {
		return this.a;
	}
	
	public Node getB() {
		return this.b;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public int getId() {
		return this.id;
	}
}