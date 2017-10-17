package clean.tetris.shapes;

import clean.tetris.Context;

public class SShape extends Shape{
	public SShape(){
		super(new int[][]{ { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } });
	}   

	public int[] getRgb() {
		return new int[] {102, 204, 102};
	}

	@Override
	public char getCode() {
		return Context.Code.SSHAPE.letter;
	}	
}