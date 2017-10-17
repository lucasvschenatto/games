package clean.tetris.tetromino;

import java.util.ArrayList;
import java.util.List;

import clean.tetris.Context;

public class SquareShape extends Tetromino{
	public SquareShape(){
		super(makeStates());
	}  	

	private static List<int[][]> makeStates() {
		List<int[][]> states = new ArrayList<int[][]>();
		states.add(new int[][]{ {-1, 0}, {-1, 1 }, {0, 0 }, {0, 1} } );
		return states;
	}  	

	public int[] getRgb() {
		return new int[] {204, 102, 204};
	}

	@Override
	public char getCode() {
		return Context.Code.SQUARE.letter;
	}

	@Override
	public int initialYSlack() {
		return 0;
	}
}