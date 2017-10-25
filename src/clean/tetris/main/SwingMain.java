package clean.tetris.main;

import clean.tetris.Game;
import clean.tetris.swing.SwingGame;

public class SwingMain {

	public static void main(String[] args){
		Game game = new SwingGame();
		game.run();
	}

}
