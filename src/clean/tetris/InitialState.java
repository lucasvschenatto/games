package clean.tetris;

import clean.tetris.tetromino.Tetromino;

public class InitialState extends StateBoard {

	@Override
	public StateBoard next() {
		board.add(Tetromino.makeRandom());
		return RUNNING_PIECE;
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
