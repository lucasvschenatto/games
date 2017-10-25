package clean.tetris;

public abstract class Game {
	protected abstract void start();
	
    public void run() {
        this.start();
        while(true){
        	if(Context.GAME_OVER)
        		return;
        }
        
    }
}