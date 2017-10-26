package clean.tetris.swing;

import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import clean.tetris.View;

public class SwingView extends JFrame implements View {
	
	private static final long serialVersionUID = 1020062166016161964L;
	private JLabel statusBar;
	private TetrisJPanel tetrisJPanel;

	public SwingView(){
		configureWindowAttributes();
        addStatusBar();
        tetrisJPanel = new TetrisJPanel();
        add(tetrisJPanel);
	}
	
	private void configureWindowAttributes() {
		setSize(200, 400);
    	setTitle("Tetris");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void addStatusBar() {
		statusBar = new JLabel();
        add(statusBar, BorderLayout.SOUTH);
	}

   public JLabel getStatusBar() {
       return statusBar;
   }
   

	@Override
	public void pause() {
		statusBar.setText("paused");
	}

	@Override
	public void notifyGameOver() {
		System.out.println("Game Over");
		statusBar.setText("Game Over");
	}

	@Override
	public void start() {
		setLocationRelativeTo(null);
	    setVisible(true);
	}

	@Override
	public void update(List<String> board) {
		tetrisJPanel.repaintBoard(board);
	}

	@Override
	public void resume() {
		statusBar.setText(null);
	}
	
	@Override
	public void addKeyListener(KeyListener listener){
//		super.addKeyListener(listener);
		tetrisJPanel.addKeyListener(listener);
	}

}
