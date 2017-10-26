package clean.tetris;

import clean.tetris.board.state.StateBoard;

public class Controller {

	private boolean paused;
	private StateBoard boardState;
	private View view;
	private Timer timer;

	public Controller(View view, Timer timer) {
		this.view = view;
		this.timer = timer;
		this.boardState = StateBoard.make(this);
	}

	public void start() {
		timer.start();
		view.start();
	}

	public void pause() {
		boardState = boardState.pause();

		paused = ! paused;		
		if (paused){
			timer.stop();
			view.pause();
		}
		else{
			timer.start();
			view.resume();
		}
	}

	public void moveLeft() {
		boardState = boardState.moveLeft();
		view.update(boardState.asList());
	}

	public void moveRight() {
		boardState = boardState.moveRight();
		view.update(boardState.asList());
	}

	public void rotateRight() {
		boardState = boardState.rotateRight();
		view.update(boardState.asList());		
	}

	public void rotateLeft() {
		boardState = boardState.rotateLeft();
		view.update(boardState.asList());
	}

	public void dropDown() {
		boardState = boardState.dropDown();
		view.update(boardState.asList());
	}

	public void lineDown() {
		boardState = boardState.lineDown();
		view.update(boardState.asList());
	}

	public void next() {
		boardState = boardState.next();
		view.update(boardState.asList());
	}

	public void notifyGameOver() {
		Context.GAME_OVER = true;
		timer.stop();
		view.notifyGameOver();
	}
}