package clean.tetris;

class ViewSpy implements View {
	public boolean started;
	public int pauses;
	public int resumes;
	public int updates;
	public int startCount;
	public boolean paused;

	@Override
	public void updateStatus(String newStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String[][] board) {
		updates++;
	}

	@Override
	public void start() {
		started = true;
		startCount++;
	}

	@Override
	public void resume(int numLinesRemoved) {
		resumes++;
		paused = false;
	}

	@Override
	public void pause() {
		paused = true;
		pauses++;
	}

	@Override
	public void notifyGameOver() {
		// TODO Auto-generated method stub

	}
}