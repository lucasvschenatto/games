package clean.tetris;

import clean.tetris.shapes.Shape;

public class Controller {
	private int width = 10;
	private int height = 22;

	boolean isFallingFinished = false;
	boolean isStarted = false;
	boolean isPaused = false;
	int numLinesRemoved = 0;
	int curX = 0;
	int curY = 0;
	Shape curPiece;
	Shape[][] board;
	String[][] stringBoard;
	private View view;

	public Controller(View view) {

		this.view = view;
		curPiece = Shape.makeRandom();
		board = new Shape[getWidth()][getHeight()];
		stringBoard = new String[getWidth()][getHeight()];
	}

	public void lineDown() {
		if (isFallingFinished) {
			isFallingFinished = false;
			newPiece();
		} else {
			oneLineDown();
		}
	}

	Shape shapeAt(int x, int y) {
		return board[x][y];
	}

	public void start() {
		if (isPaused)
			return;

		isStarted = true;
		isFallingFinished = false;
		numLinesRemoved = 0;

		newPiece();
		view.start();
	}

	void pause() {
		if (!isStarted)
			return;

		isPaused = !isPaused;
		if (isPaused) {
			view.pause();
		} else {
			view.resume(numLinesRemoved);
		}
		view.update(stringBoard);
	}

	void oneLineDown() {
		if (canMove(curPiece, curX, curY - 1))
			move(curPiece, curX, curY - 1);
		else
			pieceDropped();
	}

	void dropDown() {
		int newY = curY;
		while (newY > 0) {
			if (canMove(curPiece, curX, newY - 1)) {
				move(curPiece, curX, newY - 1);
				--newY;
			} else
				break;
		}
		pieceDropped();
	}

	boolean canMove(Shape newPiece, int xTo, int yTo) {
//		for (int i = 0; i < 4; ++i) {
//			int x = xTo + newPiece.x(i);
//			if (x < 0 || x > getWidth() - 1)
//				return false;
//	
//			int y = yTo - newPiece.y(i);
//			if (y < 0 || y > getHeight() - 1)
//				return false;
//	
//			Shape sat = shapeAt(x, y);
//			if (sat != null)
//				return false;
//		}
		return true;
	}

	void move(Shape newPiece, int xTo, int yTo) {
		curPiece = newPiece;
		curX = xTo;
		curY = yTo;
		stringBoard[xTo][yTo] = newPiece.getClass().getSimpleName();
		view.update(stringBoard);
	}

	private void pieceDropped() {
//		for (int i = 0; i < 4; ++i) {
//			int x = curX + curPiece.x(i);
//			int y = curY - curPiece.y(i);
//			board[y][x] = curPiece;
//		}
//
//		removeFullLines();
//
//		if (!isFallingFinished)
//			newPiece();
	}

	private void newPiece() {
		curPiece = Shape.makeRandom();
		curX = getWidth() / 2;
//		curY = getHeight() - 1 + curPiece.minY();
		curY = 0;

		if (canMove(curPiece, curX, curY)) {
			move(curPiece, curX, curY);
		} else {
			view.notifyGameOver();
//			isStarted = false;
		}
	}

	private void removeFullLines() {
		int numFullLines = 0;

		for (int i = getHeight() - 1; i >= 0; --i) {
			boolean lineIsFull = true;

			for (int j = 0; j < getWidth(); ++j) {
				Shape sat = shapeAt(j, i);
				if (sat == null) {
					lineIsFull = false;
					break;
				}
			}

			if (lineIsFull) {
				++numFullLines;
				for (int k = i; k < getHeight() - 1; ++k) {
					for (int j = 0; j < getWidth(); ++j)
						board[k][j] = shapeAt(j, k + 1);
				}
			}
		}

		if (numFullLines > 0) {
			numLinesRemoved += numFullLines;
			view.updateStatus(String.valueOf(numLinesRemoved));
			isFallingFinished = true;
			curPiece = null;
			view.update(stringBoard);
		}
	}

	int getHeight() {
		return height;
	}

	void setHeight(int height) {
		this.height = height;
	}

	int getWidth() {
		return width;
	}

	void setWidth(int width) {
		this.width = width;
	}
}