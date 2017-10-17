package clean.tetris.shapes;

import clean.tetris.Context;

public class JShape extends Shape{
	public JShape(){
		super(new int[][]{ { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } });
	}  	

	public int[] getRgb() {
		return new int[] {218, 170, 0};
	}

	@Override
	public char getCode() {
		return Context.Code.JSHAPE.letter;
	}
}