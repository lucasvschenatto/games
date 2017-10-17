package clean.tetris;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import static clean.tetris.Context.Code.*;
import clean.tetris.shapes.*;

public class BoardTest {

	@Test
	public void is22linesTall() throws Exception {
		Board b = new Board();
		assertEquals(22,b.asList().size());
	}
	
	@Test
	public void is10ColumnsWide() throws Exception {
		List<String> printed = new Board().asList();
		
		for (String line : printed) {
			assertEquals(10,line.length());
		}
		
	}
	
	@Test
	public void newBoardFilledWithMinus() throws Exception {
		List<String> printed = new Board().asList();
		
		for (String line : printed)
			for (int i = 0; i < line.length(); i++) 
				assertEquals(EMPTY.letter, line.charAt(i));
	}
	
	@Test
	public void newPieceStartsOnTop() throws Exception {
		List<String> printed = new Board().add(new SquareShape()).asList();

		String line1 = printed.get(0);
		assertEquals(SQUARE.letter,line1.charAt(4));
		assertEquals(SQUARE.letter,line1.charAt(5));
		
		String line2 = printed.get(1);
		assertEquals(SQUARE.letter,line2.charAt(4));
		assertEquals(SQUARE.letter,line2.charAt(5));
		
	}
	
	@Test
	public void lineDownMovesPieceDown() throws Exception{
		List<String> printed = new Board().add(new SquareShape()).lineDown().asList();
		
		for(String line: printed)
			System.out.println(line);
		
		char squareLetter = SQUARE.letter;
		
		String line1 = printed.get(0);
		assertEquals(EMPTY.letter,line1.charAt(4));
		assertEquals(EMPTY.letter,line1.charAt(5));
		
		String line2 = printed.get(1);
		assertEquals(squareLetter,line2.charAt(4));
		assertEquals(squareLetter,line2.charAt(5));
		
		String line3 = printed.get(2);
		assertEquals(squareLetter,line3.charAt(4));
		assertEquals(squareLetter,line3.charAt(5));
	}
}
