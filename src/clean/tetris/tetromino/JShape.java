package clean.tetris.tetromino;

import java.util.LinkedList;

import clean.tetris.Context;

public class JShape extends Tetromino{
	public JShape(){
		super(makeStates());
	}  	

	private static LinkedList<int[][]> makeStates() {
		LinkedList<int[][]> states = new LinkedList<int[][]>();
		states.add(new int[][]{ { -1, 1 },  { 0, 1 },  { 0, 0 },   { 0, -1 } } );
		states.add(new int[][]{ { -1, -1 }, { -1, 0 }, { 0, 0 }, { 1, 0 } } );
		states.add(new int[][]{ { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } } );
		states.add(new int[][]{ { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } } );
		return states;
	}

	public int[] getRgb() {
		return new int[] {218, 170, 0};
	}

	@Override
	public char getCode() {
		return Context.Code.JSHAPE.letter;
	}

}