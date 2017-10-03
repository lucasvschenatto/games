package clean.tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Keyboard extends KeyAdapter {
	private final Controller controller;

	Keyboard(Controller controller) {
		this.controller = controller;
	}

	public void keyPressed(KeyEvent e) {

         if (!controller.isStarted || controller.curPiece instanceof NoShape) {
             return;
         }

         int keycode = e.getKeyCode();

         if (keycode == 'p' || keycode == 'P') {
             controller.pause();
             return;
         }

         if (controller.isPaused)
             return;

         switch (keycode) {
         case KeyEvent.VK_LEFT:
             if(controller.canMove(controller.curPiece, controller.curX - 1, controller.curY))
            	 controller.move(controller.curPiece, controller.curX - 1, controller.curY);
             return;
         case KeyEvent.VK_RIGHT:
             if(controller.canMove(controller.curPiece, controller.curX + 1, controller.curY))
            	 controller.move(controller.curPiece, controller.curX + 1, controller.curY);
             return;
         case KeyEvent.VK_DOWN:
             if(controller.canMove(controller.curPiece.rotateRight(), controller.curX, controller.curY))
            	 controller.move(controller.curPiece.rotateRight(), controller.curX, controller.curY);
             return;
         case KeyEvent.VK_UP:
             if(controller.canMove(controller.curPiece.rotateLeft(), controller.curX, controller.curY))
	             controller.move(controller.curPiece.rotateLeft(), controller.curX, controller.curY);
             return;
         case KeyEvent.VK_SPACE:
             controller.dropDown();
             return;
         case 'd':
             controller.oneLineDown();
             return;
         case 'D':
             controller.oneLineDown();
             return;
         }

     }
 }