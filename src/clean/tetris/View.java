package clean.tetris;

import java.util.List;

public interface View {
	public void update(List<String> board);

	public void pause();

	public void notifyGameOver();

	public void start();

	public void resume();
}
