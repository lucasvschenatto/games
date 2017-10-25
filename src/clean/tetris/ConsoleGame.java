package clean.tetris;

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
