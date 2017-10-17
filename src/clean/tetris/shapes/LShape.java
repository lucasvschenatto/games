package clean.tetris.shapes;

import clean.tetris.Context;

public class LShape extends Shape{
	public LShape(){
		super(new int[][] { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } });
	}  	

	public int[] getRgb() {
		return new int[] {102, 204, 204};
	}

	@Override
	public char getCode() {
		return Context.Code.LSHAPE.letter;
	}
}