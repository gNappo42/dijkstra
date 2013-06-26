package view;

import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
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
	
	public void init(){
		
		this.main_frame = new JFrame();
		
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Locations", null, create_nodes_panel(), "Shows Locations");
		tabs.addTab("Routes",null,create_routes_panel(), "Shows Edges");
		this.main_frame.getContentPane().add(tabs);
		this.main_frame.setSize(500,200);
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

}
