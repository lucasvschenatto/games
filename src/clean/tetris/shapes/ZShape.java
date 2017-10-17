package clean.tetris.shapes;

import java.util.ArrayList;
import java.util.List;

import clean.tetris.Context;

public class ZShape extends Shape{
	public ZShape(){
		super(makeStates());
	}  	

	private static List<int[][]> makeStates() {
		List<int[][]> states = new ArrayList<int[][]>();
		states.add(new int[][]{ {-1, 0 }, {0 , 0 }, {0, 1 }, {1, 1 } } );
		states.add(new int[][]{ {-1, 1 }, {-1 , 0 }, {0, 0 }, {0, -1 } } );
		states.add(new int[][]{ {-1, -1 }, {0 , -1 }, {0, 0 }, {1, 0 } } );
		states.add(new int[][]{ {0, 1 }, {0 , 0 }, {1, 0 }, {1, -1 } } );
		return states;
	}

	public int[] getRgb() {
		return new int[] {204, 102, 102};
	}

	@Override
	public char getCode() {
		return Context.Code.ZSHAPE.letter;
	}

	@Override
	public int initialYSlack() {
		return 0;
	}
}