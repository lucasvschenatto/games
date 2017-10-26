package clean.tetris.board.state;

import java.util.List;

import clean.tetris.Controller;
import clean.tetris.board.Board;
import clean.tetris.tetromino.Tetromino;

public abstract class StateBoard {
	protected static Board BOARD;
	protected static Controller CONTROLLER;
	protected static StateBoard FINISHED_TETROMINO;
	protected static StateBoard GAME_OVER;
	protected static StateBoard INITIAL;
	protected static StateBoard RUNNING_TETROMINO;
	protected static PausedState PAUSED;	
	
	private static Tetromino NEXT_TETROMINO;

	public static StateBoard start(Controller controller) {
		NEXT_TETROMINO = Tetromino.makeRandom();
		CONTROLLER = controller;
		BOARD = new Board();
		INITIAL = new InitialState();
		RUNNING_TETROMINO = new RunningPieceState();
		FINISHED_TETROMINO = new FinishedPieceState();
		PAUSED = new PausedState();
		GAME_OVER = new GameOverState();
		return INITIAL;
	}


	protected StateBoard() {
	}

	public List<String> getBoard() {
		return BOARD.asList();
	}

	public StateBoard pause(){
		PAUSED.setPrevious(this);
		return PAUSED;
	}
	
	protected Tetromino reloadTetromino(){
		Tetromino current = NEXT_TETROMINO;
		NEXT_TETROMINO = Tetromino.makeRandom();
		return current;
	}

	public abstract StateBoard dropDown();

	public abstract StateBoard lineDown();

	public abstract StateBoard moveLeft();

	public abstract StateBoard moveRight();

	public abstract StateBoard next();
	
	public abstract StateBoard rotateLeft();

	public abstract StateBoard rotateRight();


	public List<String> getWaitingPiece() {
		return NEXT_TETROMINO.asList();
	}
}
