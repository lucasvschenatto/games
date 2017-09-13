package cleanCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeListener implements ActionListener{
	private Board board;
	public TimeListener(Board board){
		this.board = board;
		
	}
	public void actionPerformed(ActionEvent e) {
		board.lineDown();
	}

}
