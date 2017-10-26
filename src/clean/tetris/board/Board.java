package clean.tetris.board;

import java.util.ArrayList;
import java.util.List;

import clean.tetris.GridUtils;
import clean.tetris.tetromino.Tetromino;

import static clean.tetris.Context.Code.EMPTY;

public class Board {
	private static int STANDARD_HEIGHT = 22;
	private static int STANDARD_WIDTH  = 10;
	final int height;
	final int width;
	private final int middleWidth;
	private Tetromino current;
	private int currentX;
	private int currentY;
	private ArrayList<String> grid;

	public Board() {
		this(STANDARD_HEIGHT, STANDARD_WIDTH);
	}

	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		this.middleWidth = width/2;
		this.current = Tetromino.getNullShape();
		this.grid = new ArrayList<String>();
		addEmptyLinesOnTop();
	}

	public Board add(Tetromino shape) {
		current = shape;
		currentY = shape.initialYSlack();
		currentX = middleWidth;
		return this;
	}

	public List<String> asList() {
		List<String> overlaped = overlapShapeOnClonedGrid();
		return overlaped;
	}

	public boolean canMoveLineDown() {
		return canMove(0, 1);
	}

	public Board clearFullLines() {
		grid = cloneGridWithoutFullLines();
		addEmptyLinesOnTop();
		return this;
	}

	public Board dropDown() {
		while (canMoveLineDown())
			lineDown();
		freezePiece();
		return this;
	}

	public Board freezePiece() {
		this.grid = overlapShapeOnClonedGrid();
		this.current = Tetromino.getNullShape();
		return this;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public boolean isGameOver() {
		return !canMoveLineDown();
	}

	public Board lineDown() {
		if(canMoveLineDown())
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

	private void addEmptyLinesOnTop() {
		while(grid.size() < getHeight())
			grid.add(0, GridUtils.makeEmptyLine(getWidth()));
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
		if (isValidLineIndex(lineIndex) && isValidCharIndex(charIndex) && isTargetEmpty(lineIndex, charIndex))
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	private ArrayList<String> cloneGrid() {
		return (ArrayList<String>) grid.clone();
	}

	private ArrayList<String> cloneGridWithoutFullLines() {
		ArrayList<String> cloned = cloneGrid();
		removeFullLines(cloned);
		return cloned;
	}

	private int getCharIndex(int[] coordinate) {
		return currentX + coordinate[0];
	}

	private int getLineIndex(int[] coordinate) {
		return currentY + coordinate[1];
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

	private void overlapLetterOnGrid(ArrayList<String> targetGrid, char letter, int[] square) {
		int lineIndex = getLineIndex(square);
		int charIndex = getCharIndex(square);
		
		GridUtils.overlapLetterOnGrid(targetGrid, letter, lineIndex, charIndex);
	}

	private ArrayList<String> overlapShapeOnClonedGrid() {
		ArrayList<String> cloned = cloneGrid();
		char letter = current.getCode();
		for (int[] square : current.getSquares())
			overlapLetterOnGrid(cloned, letter, square);
	
		return cloned;
	}

	private void removeFullLines(ArrayList<String> cloned) {
		for(String line : grid)
			if(shouldRemoveLine(line))
				cloned.remove(line);
	}

	private boolean shouldRemoveLine(String line) {
		for(char letter: line.toCharArray())
			if(letter == EMPTY.letter)
				return false;
		return true;
	}

	private void tryToPersistRotation(Tetromino rotated) {
		Tetromino previous = current;
		current = rotated;
		if (!canMove(0, 0))
			current = previous;
	}

}
