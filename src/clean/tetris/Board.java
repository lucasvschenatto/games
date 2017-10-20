package clean.tetris;

import java.util.ArrayList;
import java.util.List;

import clean.tetris.tetromino.Tetromino;

import static clean.tetris.Context.Code.EMPTY;

public class Board {
	private static int MIDDLE_X = 5;
	private Tetromino current;
	private int currentX;
	private int currentY;
	private ArrayList<String> grid;

	public Board() {
		this.current = Tetromino.getNullShape();
		this.grid = new ArrayList<String>();
		for (int i = 0; i < 22; i++)
			grid.add(makeEmptyLine());
	}

	public Board add(Tetromino shape) {
		current = shape;
		currentY = shape.initialYSlack();
		currentX = MIDDLE_X;
		return this;
	}

	public List<String> asList() {
		List<String> overlaped = overlapShapeOnClonedGrid();
		return overlaped;
	}

	public boolean canMoveLineDown() {
		return canMove(0, 1);
	}

	public Board dropDown() {
		while (canMoveLineDown())
			lineDown();
		this.grid = overlapShapeOnClonedGrid();
		this.current = Tetromino.getNullShape();
		return this;
	}

	public boolean isGameOver() {
		return !canMoveLineDown();
	}

	public Board lineDown() {
		currentY++;
		return this;
	}

	public Board moveLeft() {
		if (canMove(-1, 0))
			currentX--;
		return this;
	}

	public Board moveRight() {
		if (canMove(1, 0))
			currentX++;
		return this;
	}

	public Board rotateLeft() {
		tryToPersistRotation(current.rotateLeft());
		return this;
	}

	public Board rotateRight() {
		tryToPersistRotation(current.rotateRight());
		return this;
	}

	private void tryToPersistRotation(Tetromino rotated) {
		Tetromino previous = current;
		current = rotated;
		if (!canMove(0, 0))
			current = previous;
	}

	private boolean canMove(int distanceX, int distanceY) {
		for (int[] square : current.getSquares())
			if (! canMoveSquare(square, distanceX, distanceY))
				return false;
		return true;
	}

	private boolean canMoveSquare(int[] square, int distanceX, int distanceY) {
		int lineIndex = getLineIndex(square) + distanceY;
		int charIndex = getCharIndex(square) + distanceX;
		if (! isValidLineIndex(lineIndex) || ! isValidCharIndex(charIndex) || ! isTargetEmpty(lineIndex, charIndex))
			return false;
		else
			return true;
	}

	private boolean isTargetEmpty(int lineIndex, int charIndex) {
		return grid.get(lineIndex).charAt(charIndex) == EMPTY.letter;
	}

	private boolean isValidCharIndex(int charIndex) {
		return charIndex >= 0 && charIndex < grid.get(0).length();
	}

	private boolean isValidLineIndex(int lineIndex) {
		return lineIndex >= 0 && lineIndex < grid.size();
	}

	private int getCharIndex(int[] coordinate) {
		return currentX + coordinate[0];
	}

	private int getLineIndex(int[] coordinate) {
		return currentY + coordinate[1];
	}

	private String makeEmptyLine() {
		String line = new String();
		for (int i = 0; i < 10; i++)
			line = line.concat(String.valueOf(EMPTY));
		return line;
	}

	@SuppressWarnings("unchecked")
	private ArrayList<String> overlapShapeOnClonedGrid() {
		ArrayList<String> cloned = (ArrayList<String>) grid.clone();
		char letter = current.getCode();
		for (int[] square : current.getSquares())
			overlapLetterOnGrid(cloned, letter, square);
	
		return cloned;
	}

	private void overlapLetterOnGrid(ArrayList<String> targetGrid, char letter, int[] square) {
		int lineIndex = getLineIndex(square);
		int charIndex = getCharIndex(square);

		String line = targetGrid.get(lineIndex);
		String lineWithLetter = overlapLetterOnLine(letter, line, charIndex);

		targetGrid.set(lineIndex, lineWithLetter);
	}

	private String overlapLetterOnLine(char letter, String line, int charIndex) {
		String prefix = line.substring(0, charIndex);
		String sufix = line.substring(charIndex + 1);

		return prefix.concat(String.valueOf(letter).concat(sufix));
	}

}
