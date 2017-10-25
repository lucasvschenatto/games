package clean.tetris;

public abstract class Game {
	protected abstract void start();
	
    public void run() {
        this.start();
        while(! Context.FINISHED){ }
    }
}