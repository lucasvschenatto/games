package clean.tetris.tetromino;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.lang.Math;


public abstract class Tetromino {
    public static Tetromino getNullShape(){
    	return new NullShape();
    }
    public static Tetromino makeRandom(){
    	Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7;
        switch (x){
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

	protected Tetromino( LinkedList<int[][]> states) {
        this.states = states;
    }
    public Tetromino clone(){
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

    public int[][] getSquares(){
    	return states.get(0);
    }
    
    public abstract int initialYSlack();

    public Tetromino rotateLeft(){
    	Tetromino rotated = this.clone();
    	int[][] last = rotated.states.get(rotated.states.size()-1);
    	try {
			List<int [][]> copyOfHead = deepCloneList(rotated.states).subList(0, rotated.states.size()-1);
			rotated.states.clear();
			rotated.states.add(last);
			rotated.states.addAll(copyOfHead);
			return rotated;
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
			return null;
		}
    }
    
    public Tetromino rotateRight(){
    	Tetromino rotated = this.clone();
    	int[][] first = rotated.states.get(0);
    	rotated.states.remove(first);
    	rotated.states.add(first);
    	return rotated;
    }

    private int[][] deepCloneArray(int[][] source) {
		int[][]cloned = new int[source.length][source[0].length];
		for (int i = 0; i < source.length; i++) {
			for (int j = 0; j < source[0].length; j++) {
				cloned[i][j] = source[i][j];
			}			
		}
		return cloned;
	};

    @SuppressWarnings("unchecked")
	private LinkedList<int[][]> deepCloneList(LinkedList<int[][]> source) throws InstantiationException, IllegalAccessException {
		LinkedList<int[][]> cloned = source.getClass().newInstance();
		for(int[][] line: source)
			cloned.add(deepCloneArray(line));
		return cloned;
	};
    


}
