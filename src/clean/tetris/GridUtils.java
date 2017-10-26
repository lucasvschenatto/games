package clean.tetris;

import static clean.tetris.Context.Code.EMPTY;

import java.util.List;

public class GridUtils {
	
	public static void overlapLetterOnGrid(List<String> targetGrid, char letter, int lineIndex, int charIndex) {
		String line = targetGrid.get(lineIndex);
		String lineWithLetter = overlapLetterOnLine(letter, line, charIndex);

		targetGrid.set(lineIndex, lineWithLetter);
	}
	
	private static String overlapLetterOnLine(char letter, String line, int charIndex) {
		String prefix = line.substring(0, charIndex);
		String sufix = line.substring(charIndex + 1);

		return prefix.concat(String.valueOf(letter).concat(sufix));
	}
	
	public static String makeEmptyLine(int width) {
		String line = new String();
		for (int i = 0; i < width; i++)
			line = line.concat(String.valueOf(EMPTY));
		return line;
	}

}
