package clean.tetris;

import javax.swing.Timer;

public class Game {
	private Controller controller;
	private Timer timer;

	public Game() {
		TimeListener listener = new TimeListener();
		timer = new Timer(400, listener);
		SwingView sv = new SwingView(timer);
		controller = new Controller(sv);
		sv.addKeyListener(new Keyboard(controller));
		listener.setController(controller);
	}

	public void start() {
		controller.start();
		timer.start();
	}

}