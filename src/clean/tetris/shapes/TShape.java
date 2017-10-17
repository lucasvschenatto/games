package clean.tetris.shapes;

import clean.tetris.Context;

public class TShape extends Shape{
	public TShape(){
		super(new int[][]{ { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } });
	}   

	public int[] getRgb() {
		return new int[] {204, 204, 102};
	}

	@Override
	public char getCode() {
		return Context.Code.TSHAPE.letter;
	}	
}