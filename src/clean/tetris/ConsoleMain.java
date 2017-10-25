package clean.tetris;

import java.io.IOException;

public class ConsoleMain {

	public static void main(String[] args) throws IOException {
		Game game = new ConsoleGame();
		game.run();
		System.out.println("Terminated");
	}

}
