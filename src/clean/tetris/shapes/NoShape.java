package clean.tetris.shapes;

import clean.tetris.Context;

public class NoShape extends Shape{
	public NoShape(){
		super(new int[][] { });
	}

	public int[] getRgb() {
		return new int[] {0, 0, 0};
	}

	@Override
	public char getCode() {
		return Context.Code.NOSHAPE.letter;
	}
	
}