package clean.tetris;

import javax.swing.Timer;

public class ConsoleGame {
	private Controller controller;
	private Timer timer;

	public ConsoleGame() {
		TimeListener listener = new TimeListener();
		timer = new Timer(400, listener);
		ConsoleView sv = new ConsoleView(timer);
		controller = new Controller(sv);
		sv.addKeyListener(new Keyboard(controller));
		listener.setController(controller);
	}

	public void start() {
		controller.start();
	}
	
	public static void main(String[] args){
		ConsoleGame game = new ConsoleGame();
		game.start();
	}
}
