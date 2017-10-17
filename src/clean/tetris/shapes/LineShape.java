package clean.tetris.shapes;

import clean.tetris.Context;

class LineShape extends Shape{
	public LineShape(){
		super(new int[][] { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } });
	}

	public int[] getRgb() {
		return new int[] {102, 102, 204};
	}

	@Override
	public char getCode() {
		return Context.Code.LINESHAPE.letter;
	}
}
