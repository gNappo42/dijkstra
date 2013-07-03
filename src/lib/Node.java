package lib;

public class Node {
	
	private static int idCounter = 0;

	private String name;
	private int id;
	private int position_x = 0;
	private int position_y = 0;
	
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

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}

	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
}
