package clean.tetris;

import java.util.ArrayList;
import java.util.List;

import static clean.tetris.Context.Code.EMPTY;

import clean.tetris.shapes.Shape;

public class Board {
	private ArrayList<String> grid;
	private Shape current;
	private int currentY;
	private static int MIDDLE_X = 5;
	
	public Board() {
		current = Shape.getNullShape();
		grid = new ArrayList<String>();
		for (int i = 0; i < 22; i++) {
			String line = makeEmptyLine();
			grid.add( line );
		}
	}

	private String makeEmptyLine() {
		String line = new String();
		for (int i = 0; i < 10; i++)
			line = line.concat(String.valueOf(EMPTY));
		return line;
	}

	public List<String> asList() {
		List<String> overlaped = overlapShapeOnGrid();
		return overlaped;
	}

	@SuppressWarnings("unchecked")
	private List<String> overlapShapeOnGrid() {
		List<String> newGrid = (List<String>) grid.clone();
		char letter = current.getCode();
		for(int[] coordinate: current.getCoordinates()){
			int currY = currentY + coordinate[1];
			int currX = MIDDLE_X + coordinate[0];
			String line = newGrid.get(currY);
			String prefix = line.substring(0,currX);
			String sufix = line.substring(currX + 1);
			String newLine = prefix.concat(String.valueOf(letter).concat(sufix));
			newGrid.set(currY, newLine);
		}
		
		return newGrid;
	}

	public Board add(Shape shape) {
		current = shape;
		currentY = shape.initialYSlack();
		return this;
	}

	public Board lineDown() {
		currentY++;
		return this;
	}

}
