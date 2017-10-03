package clean.tetris;

class ViewSpy implements View {
	public boolean didStart;
	public int pauses;
	public int resumes;
	public int updates;

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
		didStart = true;
	}

	@Override
	public void resume(int numLinesRemoved) {
		resumes++;
	}

	@Override
	public void pause() {
		pauses++;
	}

	@Override
	public void notifyGameOver() {
		// TODO Auto-generated method stub

	}
}