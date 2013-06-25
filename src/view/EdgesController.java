package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTable;

import lib.Edge;
import lib.Node;

public class EdgesController implements ActionListener{
	
	private Gui gui;
	
	public EdgesController(Gui gui){
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[][] data = new Object[this.gui.getGraph().getEdges().size()][4];
		Iterator<Edge> edges_iterator = this.gui.getGraph().getEdges().iterator();
		int counter = 0;
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
		this.gui.getMainFrame().add(BorderLayout.NORTH, content_panel);
		this.gui.getMainFrame().invalidate();
		this.gui.getMainFrame().validate();
		this.gui.getMainFrame().repaint();
	}

}
