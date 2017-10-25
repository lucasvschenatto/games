package clean.tetris.console;

import clean.tetris.Controller;
import clean.tetris.Game;
import clean.tetris.Timer;

public class ConsoleGame extends Game{
	private Controller controller;
	private Timer timer;

	public ConsoleGame() {
		timer = new ConsoleTimer(50);
		ConsoleView view = new ConsoleView();
		controller = new Controller(view, timer);
		timer.setController(controller);
	}

	protected void start() {
		controller.start();
	}
	
}
