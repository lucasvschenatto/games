package clean.tetris;

public class Context {
	
	public enum Code{
		EMPTY('-'), NULLSHAPE('_'), SQUARE('Q'), LINESHAPE('I'), LSHAPE('L'), JSHAPE('J'), TSHAPE('T'), ZSHAPE('Z'), SSHAPE('S');
		
		public char letter;
		Code(char letter ){
			this.letter = letter;
		}
		
		public String toString(){
			return String.valueOf(letter);
		}
		
	}

	public static volatile boolean GAME_OVER;
	public static volatile boolean FINISHED;

}
