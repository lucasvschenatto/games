package clean.tetris;

import clean.tetris.tetromino.Tetromino;

public class FinishedPieceState extends StateBoard {

	@Override
	public StateBoard next() {
		BOARD.freezePiece();
		BOARD.clearFullLines();
		BOARD.add(Tetromino.makeRandom());
		return BOARD.isGameOver()? GAME_OVER:RUNNING_PIECE;
	}

	@Override
	public StateBoard lineDown() {
		return this;
	}

	@Override
	public StateBoard moveLeft() {
		return this;
	}

	@Override
	public StateBoard moveRight() {
		return this;
	}

	@Override
	public StateBoard rotateLeft() {
		return this;
	}

	@Override
	public StateBoard rotateRight() {
		return this;
	}

	@Override
	public StateBoard dropDown() {
		return this;
	}

}
