package clean.tetris.console;

import java.util.TimerTask;

import clean.tetris.Controller;
import clean.tetris.Timer;

public class ConsoleTimer extends java.util.Timer implements Timer{

	private Controller controller;
	private long miliseconds;
	private Tick tick;
	public ConsoleTimer(long miliseconds){
		super("Ticking timer", true);
		this.miliseconds = miliseconds;
	}
	@Override
	public void start() {
		tick = new Tick();
		schedule( tick, 0, miliseconds);
	}

	@Override
	public void stop() {
		tick.cancel();
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	class Tick extends TimerTask{
		@Override
		public void run() {
			controller.next();
		}		
	}

}
