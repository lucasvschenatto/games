package clean.tetris.shapes;

import java.util.List;
import java.util.Random;
import java.lang.Math;


public abstract class Shape {
    private List<int[][]> states;
    public Shape clone(){
			try {
				Shape cloned;
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

	public int[][] getCoordinates(){
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
	public static Shape getNullShape(){
    	return new NullShape();
    }
    public static Shape makeRandom(){
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

    protected Shape( List<int[][]> states) {
        this.states = states;
    }
    
    public abstract int initialYSlack();

    public abstract int[] getRgb();
    
    public abstract char getCode();

    public Shape rotateLeft(){
    	Shape rotated = this.clone();
    	int[][] first = rotated.states.get(0);
    	rotated.states.remove(first);
    	rotated.states.add(first);
    	return rotated;
    };

    public Shape rotateRight(){
    	Shape rotated = this.clone();
    	int[][] last = rotated.states.get(rotated.states.size()-1);
    	List<int[][]> head = rotated.states.subList(0, rotated.states.size()-1);
    	rotated.states.clear();
    	rotated.states.add(last);
    	rotated.states.addAll(head);
    	return rotated;
    };
    


}
