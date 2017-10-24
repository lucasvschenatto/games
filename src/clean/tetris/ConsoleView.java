package clean.tetris;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

public class ConsoleView extends JFrame implements View {

	private static final long serialVersionUID = 3546972521766333279L;
	private Timer timer;

	public ConsoleView(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void update(List<String> board) {
		for(String line: board)
			System.out.println(line);
		printSeparator();
	}

	private void printSeparator() {
		System.out.println("####################");
	}

	@Override
	public void pause() {
		timer.stop();
		System.out.println("Paused");
		printSeparator();
	}

	@Override
	public void notifyGameOver() {
		System.out.println("Game Over");
		printSeparator();
	}

	@Override
	public void start() {
		timer.start();
		System.out.println("Start");
	}

	@Override
	public void resume() {
		timer.restart();
		System.out.println("Resume");
	}

}
