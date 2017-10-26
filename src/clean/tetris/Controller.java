package clean.tetris;

public class Controller {

	private boolean isStarted = false;
	private boolean isPaused = false;
	private StateBoard board;
	private View view;
	private Timer timer;

	public Controller(View view, Timer timer) {
		this.view = view;
		this.timer = timer;
		this.board = StateBoard.make(this);
	}

	public void start() {
		if (isPaused)
			return;
		isStarted = true;
		timer.start();
		view.start();
	}

	public void pause() {
		if (! isStarted)
			return;
		isPaused = ! isPaused;
		
		if (isPaused){
			timer.stop();
			view.pause();
		}
		else{
			timer.start();
			view.resume();
		}
		board = board.pause();
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

	public void notifyGameOver() {
		Context.GAME_OVER = true;
		timer.stop();
		view.notifyGameOver();
	}
}