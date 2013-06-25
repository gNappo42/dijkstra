package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		JPanel content_panel = new JPanel();
		JPanel navigation_panel = new JPanel();
		//content_panel.setLayout(new GridLayout(5,4));
		
		//content_panel.add(new InputButton(")",this));
		
		NodesController nodes_controller = new NodesController(this);
		EdgesController edges_controller = new EdgesController(this);
		
		//nodes_controller.index(this.graph.getNodes());
		navigation_panel.add(BorderLayout.WEST,new NavigationButton("Locations",nodes_controller));
		navigation_panel.add(BorderLayout.EAST,new NavigationButton("Routes",edges_controller));
		
		this.main_frame.getContentPane().add(BorderLayout.NORTH,content_panel);
		this.main_frame.getContentPane().add(BorderLayout.SOUTH,navigation_panel);
		this.main_frame.setSize(500,200);
		this.main_frame.setVisible(true);

	}

}
