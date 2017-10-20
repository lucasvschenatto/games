package clean.tetris.tetromino;

import java.util.List;
import java.util.Random;
import java.lang.Math;


public abstract class Tetromino {
    private List<int[][]> states;
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
    
    @SuppressWarnings("unchecked")
	private List<int[][]> deepCloneList(List<int[][]> source) throws InstantiationException, IllegalAccessException {
		List<int[][]> cloned = source.getClass().newInstance();
		for(int[][] line: source)
			cloned.add(deepCloneArray(line));
		return cloned;
	}

	public int[][] getSquares(){
    	return states.get(0);
    }
    private int[][] deepCloneArray(int[][] source) {
		int[][]cloned = new int[source.length][source[0].length];
		for (int i = 0; i < source.length; i++) {
			for (int j = 0; j < source[0].length; j++) {
				cloned[i][j] = source[i][j];
			}			
		}
		return cloned;
	}
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

    protected Tetromino( List<int[][]> states) {
        this.states = states;
    }
    
    public abstract int initialYSlack();

    public abstract int[] getRgb();
    
    public abstract char getCode();

    public Tetromino rotateRight(){
    	Tetromino rotated = this.clone();
    	int[][] first = rotated.states.get(0);
    	rotated.states.remove(first);
    	rotated.states.add(first);
    	return rotated;
    };

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
    };
    


}
