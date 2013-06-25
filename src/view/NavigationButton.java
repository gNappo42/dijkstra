package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NavigationButton extends JButton{

	public NavigationButton(String label, ActionListener action) {
		this.setText(label);
		this.addActionListener(action);
	}

}
