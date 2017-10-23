package clean.tetris;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.*;

import clean.tetris.tetromino.*;

import static clean.tetris.Context.Code.*;

public class BoardTest {

	private void print(Board board){
		for(String line: board.asList())
			System.out.println(line);
		System.out.println();
	}

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
	public void canChooseHeight() throws Exception {
		Board b = new Board(43,0);
		assertEquals(43,b.asList().size());
	}
	
	@Test
	public void canChooseWidth() throws Exception {
		List<String> printed = new Board(1,27).asList();
		
		for (String line : printed) {
			assertEquals(27,line.length());
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
	public void ifHitsGround_PieceDoesNotGoDown() throws Exception {
		Board board = new Board().add(new SquareShape());
			for (int i = 0; i < 21; i++)
				board.lineDown();			
		try {
			board.asList();
		} catch (IndexOutOfBoundsException e) {
			fail("tried to move piece down beyond grid");
		}
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
	public void canNotMoveIfHitsFreezedPiece() throws Exception {
		Board board = new Board().add(new SquareShape()).dropDown().add(new SquareShape());
		for (int i = 0; i < 18; i++)
			board.lineDown();
		assertFalse(board.canMoveLineDown());
	}
	
	@Test
	public void dropDownTwoPiecesStacksThem() throws Exception {
		Board board = new Board().add(new SquareShape()).dropDown().add(new SquareShape()).dropDown();
		List<String> grid = board.asList();

		for(int i = 18; i < grid.size(); i++){
			assertEquals(grid.get(i).charAt(5),SQUARE.letter);
			assertEquals(grid.get(i).charAt(4),SQUARE.letter);
		}
	}
	
	@Test
	public void whenThereIsNoPlaceToNewPiece_GameOver() throws Exception {
		Board board = new Board();
		
		for(int i = 0; i < 11; i++)
			board.add(new SquareShape()).dropDown();
		
		board.add(new SquareShape());
		assertTrue(board.isGameOver());
	}
	
	@Test
	public void whenMoveLeft_thenPieceGoesLeft() throws Exception {
		Board board = new Board().add(new SquareShape()).moveLeft();
		
		List<String> printed = board.asList();
		String line1 = printed.get(0);
		assertEquals(SQUARE.letter,line1.charAt(3));
		assertEquals(SQUARE.letter,line1.charAt(4));
		
		String line2 = printed.get(1);
		assertEquals(SQUARE.letter,line2.charAt(3));
		assertEquals(SQUARE.letter,line2.charAt(4));
	}
	
	@Test
	public void whenCanNotMoveLeft_thenPieceDoesNotMove() throws Exception {
		Board board = new Board().add(new LineShape()).moveLeft().moveLeft().dropDown();
		
		board.add(new SquareShape());

		for(int i = 0; i < 20; i++)
			board.lineDown();
		
		board.moveLeft();
		
		List<String> printed = board.asList();
		String line21 = printed.get(20);
		assertEquals(SQUARE.letter,line21.charAt(4));
		assertEquals(SQUARE.letter,line21.charAt(5));
		
		String line22 = printed.get(21);
		assertEquals(SQUARE.letter,line22.charAt(4));
		assertEquals(SQUARE.letter,line22.charAt(5));
	}
	
	@Test
	public void canNotMoveLeftBeyondFirstColumn() throws Exception {
		Board board = new Board().add(new SquareShape());
		
		for(int i = 0; i < 5; i++)
			board.moveLeft();

		List<String> printed = board.asList();
		String line1 = printed.get(0);
		assertEquals(SQUARE.letter,line1.charAt(0));
		assertEquals(SQUARE.letter,line1.charAt(1));
		
		String line2 = printed.get(1);
		assertEquals(SQUARE.letter,line2.charAt(0));
		assertEquals(SQUARE.letter,line2.charAt(1));
	}
	
	@Test
	public void whenMoveRight_thenPieceGoesRight() throws Exception {
		Board board = new Board().add(new SquareShape()).moveRight();
		
		List<String> printed = board.asList();
		String line1 = printed.get(0);
		assertEquals(SQUARE.letter,line1.charAt(5));
		assertEquals(SQUARE.letter,line1.charAt(6));
		
		String line2 = printed.get(1);
		assertEquals(SQUARE.letter,line2.charAt(5));
		assertEquals(SQUARE.letter,line2.charAt(6));
	}
	

	@Test
	public void whenCanNotMoveRight_thenPieceDoesNotMove() throws Exception {
		Board board = new Board().add(new LineShape()).moveRight().dropDown();
		
		board.add(new SquareShape());

		for(int i = 0; i < 20; i++)
			board.lineDown();
		
		board.moveRight();
		
		List<String> printed = board.asList();
		String line21 = printed.get(20);
		assertEquals(SQUARE.letter,line21.charAt(4));
		assertEquals(SQUARE.letter,line21.charAt(5));
		
		String line22 = printed.get(21);
		assertEquals(SQUARE.letter,line22.charAt(4));
		assertEquals(SQUARE.letter,line22.charAt(5));
	}
	
	@Test
	public void canNotMoveRighttBeyondLastColumn() throws Exception {
		Board board = new Board().add(new SquareShape());
		
		for(int i = 0; i < 5; i++)
			board.moveRight();

		List<String> printed = board.asList();
		String line1 = printed.get(0);
		assertEquals(SQUARE.letter,line1.charAt(8));
		assertEquals(SQUARE.letter,line1.charAt(9));
		
		String line2 = printed.get(1);
		assertEquals(SQUARE.letter,line2.charAt(8));
		assertEquals(SQUARE.letter,line2.charAt(9));
	}
	
	@Test
	public void whenRotateLeft_PieceRotatesLeft() throws Exception {
		Board board = new Board().add(new LineShape());

		board.rotateLeft();
		
		List<String> printed = board.asList();

		String line3 = printed.get(2);
		assertEquals(LINESHAPE.letter,line3.charAt(4));
		assertEquals(LINESHAPE.letter,line3.charAt(5));
		assertEquals(LINESHAPE.letter,line3.charAt(6));
		assertEquals(LINESHAPE.letter,line3.charAt(7));
		
		
	}
	
	@Test
	public void whenCanNotRotateLeft_PieceDoesntMove() throws Exception {
		Board board = new Board().add(new SShape()).rotateLeft();
		
		List<String> printed = board.asList();
		
		String line1 = printed.get(0);
		assertEquals(SSHAPE.letter,line1.charAt(5));
		assertEquals(SSHAPE.letter,line1.charAt(6));
		
		String line2 = printed.get(1);
		assertEquals(SSHAPE.letter,line2.charAt(4));
		assertEquals(SSHAPE.letter,line2.charAt(5));
		
		
	}
	
	
	@Test
	public void whenRotateRight_PieceRotatesRight() throws Exception {
		Board board = new Board().add(new TShape()).lineDown().rotateRight();
		
		List<String> printed = board.asList();
		
		String line1 = printed.get(0);
		assertEquals(TSHAPE.letter,line1.charAt(5));
		
		String line2 = printed.get(1);
		assertEquals(TSHAPE.letter,line2.charAt(4));
		assertEquals(TSHAPE.letter,line2.charAt(5));
		
		String line3 = printed.get(2);
		assertEquals(TSHAPE.letter,line3.charAt(5));
		
	}
	
	@Test
	public void whenCanNotRotateRight_PieceDoesntMove() throws Exception {
		Board board = new Board().add(new TShape()).rotateRight();
		
		List<String> printed = board.asList();
		
		String line1 = printed.get(0);
		assertEquals(TSHAPE.letter,line1.charAt(4));
		assertEquals(TSHAPE.letter,line1.charAt(5));
		assertEquals(TSHAPE.letter,line1.charAt(6));
		
		String line2 = printed.get(1);
		assertEquals(TSHAPE.letter,line2.charAt(5));
		
	}
	
	@Test
	public void freezesPiece() throws Exception {
		Board board = new Board().add(new SquareShape()).moveLeft().moveLeft().moveLeft().moveLeft();
		board.freezePiece();
		board.add(new SquareShape());
		
		List<String> printed = board.asList();
		String line1 = printed.get(0);
		assertEquals(SQUARE.letter,line1.charAt(0));
		assertEquals(SQUARE.letter,line1.charAt(1));
		
		String line2 = printed.get(1);
		assertEquals(SQUARE.letter,line2.charAt(0));
		assertEquals(SQUARE.letter,line2.charAt(1));
	}
	
	@Test
	public void clearFullLines() throws Exception {
		Board board = new Board();
		board.add(new SquareShape()).moveLeft().moveLeft().moveLeft().moveLeft().dropDown();
		board.add(new SquareShape()).moveLeft().moveLeft().dropDown();
		board.add(new SquareShape()).dropDown();
		board.add(new SquareShape()).moveRight().moveRight().dropDown();
		board.add(new SquareShape()).moveRight().moveRight().moveRight().moveRight().dropDown();
		board.clearFullLines();
		
		List<String> printed = board.asList();
		String line21 = printed.get(20);
		for(char letter: line21.toCharArray())
			assertEquals(EMPTY.letter, letter);
		
		String line22 = printed.get(21);
		for(char letter: line22.toCharArray())
			assertEquals(EMPTY.letter, letter);
	}
	
	@Test
	public void clearFullLines_ShiftsRemainingLinesDown() throws Exception {
		Board board = new Board();
		board.add(new SquareShape()).moveLeft().moveLeft().moveLeft().moveLeft().dropDown();
		board.add(new SquareShape()).moveLeft().moveLeft().dropDown();
		board.add(new SquareShape()).dropDown();
		board.add(new SquareShape()).dropDown();
		board.add(new SquareShape()).moveRight().moveRight().dropDown();
		board.add(new SquareShape()).moveRight().moveRight().moveRight().moveRight().dropDown();
		board.clearFullLines();
		
		List<String> printed = board.asList();
		String secondLastLine = printed.get(printed.size() - 2);
		assertEquals(SQUARE.letter,secondLastLine.charAt(4));
		assertEquals(SQUARE.letter,secondLastLine.charAt(5));
		
		String lastLine = printed.get(printed.size() - 1);
		assertEquals(SQUARE.letter,lastLine.charAt(4));
		assertEquals(SQUARE.letter,lastLine.charAt(5));
	}
	
	@Test
	public void currentPieceDoesNotCountToConsiderLineFull() throws Exception {
		Board board = new Board();
		board.add(new SquareShape()).moveLeft().moveLeft().moveLeft().moveLeft().dropDown();
		board.add(new SquareShape()).moveLeft().moveLeft().dropDown();
		board.add(new SquareShape()).dropDown();
		board.add(new SquareShape()).moveRight().moveRight().dropDown();
		board.add(new SquareShape()).moveRight().moveRight().moveRight().moveRight();
		for(int i = 0; i< 21; i++)
			board.lineDown();
		
		board.clearFullLines();
		
		List<String> printed = board.asList();
		String line21 = printed.get(20);
		for(char letter: line21.toCharArray())
			assertEquals(SQUARE.letter, letter);
		
		String line22 = printed.get(21);
		for(char letter: line22.toCharArray())
			assertEquals(SQUARE.letter, letter);
	}


}
