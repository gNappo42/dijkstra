package bin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

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
