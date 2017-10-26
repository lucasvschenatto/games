package clean.tetris;

import java.util.List;

public interface View {
	public void updateBoard(List<String> board);
	
	public void updateWaitingPiece(List<String> waitingPiece);

	public void pause();

	public void notifyGameOver();

	public void start();

	public void resume();
}
