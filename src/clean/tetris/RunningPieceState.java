package clean.tetris;

public class RunningPieceState extends StateBoard {

	@Override
	public StateBoard next() {
		if(board.canMoveLineDown())
			board.lineDown();

		return board.canMoveLineDown()? this: FINISHED_PIECE;		
	}

	@Override
	public StateBoard lineDown() {
		board.lineDown();
		return this;
	}

	@Override
	public StateBoard moveLeft() {
		board.moveLeft();
		return this;
	}

	@Override
	public StateBoard moveRight() {
		board.moveRight();
		return this;
	}

	@Override
	public StateBoard rotateLeft() {
		board.rotateLeft();
		return this;
	}

	@Override
	public StateBoard rotateRight() {
		rotateRight();
		return this;
	}

	@Override
	public StateBoard dropDown() {
		dropDown();
		return FINISHED_PIECE;
	}

}
