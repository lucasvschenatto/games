package clean.tetris.swing;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import clean.tetris.Controller;

class Keyboard extends KeyAdapter {
	private final Controller controller;

	Keyboard(Controller controller) {
		this.controller = controller;
	}

	public void keyPressed(KeyEvent e) {
         switch (e.getKeyCode()) {
         case KeyEvent.VK_P:
        	 controller.pause();
        	 return;
         case 'p':
        	 controller.pause();
        	 return;
         case KeyEvent.VK_LEFT:
             controller.moveLeft();
             return;
         case KeyEvent.VK_RIGHT:
             controller.moveRight();
             return;
         case KeyEvent.VK_UP:
             controller.rotateLeft();
             return;
         case KeyEvent.VK_DOWN:
        	 controller.lineDown();
        	 return;
         case KeyEvent.VK_SPACE:
             controller.dropDown();
             return;
         case KeyEvent.VK_D:
        	 controller.lineDown();
        	 return;
         case 'd':
             controller.lineDown();
             return;
         
         }

     }
 }