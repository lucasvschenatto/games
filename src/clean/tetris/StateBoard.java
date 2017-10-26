package clean.tetris;

import java.util.List;

public abstract class StateBoard {
	protected static Board BOARD;
	protected static Controller CONTROLLER;
	protected static StateBoard FINISHED_PIECE;
	protected static StateBoard GAME_OVER;
	protected static StateBoard INITIAL;
	protected static StateBoard RUNNING_PIECE;
	protected static PausedState PAUSED;	

	public static StateBoard make(Controller controller) {
		CONTROLLER = controller;
		BOARD = new Board();
		INITIAL = new InitialState();
		RUNNING_PIECE = new RunningPieceState();
		FINISHED_PIECE = new FinishedPieceState();
		PAUSED = new PausedState();
		GAME_OVER = new GameOverState();
		return INITIAL;
	}

	protected StateBoard() {
	}

	public List<String> asList() {
		return BOARD.asList();
	}

	public StateBoard pause(){
		PAUSED.setPrevious(this);
		return PAUSED;
	}

	public abstract StateBoard dropDown();

	public abstract StateBoard lineDown();

	public abstract StateBoard moveLeft();

	public abstract StateBoard moveRight();

	public abstract StateBoard next();
	
	public abstract StateBoard rotateLeft();

	public abstract StateBoard rotateRight();;
}
