package clean.tetris.tetromino;

import java.util.ArrayList;
import java.util.List;

import clean.tetris.Context;

public class TShape extends Tetromino{
	public TShape(){
		super(makeStates());
	}  	

	private static List<int[][]> makeStates() {
		List<int[][]> states = new ArrayList<int[][]>();
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