package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import lib.Node;

public class NodesController implements ActionListener{
	
	private Gui gui;
	
	public NodesController(Gui gui){
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[][] data = new Object[this.gui.getGraph().getNodes().size()][3];
		Iterator<Node> nodes_iterator = this.gui.getGraph().getNodes().iterator();
		int counter = 0;
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
		this.gui.getMainFrame().add(BorderLayout.NORTH, content_panel);
		this.gui.getMainFrame().invalidate();
		this.gui.getMainFrame().validate();
		this.gui.getMainFrame().repaint();
	}
}
