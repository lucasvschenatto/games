package clean.tetris;

import java.util.List;

class ViewSpy implements View {
	public boolean started;
	public int pauses;
	public int resumes;
	public int updates;
	public int startCount;
	public boolean paused;

	@Override
	public void start() {
		started = true;
		startCount++;
	}

	@Override
	public void resume() {
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

	@Override
	public void updateBoard(List<String> board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWaitingPiece(List<String> waitingPiece) {
		// TODO Auto-generated method stub
		
	}
}