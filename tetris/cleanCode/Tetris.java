package cleanCode;

public class Tetris {

	final int BoardWidth = 10;
	final int BoardHeight = 22;

	View view;
	boolean isFallingFinished = false;
	boolean isStarted = false;
	boolean isPaused = false;
	int numLinesRemoved = 0;
	int curX = 0;
	int curY = 0;
	Shape curPiece;
	Shape[] board;
//	private int width;
//	private int height;

	public Tetris(View view) {
		this.view = view;
//		this.width = width;
//		this.height = height;
		curPiece = Shape.makeRandom();
		board = new Shape[BoardWidth * BoardHeight];
	}

	public void lineDown() {
		if (isFallingFinished) {
			isFallingFinished = false;
			newPiece();
		} else {
			oneLineDown();
		}
	}

//	int squareWidth() {
//		return (int) width / BoardWidth;
//	}
//
//	int squareHeight() {
//		return (int) height / BoardHeight;
//	}

	Shape shapeAt(int x, int y) {
		return board[(y * BoardWidth) + x];
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
			view.updateStatus(String.valueOf(numLinesRemoved));
			view.start();
		}
		view.update();
	}

	// public void paint(Graphics g){
	// super.paint(g);
	//
	// Dimension size = getSize();
	// int boardTop = (int) size.getHeight() - BoardHeight * squareHeight();
	//
	//
	// for (int i = 0; i < BoardHeight; ++i) {
	// for (int j = 0; j < BoardWidth; ++j) {
	// Shape shape = shapeAt(j, BoardHeight - i - 1);
	// if (shape != null)
	// drawShape(g, 0 + j * squareWidth(),
	// boardTop + i * squareHeight(), shape);
	// }
	// }
	//
	// if (curPiece != null) {
	// for (int i = 0; i < 4; ++i) {
	// int x = curX + curPiece.x(i);
	// int y = curY - curPiece.y(i);
	// drawShape(g, 0 + x * squareWidth(),
	// boardTop + (BoardHeight - y - 1) * squareHeight(),
	// curPiece);
	// }
	// }
	// }

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

	void oneLineDown() {
		if (canMove(curPiece, curX, curY - 1))
			move(curPiece, curX, curY - 1);
		else
			pieceDropped();
	}

	private void pieceDropped() {
		for (int i = 0; i < 4; ++i) {
			int x = curX + curPiece.x(i);
			int y = curY - curPiece.y(i);
			board[(y * BoardWidth) + x] = curPiece;
		}

		removeFullLines();

		if (!isFallingFinished)
			newPiece();
	}

	private void newPiece() {
		curPiece = Shape.makeRandom();
		curX = BoardWidth / 2 + 1;
		curY = BoardHeight - 1 + curPiece.minY();

		if (canMove(curPiece, curX, curY)) {
			move(curPiece, curX, curY);
		} else {
			isStarted = false;
			view.notifyGameOver();
			view.pause();
		}
	}

	boolean canMove(Shape newPiece, int xTo, int yTo) {
		for (int i = 0; i < 4; ++i) {
			int x = xTo + newPiece.x(i);
			if (x < 0 || x >= BoardWidth)
				return false;

			int y = yTo - newPiece.y(i);
			if (y < 0 || y >= BoardHeight)
				return false;

			Shape sat = shapeAt(x, y);
			if (sat != null)
				return false;
		}
		return true;
	}

	void move(Shape newPiece, int xTo, int yTo) {
		curPiece = newPiece;
		curX = xTo;
		curY = yTo;
		view.update();
	}

	private void removeFullLines() {
		int numFullLines = 0;

		for (int i = BoardHeight - 1; i >= 0; --i) {
			boolean lineIsFull = true;

			for (int j = 0; j < BoardWidth; ++j) {
				Shape sat = shapeAt(j, i);
				if (sat == null) {
					lineIsFull = false;
					break;
				}
			}

			if (lineIsFull) {
				++numFullLines;
				for (int k = i; k < BoardHeight - 1; ++k) {
					for (int j = 0; j < BoardWidth; ++j)
						board[(k * BoardWidth) + j] = shapeAt(j, k + 1);
				}
			}
		}

		if (numFullLines > 0) {
			numLinesRemoved += numFullLines;
			view.updateStatus(String.valueOf(numLinesRemoved));
			isFallingFinished = true;
			curPiece = null;
			view.update();
		}
	}

	// private void drawShape(Graphics g, int x, int y, Shape shape)
	// {
	// int[] rgb = shape.getRgb();
	// Color color = new Color(rgb[0],rgb[1],rgb[2]);
	//
	// g.setColor(color);
	// g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
	//
	// g.setColor(color.brighter());
	// g.drawLine(x, y + squareHeight() - 1, x, y);
	// g.drawLine(x, y, x + squareWidth() - 1, y);
	//
	// g.setColor(color.darker());
	// g.drawLine(x + 1, y + squareHeight() - 1,
	// x + squareWidth() - 1, y + squareHeight() - 1);
	// g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
	// x + squareWidth() - 1, y + 1);
	// }
}