package lib;

public class Node {
	
	private static int idCounter = 0;

	private String name;
	private int id;
	
	public Node(String name) {
		this.id = idCounter++;
		this.name = name;
	}
	
	public Node(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
}
