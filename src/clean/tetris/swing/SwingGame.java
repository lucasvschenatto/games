package clean.tetris.swing;

import clean.tetris.Controller;
import clean.tetris.Game;
import clean.tetris.Timer;

public class SwingGame extends Game{
	private Controller controller;
	private Timer timer;

	public SwingGame() {
		timer = new SwingTimer(400);
		SwingView view = new SwingView();
		controller = new Controller(view, timer);
		timer.setController(controller);
		view.addKeyListener(new Keyboard(controller));
	}
	
	@Override
	public void start() {
		controller.start();
	}

}