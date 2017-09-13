package cleanCode;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Keyboard extends KeyAdapter {
     /**
	 * 
	 */
	private final Board board;

	/**
	 * @param board
	 */
	Keyboard(Board board) {
		this.board = board;
	}

	public void keyPressed(KeyEvent e) {

         if (!board.isStarted || board.curPiece instanceof NoShape) {
             return;
         }

         int keycode = e.getKeyCode();

         if (keycode == 'p' || keycode == 'P') {
             board.pause();
             return;
         }

         if (board.isPaused)
             return;

         switch (keycode) {
         case KeyEvent.VK_LEFT:
             if(board.canMove(board.curPiece, board.curX - 1, board.curY))
            	 board.move(board.curPiece, board.curX - 1, board.curY);
             break;
         case KeyEvent.VK_RIGHT:
             if(board.canMove(board.curPiece, board.curX + 1, board.curY))
            	 board.move(board.curPiece, board.curX + 1, board.curY);
             break;
         case KeyEvent.VK_DOWN:
             if(board.canMove(board.curPiece.rotateRight(), board.curX, board.curY))
            	 board.move(board.curPiece.rotateRight(), board.curX, board.curY);
             break;
         case KeyEvent.VK_UP:
             if(board.canMove(board.curPiece.rotateLeft(), board.curX, board.curY))
	             board.move(board.curPiece.rotateLeft(), board.curX, board.curY);
             break;
         case KeyEvent.VK_SPACE:
             board.dropDown();
             break;
         case 'd':
             board.oneLineDown();
             break;
         case 'D':
             board.oneLineDown();
             break;
         }

     }
 }