package bin;

import java.io.IOException;
import view.Gui;
import lib.*;

public class main {

	/**
	 * @param args
	 * @throws IOException 
	 */
		
	public static void main(String[] args) throws IOException{
		
		Node[] json_nodes = Node.getNodesFromJson("config/nodes.json");
		
		Edge[] json_edges = Edge.getEdgesFromJson("config/edges.json");
		
		Graph graph = new Graph(json_nodes,json_edges);	

		Gui gui = new Gui(graph);
		gui.init();
		
	}

}
