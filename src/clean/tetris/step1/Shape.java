package clean.tetris.step1;

import java.util.Random;

import java.lang.Math;


public abstract class Shape {
    protected int coordinates[][];
    public Shape clone(){
			try {
				Shape cloned;
				cloned = (Shape) this.getClass().newInstance();
				cloned.coordinates = deepCloneArray(coordinates);
				return cloned;
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		System.out.println("noShape on clone");
    	return new NoShape();
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
	public static Shape getNoShape(){
    	return new NoShape();
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
        	return new MirroredLShape();
        default:
        	System.out.println("NoShape on makeRandom");
        	return new NoShape();
        }
    }

    protected Shape( int[][] coordinates) {
        this.coordinates = coordinates;
    }

    private void setX(int index, int x) { coordinates[index][0] = x; }
    private void setY(int index, int y) { coordinates[index][1] = y; }
    public int x(int index) { return coordinates[index][0];}
    public int y(int index) { return coordinates[index][1];}
    
    public abstract int[] getRgb();
    
    public int minX()
    {
      int m = coordinates[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coordinates[i][0]);
      }
      return m;
    }


    public int minY() 
    {
      int m = coordinates[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coordinates[i][1]);
      }
      return m;
    }

    public Shape rotateLeft(){
    	if(this instanceof SquareShape)
    		return this;
        Shape result;
		result = this.clone();

        for (int i = 0; i < 4; ++i) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    public Shape rotateRight(){
    	if(this instanceof SquareShape)
    		return this;
    	Shape result;
		result = this.clone();

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
    


}
class NoShape extends Shape{
	public NoShape(){
		super(new int[][] { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } });
	}

	public int[] getRgb() {
		return new int[] {0, 0, 0};
	}
	
}
class ZShape extends Shape{
	public ZShape(){
		super(new int[][]{ { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } });
	}

	public int[] getRgb() {
		return new int[] {204, 102, 102};
	}
}
class SShape extends Shape{
	public SShape(){
		super(new int[][]{ { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } });
	}   

	public int[] getRgb() {
		return new int[] {102, 204, 102};
	}	
}
class LineShape extends Shape{
	public LineShape(){
		super(new int[][] { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } });
	}

	public int[] getRgb() {
		return new int[] {102, 102, 204};
	}
}
class TShape extends Shape{
	public TShape(){
		super(new int[][]{ { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } });
	}   

	public int[] getRgb() {
		return new int[] {204, 204, 102};
	}	
}
class SquareShape extends Shape{
	public SquareShape(){
		super(new int[][]{ { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } });
	}  	

	public int[] getRgb() {
		return new int[] {204, 102, 204};
	}
}
class LShape extends Shape{
	public LShape(){
		super(new int[][] { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } });
	}  	

	public int[] getRgb() {
		return new int[] {102, 204, 204};
	}
}
class MirroredLShape extends Shape{
	public MirroredLShape(){
		super(new int[][]{ { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } });
	}  	

	public int[] getRgb() {
		return new int[] {218, 170, 0};
	}
}