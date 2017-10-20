package clean.tetris.tetromino;

import java.util.LinkedList;

import clean.tetris.Context;

public class TShape extends Tetromino{
	public TShape(){
		super(makeStates());
	}  	

	private static LinkedList<int[][]> makeStates() {
		LinkedList<int[][]> states = new LinkedList<int[][]>();
		states.add(new int[][]{ {-1, 0 }, {0 , 0 }, {1, 0 }, {0, 1 } } );
		states.add(new int[][]{ {0, -1 }, {0 , 0 }, {0, 1 }, {-1, 0 } } );
		states.add(new int[][]{ {-1, 0 }, {0 , 0 }, {1, 0 }, {0, -1 } } );
		states.add(new int[][]{ {0, -1 }, {0 , 0 }, {0, 1 }, {1, 0 } } );
		return states;
	}

	public int[] getRgb() {
		return new int[] {204, 204, 102};
	}

	@Override
	public char getCode() {
		return Context.Code.TSHAPE.letter;
	}

	@Override
	public int initialYSlack() {
		return 0;
	}	
}