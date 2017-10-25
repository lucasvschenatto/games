package clean.tetris.main;

import clean.tetris.Game;
import clean.tetris.console.ConsoleGame;

public class ConsoleMain {

	public static void main(String[] args){
		Game game = new ConsoleGame();
		game.run();
	}

}
