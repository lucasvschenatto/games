package clean.tetris;

import java.util.ArrayList;
import java.util.List;

import clean.tetris.tetromino.Tetromino;

import static clean.tetris.Context.Code.EMPTY;

public class Board {
	private ArrayList<String> grid;
	private Tetromino current;
	private int currentY;
	private static int MIDDLE_X = 5;
	
	public Board() {
		current = Tetromino.getNullShape();
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
		List<String> overlaped = overlapShapeOnClonedGrid();
		return overlaped;
	}

	@SuppressWarnings("unchecked")
	private ArrayList<String> overlapShapeOnClonedGrid() {
		ArrayList<String> cloned = (ArrayList<String>) grid.clone();
		char letter = current.getCode();
		for(int[] coordinate: current.getCoordinates())
			overlapLetterOnGrid(cloned, letter, coordinate);
		
		return cloned;
	}

	private void overlapLetterOnGrid(ArrayList<String> targetGrid, char letter, int[] coordinate) {
		int lineIndex = getLineIndex(coordinate);
		int charIndex = MIDDLE_X + coordinate[0];

		String line = targetGrid.get(lineIndex);
		String newLine = overlapLetterOnLine(letter, line, charIndex);
		
		targetGrid.set(lineIndex, newLine);
	}

	private String overlapLetterOnLine(char letter, String line, int charIndex) {
		String prefix = line.substring(0,charIndex);
		String sufix = line.substring(charIndex + 1);
		
		return prefix.concat(String.valueOf(letter).concat(sufix));
	}

	private int getLineIndex(int[] coordinate) {
		return currentY + coordinate[1];
	}

	public Board add(Tetromino shape) {
		current = shape;
		currentY = shape.initialYSlack();
		return this;
	}

	public Board lineDown() {
		currentY++;
		return this;
	}
	
	public boolean canMoveLineDown(){
		for(int[] coordinate: current.getCoordinates())
			if (getLineIndex(coordinate) >= grid.size() - 1)
				return false;
		return true;
	}

	public Board dropDown() {
		while (canMoveLineDown())
			lineDown();
		this.grid = overlapShapeOnClonedGrid();
		this.current = Tetromino.getNullShape();
		return this;
	}

}
