package clean.tetris;

import javax.swing.Timer;

public class SwingGame {
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

	public void start() {
		controller.start();
	}

}