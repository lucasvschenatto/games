package clean.tetris;

import clean.tetris.board.state.StateBoard;

public class Controller {

	private boolean paused;
	private StateBoard stateBoard;
	private View view;
	private Timer timer;

	public Controller(View view, Timer timer) {
		this.view = view;
		this.timer = timer;
		this.stateBoard = StateBoard.start(this);
	}

	public void start() {
		timer.start();
		view.start();
	}

	public void pause() {
		stateBoard = stateBoard.pause();

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
		stateBoard = stateBoard.moveLeft();
		view.updateBoard(stateBoard.getBoard());
	}

	public void moveRight() {
		stateBoard = stateBoard.moveRight();
		view.updateBoard(stateBoard.getBoard());
	}

	public void rotateRight() {
		stateBoard = stateBoard.rotateRight();
		view.updateBoard(stateBoard.getBoard());		
	}

	public void rotateLeft() {
		stateBoard = stateBoard.rotateLeft();
		view.updateBoard(stateBoard.getBoard());
	}

	public void dropDown() {
		stateBoard = stateBoard.dropDown();
		view.updateBoard(stateBoard.getBoard());
	}

	public void lineDown() {
		stateBoard = stateBoard.lineDown();
		view.updateBoard(stateBoard.getBoard());
	}

	public void next() {
		stateBoard = stateBoard.next();
		view.updateBoard(stateBoard.getBoard());
	}

	public void notifyGameOver() {
		Context.GAME_OVER = true;
		timer.stop();
		view.notifyGameOver();
	}

	public void newWaitingTetromino() {
		view.updateWaitingPiece(stateBoard.getWaitingPiece());
	}
}