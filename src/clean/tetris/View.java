package clean.tetris;

public interface View {
	public void update(String[][] board);

	public void pause();

	public void updateStatus(String newStatus);

	public void notifyGameOver();

	public void start();

	public void resume(int numLinesRemoved);
}
