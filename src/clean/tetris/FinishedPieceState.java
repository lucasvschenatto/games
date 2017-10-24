package clean.tetris;

import clean.tetris.tetromino.Tetromino;

public class FinishedPieceState extends StateBoard {

	@Override
	public StateBoard next() {
		board.freezePiece();
		board.clearFullLines();
		board.add(Tetromino.makeRandom());
		return board.isGameOver()? RUNNING_PIECE: GAME_OVER;
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
