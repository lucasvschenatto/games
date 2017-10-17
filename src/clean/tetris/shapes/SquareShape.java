package clean.tetris.shapes;

import clean.tetris.Context;

public class SquareShape extends Shape{
	public SquareShape(){
		super(new int[][]{ {-1,-1}, {-1, 0 }, {0, -1 }, {0, 0} } );
	}  	

	public int[] getRgb() {
		return new int[] {204, 102, 204};
	}

	@Override
	public char getCode() {
		return Context.Code.SQUARE.letter;
	}
}