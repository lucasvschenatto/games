package clean.tetris.board.state;

public class FinishedPieceState extends StateBoard {

	@Override
	public StateBoard next() {
		BOARD.freezePiece();
		BOARD.clearFullLines();
		BOARD.add(reloadTetromino());
		CONTROLLER.newWaitingTetromino();
		return BOARD.isGameOver()? GAME_OVER:RUNNING_TETROMINO;
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
