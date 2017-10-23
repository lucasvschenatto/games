package clean.tetris.tetromino;

import java.util.LinkedList;

import clean.tetris.Context;

public class LineShape extends Tetromino{
	public LineShape(){
		super(makeStates());
	}  	

	private static LinkedList<int[][]> makeStates() {
		LinkedList<int[][]> states = new LinkedList<int[][]>();
		states.add(new int[][]{ { 0, -1 },  { 0, 0 },  { 0, 1 },   { 0, 2 } } );
		states.add(new int[][]{ { -1, 0 }, { 0, 0 }, { 1, 0 }, { 2, 0 } } );
		states.add(new int[][]{ { 1, -1 },  { 1, 0 },  { 1, 1 },   { 1, 2 } } );
		states.add(new int[][]{ { -1, 1 }, { 0, 1 }, { 1, 1 }, { 2, 1 } } );
		return states;
	}

	public int[] getRgb() {
		return new int[] {102, 102, 204};
	}

	@Override
	public char getCode() {
		return Context.Code.LINESHAPE.letter;
	}

}
