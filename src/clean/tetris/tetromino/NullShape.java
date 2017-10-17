package clean.tetris.tetromino;

import java.util.ArrayList;
import java.util.List;

import clean.tetris.Context;

public class NullShape extends Tetromino{
	public NullShape(){
		super(makeStates());
	}

	private static List<int[][]> makeStates() {
		List<int[][]> states = new ArrayList<int[][]>();
		states.add(new int[][]{});
		return states;
	}

	public int[] getRgb() {
		return new int[] {0, 0, 0};
	}

	@Override
	public char getCode() {
		return Context.Code.NULLSHAPE.letter;
	}

	@Override
	public int initialYSlack() {
		return 0;
	}
	
}