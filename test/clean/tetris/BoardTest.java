package clean.tetris;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.*;

import clean.tetris.tetromino.*;

import static clean.tetris.Context.Code.*;

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

		String line1 = printed.get(0);
		assertEquals(EMPTY.letter,line1.charAt(4));
		assertEquals(EMPTY.letter,line1.charAt(5));
		
		String line2 = printed.get(1);
		assertEquals(SQUARE.letter,line2.charAt(4));
		assertEquals(SQUARE.letter,line2.charAt(5));
		
		String line3 = printed.get(2);
		assertEquals(SQUARE.letter,line3.charAt(4));
		assertEquals(SQUARE.letter,line3.charAt(5));
	}
	
	@Test
	public void ifHitsGroundCantMoveLineDown() throws Exception {
		Board board = new Board().add(new SquareShape());
		for (int i = 0; i < 20; i++)
			board.lineDown();
		assertFalse(board.canMoveLineDown());
	}
	@Test
	public void ifDoesntHitGroundCanMoveLineDown() throws Exception {
		Board board = new Board().add(new SquareShape());
		for (int i = 0; i < 20; i++){
			assertTrue(board.canMoveLineDown());
			board.lineDown();
		}
	}
	@Test
	public void onDropDownSendsPieceToGround() throws Exception {
		Board board = new Board().add(new SquareShape()).dropDown();
		
		List<String> printed = board.asList();
		
		String secondLastLine = printed.get(printed.size() - 2);
		assertEquals(SQUARE.letter,secondLastLine.charAt(4));
		assertEquals(SQUARE.letter,secondLastLine.charAt(5));
		
		String lastLine = printed.get(printed.size() - 1);
		assertEquals(SQUARE.letter,lastLine.charAt(4));
		assertEquals(SQUARE.letter,lastLine.charAt(5));
	}
	
	@Test
	public void afterDropDownThereIsNoCurrentTetromino() throws Exception {
		Board board = new Board().add(new SquareShape()).dropDown();
		
		
		board.lineDown();
		List<String> printed = board.asList();
		
		for (int i = 0; i < printed.size() - 2; i++) {
			String line = printed.get(i);
			for (int j = 0; j < line.length(); j++) 
				assertEquals(EMPTY.letter, line.charAt(j));
		}
	}
	
	@Test
	public void afterDropDownFreezesOldPieceInGround() throws Exception {
		Board board = new Board().add(new SquareShape()).dropDown();
		
		board.add(new SquareShape());
		board.lineDown();
		
		List<String> printed = board.asList();
		
		String secondLastLine = printed.get(printed.size() - 2);
		assertEquals(SQUARE.letter,secondLastLine.charAt(4));
		assertEquals(SQUARE.letter,secondLastLine.charAt(5));
		
		String lastLine = printed.get(printed.size() - 1);
		assertEquals(SQUARE.letter,lastLine.charAt(4));
		assertEquals(SQUARE.letter,lastLine.charAt(5));
	}
	
	@Test
	public void cantMoveIfHitsFreezedPiece() throws Exception {
		fail("not implemented yet");
	}

}
