package clean.tetris.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clean.tetris.Controller;

public class TimeListener implements ActionListener{
	private Controller controller;
	
	public void actionPerformed(ActionEvent e) {
		controller.next();
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}

}
