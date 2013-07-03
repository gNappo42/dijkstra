package bin;


import java.io.File;
import java.io.FileNotFoundException;
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
	 */
	public static void main(String[] args) {
		File conf_file = new File("config/nodes.json");
		String json_string = "";
        try {
            Scanner scanner = new Scanner(conf_file);
            while (scanner.hasNextLine()) {
            	json_string += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		Gson gson = new Gson();
		
		Node[] json_nodes = gson.fromJson(json_string, Node[].class); 
		System.out.println(json_nodes[0].getName());
		
		
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(json_nodes[0],json_nodes[1],100));
		//edges.add(new Edge(berlin,wien,200));
		//edges.add(new Edge(rom,paris,500));
		
		Graph graph = new Graph(json_nodes,edges);
		
		Iterator<Edge> edges_iterator = graph.getEdges().iterator();
		
		while(edges_iterator.hasNext()){
			Edge edge = edges_iterator.next();
			System.out.println("From "+edge.getA().getName()+" to "+edge.getB().getName()+ "distance "+edge.getDistance());
		}
		
		Gui gui = new Gui(graph);
		gui.init();
		
	}

}
