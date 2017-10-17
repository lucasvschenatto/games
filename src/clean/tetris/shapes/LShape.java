package clean.tetris.shapes;

import java.util.ArrayList;
import java.util.List;

import clean.tetris.Context;

public class LShape extends Shape{
	public LShape(){
		super(makeStates());
	}  	

	private static List<int[][]> makeStates() {
		List<int[][]> states = new ArrayList<int[][]>();
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

	@Override
	public int initialYSlack() {
		return 1;
	}
}