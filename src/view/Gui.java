package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.*;
import lib.Edge;
import lib.Graph;
import lib.Node;

public class Gui {
	
	public Gui(Graph graph){
		this.graph = graph;
	}
	
	private JFrame main_frame;
	private Graph graph;
	
	public JFrame getMainFrame(){
		return this.main_frame;
	}
	
	public Graph getGraph(){
		return this.graph;
	}
	
	public void init() throws IOException{
		
		this.main_frame = new JFrame();
		
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Locations", null, create_nodes_panel(), "Shows Locations");
		tabs.addTab("Routes",null,create_routes_panel(), "Shows Edges");
		tabs.addTab("Mapping", null,create_map_panel(),"Shows Map");
		tabs.setAutoscrolls(true);
		this.main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.main_frame.getContentPane().add(tabs);
		this.main_frame.setSize(800,600);
		this.main_frame.setVisible(true);

	}
	
	public JPanel create_nodes_panel(){
		Object[][] data = new Object[this.getGraph().getNodes().size()+1][3];
		Iterator<Node> nodes_iterator = this.getGraph().getNodes().iterator();
		
		Object[] header_data ={"ID","Name"};
		data[0] = header_data;
		
		int counter = 1;
		while(nodes_iterator.hasNext()){
			Node node = nodes_iterator.next();
			Object[] node_data = {node.getId(),node.getName()};
			data[counter] = node_data;
			counter++;
		}
		
		String[] columnNames = {"ID","Name"};
		
		JTable table = new JTable(data, columnNames);
		
		JPanel content_panel = new JPanel();
		content_panel.add(table);
		return content_panel;
	}
	
	public JPanel create_routes_panel(){
		Object[][] data = new Object[this.getGraph().getEdges().size()+1][4];
		Iterator<Edge> edges_iterator = this.getGraph().getEdges().iterator();
		
		Object[] header_data ={"ID","A","B","Distance"};
		data[0] = header_data;
				
		int counter = 1;
		
		while(edges_iterator.hasNext()){
			Edge edge = edges_iterator.next();
			Object[] node_data = {edge.getId(),edge.getA().getName(),edge.getB().getName(),edge.getDistance()};
			data[counter] = node_data;
			counter++;
		}
		
		String[] columnNames = {"ID","A","B","Distance"};
		
		JTable table = new JTable(data, columnNames);                                         
		JPanel content_panel = new JPanel();
		content_panel.add(table);
		return content_panel;
	}
	
	public JPanel create_map_panel() throws IOException{
		Iterator<Node> nodes_iterator = this.getGraph().getNodes().iterator();
		JButton route = new JButton("Berechnen");
		ArrayList<String> nodes = new ArrayList<String>();
		while(nodes_iterator.hasNext()){
			Node node = nodes_iterator.next();
			nodes.add(node.getName());
		}
		DrawPanel map_panel = new DrawPanel();
		JComboBox<String> start = new JComboBox<String>();
		for (String s : nodes){
			start.addItem(s);
		}
		start.setSelectedIndex(0);
		JComboBox<String> ziel = new JComboBox<String>();
		for (String s : nodes){
			ziel.addItem(s);
		}
		ziel.setSelectedIndex(0);
		File bild = new File("../Dijkstra/map_img/karte.jpg");
		Image map = ImageIO.read(bild);
		map_panel.setImage(map);
		map_panel.add(start);
		map_panel.add(ziel);
		map_panel.add(route);
		return map_panel;
	}
}

class DrawPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image map;
	public void setImage(Image m){
		map = m;
	}
	@Override
	protected void paintComponent (Graphics g){
		super.paintComponent(g);
		g.drawImage(map, 0, 0, this);
	}
}
