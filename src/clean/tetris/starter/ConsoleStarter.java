package clean.tetris.starter;

import clean.tetris.Game;
import clean.tetris.console.ConsoleGame;

public class ConsoleStarter {

	public static void main(String[] args){
		Game game = new ConsoleGame();
		game.run();
	}

}
