package clean.tetris;

public class Context {
	
	public enum Code{
		EMPTY('-'), NOSHAPE('_'), SQUARE('Q'), LINESHAPE('I'), LSHAPE('L'), JSHAPE('J'), TSHAPE('J'), ZSHAPE('Z'), SSHAPE('S');
		
		public char letter;
		Code(char letter ){
			this.letter = letter;
		}
		
		public String toString(){
			return String.valueOf(letter);
		}
		
	};

}
