package clean.tetris.board.state;

public class RunningPieceState extends StateBoard {

	@Override
	public StateBoard next() {
		if(BOARD.canMoveLineDown()){
			BOARD.lineDown();
			return this;
		} else
			return FINISHED_TETROMINO;		
	}

	@Override
	public StateBoard lineDown() {
		BOARD.lineDown();
		return this;
	}

	@Override
	public StateBoard moveLeft() {
		BOARD.moveLeft();
		return this;
	}

	@Override
	public StateBoard moveRight() {
		BOARD.moveRight();
		return this;
	}

	@Override
	public StateBoard rotateLeft() {
		BOARD.rotateLeft();
		return this;
	}

	@Override
	public StateBoard rotateRight() {
		BOARD.rotateRight();
		return this;
	}

	@Override
	public StateBoard dropDown() {
		BOARD.dropDown();
		return FINISHED_TETROMINO;
	}

}
