package clean.tetris.board.state;

public class PausedState extends StateBoard {

	private StateBoard previous;

	@Override
	public StateBoard dropDown() {
		return this;
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
	public StateBoard next() {
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
	public StateBoard pause() {
		return previous;
	}

	public void setPrevious(StateBoard previous) {
		this.previous = previous;
	}

}
