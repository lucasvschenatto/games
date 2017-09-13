package cleanCode;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Game extends JFrame {

    JLabel statusbar;


    public Game() {
    	configureWindowAttributes();
        addStatusBar();
        Board board = new Board(getStatusBar());
        add(board);
        board.start();

   }

	private void configureWindowAttributes() {
		setSize(200, 400);
    	setTitle("Tetris");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void addStatusBar() {
		statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
	}

   public JLabel getStatusBar() {
       return statusbar;
   }

 
}