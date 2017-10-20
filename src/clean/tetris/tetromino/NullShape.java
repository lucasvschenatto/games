package clean.tetris.tetromino;

import java.util.LinkedList;

import clean.tetris.Context;

public class NullShape extends Tetromino{
	public NullShape(){
		super(makeStates());
	}

	private static LinkedList<int[][]> makeStates() {
		LinkedList<int[][]> states = new LinkedList<int[][]>();
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