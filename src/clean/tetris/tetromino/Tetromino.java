package clean.tetris.tetromino;

import java.util.LinkedList;
import java.util.Random;

public abstract class Tetromino {
	public static Tetromino getNullShape() {
		return new NullShape();
	}

	public static Tetromino makeRandom() {
		Random r = new Random();
		int x = Math.abs(r.nextInt()) % 7;
		switch (x) {
		case 0:
			return new ZShape();
		case 1:
			return new SShape();
		case 2:
			return new LineShape();
		case 3:
			return new TShape();
		case 4:
			return new SquareShape();
		case 5:
			return new LShape();
		case 6:
			return new JShape();
		default:
			System.out.println("NoShape on makeRandom");
			return new NullShape();
		}
	}

	private LinkedList<int[][]> states;

	protected Tetromino(LinkedList<int[][]> states) {
		this.states = states;
	}

	public Tetromino clone() {
		try {
			Tetromino cloned;
			cloned = this.getClass().newInstance();
			cloned.states = deepCloneList(this.states);
			return cloned;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("noShape on clone");
		return new NullShape();
	}

	public abstract char getCode();

	public abstract int[] getRgb();

	public int[][] getSquares() {
		return states.get(0);
	}

	public int initialYSlack(){
		int slackY = 0;
		
		for(int[] square: states.get(0))
			if(square[1] < slackY)
				slackY = square[1];
		
		slackY = Math.abs(slackY);		
		return slackY;
	}

	public Tetromino rotateLeft() {
		Tetromino rotated = this.clone();
		int[][] last = rotated.states.pollLast();
		rotated.states.addFirst(last);

		return rotated;
	}

	public Tetromino rotateRight() {
		Tetromino rotated = this.clone();
		int[][] first = rotated.states.pollFirst();
		rotated.states.addLast(first);
		return rotated;
	}

	private int[][] deepCloneArray(int[][] source) {
		int[][] cloned = new int[source.length][source[0].length];
		for (int i = 0; i < source.length; i++)
			for (int j = 0; j < source[0].length; j++)
				cloned[i][j] = source[i][j];

		return cloned;
	};

	@SuppressWarnings("unchecked")
	private LinkedList<int[][]> deepCloneList(LinkedList<int[][]> source)
			throws InstantiationException, IllegalAccessException {
		LinkedList<int[][]> cloned = source.getClass().newInstance();
		for (int[][] line : source)
			cloned.add(deepCloneArray(line));
		return cloned;
	};

}
