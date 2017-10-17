package clean.tetris.shapes;

import clean.tetris.Context;

public class ZShape extends Shape{
	public ZShape(){
		super(new int[][]{ { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } });
	}

	public int[] getRgb() {
		return new int[] {204, 102, 102};
	}

	@Override
	public char getCode() {
		return Context.Code.ZSHAPE.letter;
	}
}