package clean.tetris;

public class RunningPieceState extends StateBoard {

	@Override
	public StateBoard next() {
		if(BOARD.canMoveLineDown())
			BOARD.lineDown();

		return BOARD.canMoveLineDown()? this: FINISHED_PIECE;		
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
		return FINISHED_PIECE;
	}

}
