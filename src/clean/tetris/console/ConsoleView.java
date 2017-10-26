package clean.tetris.console;

import java.util.List;

import clean.tetris.Context;
import clean.tetris.View;

public class ConsoleView implements View {

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
		System.out.println("Paused");
		printSeparator();
	}

	@Override
	public void notifyGameOver() {
		Context.FINISHED = true;
		System.out.println("Game Over");
		printSeparator();
	}

	@Override
	public void start() {
		System.out.println("Start");
	}

	@Override
	public void resume() {
		System.out.println("Resume");
	}

}