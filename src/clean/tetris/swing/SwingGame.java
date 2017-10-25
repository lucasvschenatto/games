package clean.tetris.swing;

import javax.swing.Timer;

import clean.tetris.Controller;
import clean.tetris.Game;

public class SwingGame extends Game{
	private Controller controller;
	private Timer timer;

	public SwingGame() {
		TimeListener listener = new TimeListener();
		timer = new Timer(400, listener);
		SwingView sv = new SwingView(timer);
//		controller = new Controller(sv, timer);
		sv.addKeyListener(new Keyboard(controller));
		listener.setController(controller);
	}
	
	@Override
	public void start() {
		controller.start();
	}

}