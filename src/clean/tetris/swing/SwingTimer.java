package clean.tetris.swing;

import javax.swing.Timer;

import clean.tetris.Controller;

public class SwingTimer implements clean.tetris.Timer{
	private TimeListener listener;
	private Timer timer;
	public SwingTimer(int delay){
		listener = new TimeListener();
		timer = new Timer(delay, listener);
	}
	@Override
	public void start() {
		timer.start();
	}

	@Override
	public void stop() {
		timer.stop();
	}

	@Override
	public void setController(Controller controller) {
		listener.setController(controller);
	}

}
