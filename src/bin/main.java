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
		File nodes_file = new File("config/nodes.json");
		String nodes_json = "";
        try {
            Scanner scanner = new Scanner(nodes_file);
            while (scanner.hasNextLine()) {
            	nodes_json += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		Gson gson = new Gson();
		
		Node[] json_nodes = gson.fromJson(nodes_json, Node[].class); 
		
		File edges_file = new File("config/edges.json");
		String edges_json = "";
        try {
            Scanner scanner = new Scanner(edges_file);
            while (scanner.hasNextLine()) {
            	edges_json += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		Edge[] json_edges = gson.fromJson(edges_json, Edge[].class);
		
		Graph graph = new Graph(json_nodes,json_edges);		
/*
		Iterator<Edge> edges_iterator = graph.getEdges().iterator();
		
		while(edges_iterator.hasNext()){
			Edge edge = edges_iterator.next();
			System.out.println(edge.getA());
		}*/
		
		Gui gui = new Gui(graph);
		gui.init();
		
	}

}
