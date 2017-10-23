package clean.tetris.tetromino;

import java.util.LinkedList;

import clean.tetris.Context;

public class LShape extends Tetromino{
	public LShape(){
		super(makeStates());
	}  	

	private static LinkedList<int[][]> makeStates() {
		LinkedList<int[][]> states = new LinkedList<int[][]>();
		states.add(new int[][]{ { 1, 1 },  { 0, 1 },  { 0, 0 },   { 0, -1 } } );
		states.add(new int[][]{ { -1, 1 }, { -1, 0 }, { 0, 0 }, { 1, 0 } } );
		states.add(new int[][]{ { -1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } } );
		states.add(new int[][]{ { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } } );
		return states;
	}

	public int[] getRgb() {
		return new int[] {102, 204, 204};
	}

	@Override
	public char getCode() {
		return Context.Code.LSHAPE.letter;
	}

}