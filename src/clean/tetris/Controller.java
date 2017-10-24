package clean.tetris;

public class Controller {

	private boolean isStarted = false;
	private boolean isPaused = false;
	private StateBoard board;
	private View view;

	public Controller(View view) {
		this.view = view;
		this.board = StateBoard.make();
	}

	public void start() {
		if (isPaused)
			return;
		isStarted = true;
		view.start();
	}

	public void pause() {
		if (! isStarted)
			return;
		isPaused = ! isPaused;
		
		if (isPaused)
			view.pause();
		else
			view.resume();
	}

	public void moveLeft() {
		board = board.moveLeft();
		view.update(board.asList());
	}

	public void moveRight() {
		board = board.moveRight();
		view.update(board.asList());
	}

	public void rotateRight() {
		board = board.rotateRight();
		view.update(board.asList());		
	}

	public void rotateLeft() {
		board = board.rotateLeft();
		view.update(board.asList());
	}

	public void dropDown() {
		board = board.dropDown();
		view.update(board.asList());
	}

	public void lineDown() {
		board = board.lineDown();
		view.update(board.asList());
	}

	public void next() {
		board = board.next();
		view.update(board.asList());
	}
}