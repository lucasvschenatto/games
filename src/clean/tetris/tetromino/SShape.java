package clean.tetris.tetromino;

import java.util.LinkedList;

import clean.tetris.Context;

public class SShape extends Tetromino{
	public SShape(){
		super(makeStates());
	}  	

	private static LinkedList<int[][]> makeStates() {
		LinkedList<int[][]> states = new LinkedList<int[][]>();
		states.add(new int[][]{ {-1, 1 }, {0 , 1 }, {0, 0 }, {1, 0 } } );
		states.add(new int[][]{ {-1, -1 }, {-1 , 0 }, {0, 0 }, {0, 1 } } );
		states.add(new int[][]{ {-1, 0 }, {0 , 0 }, {0, -1 }, {1, -1 } } );
		states.add(new int[][]{ {0, -1 }, {0 , 0 }, {1, 0 }, {1, 1 } } );
		return states;
	}

	public int[] getRgb() {
		return new int[] {102, 204, 102};
	}

	@Override
	public char getCode() {
		return Context.Code.SSHAPE.letter;
	}

	@Override
	public int initialYSlack() {
		return 0;
	}	
}