package clean.tetris.tetromino;

import java.util.ArrayList;
import java.util.List;

import clean.tetris.Context;

public class JShape extends Tetromino{
	public JShape(){
		super(makeStates());
	}  	

	private static List<int[][]> makeStates() {
		List<int[][]> states = new ArrayList<int[][]>();
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

	@Override
	public int initialYSlack() {
		return 1;
	}
}