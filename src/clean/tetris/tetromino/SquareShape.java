package clean.tetris.tetromino;

import java.util.LinkedList;

import clean.tetris.Context;

public class SquareShape extends Tetromino{
	public SquareShape(){
		super(makeStates());
	}  	

	private static LinkedList<int[][]> makeStates() {
		LinkedList<int[][]> states = new LinkedList<int[][]>();
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

}