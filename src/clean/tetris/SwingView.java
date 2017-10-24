package clean.tetris;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class SwingView extends JFrame implements View {
	
	private static final long serialVersionUID = 1020062166016161964L;
	private JLabel statusBar;
	private TetrisJPanel tetrisJPanel;
	private Timer timer;

	public SwingView(Timer timer){
    	this.timer = timer;
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
		statusBar = new JLabel(" 0");
        add(statusBar, BorderLayout.SOUTH);
	}

   public JLabel getStatusBar() {
       return statusBar;
   }
   

	@Override
	public void pause() {
		timer.stop();
		statusBar.setText("paused");
	}

	@Override
	public void notifyGameOver() {
		statusBar.setText("Game Over");
		timer.stop();
	}

	@Override
	public void start() {
		setLocationRelativeTo(null);
	    setVisible(true);
	    timer.start();
	}

	@Override
	public void update(List<String> board) {
		tetrisJPanel.repaintBoard(board);
	}

	@Override
	public void resume() {
		timer.start();
	}

}
