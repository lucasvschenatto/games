package clean.tetris.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import clean.tetris.Board;
import clean.tetris.Context;

public class TetrisJPanel extends JPanel{
	private static final long serialVersionUID = 176803555182914844L;
	private List<String> board;
	private Map<Character, Color> colorMapping;
	public TetrisJPanel(){
		setFocusable(true);
		board = new ArrayList<String>();
		board = new Board().asList();
		makeColorMapping();
	}

	private void makeColorMapping() {
		colorMapping = new HashMap<Character,Color>();
		colorMapping.put(Character.valueOf(Context.Code.JSHAPE.letter), Color.BLUE);
		colorMapping.put(Character.valueOf(Context.Code.LSHAPE.letter), Color.ORANGE);
		colorMapping.put(Character.valueOf(Context.Code.SQUARE.letter), Color.YELLOW);
		colorMapping.put(Character.valueOf(Context.Code.LINESHAPE.letter), Color.CYAN);
		colorMapping.put(Character.valueOf(Context.Code.SSHAPE.letter), Color.GREEN);
		colorMapping.put(Character.valueOf(Context.Code.TSHAPE.letter), Color.MAGENTA);
		colorMapping.put(Character.valueOf(Context.Code.ZSHAPE.letter), Color.RED);
	}
	
	private int squareHeight() { return (int) getSize().getHeight() / getBoardHeight(); }
	private int getBoardHeight() {return board.size();}
	
    private int squareWidth() { return (int) getSize().getWidth() / getBoardWidth(); }
    private int getBoardWidth() {return board.get(0).length();}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - getBoardHeight() * squareHeight();

        for (int height = 0; height < getBoardHeight(); ++height)
            for (int width = 0; width < getBoardWidth(); ++width)
                if (board.get(height).charAt(width) != Context.Code.EMPTY.letter)
                    drawSquare(g,
                    		width * squareWidth(),
                    		boardTop + height * squareHeight(),
                    		colorMapping.get(Character.valueOf(board.get(height).charAt(width))));
    }
    
    private void drawSquare(Graphics g, int x, int y, Color color){
        drawLeftUpperLines(g, x, y, color);        
        drawLowerRightLines(g, x, y, color);
        fillRectangle(g, x, y, color);
    }

	private void fillRectangle(Graphics g, int x, int y, Color color) {
		g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
	}

	private void drawLowerRightLines(Graphics g, int x, int y, Color color) {
		g.setColor(color.darker());
        int lowerDarkY = y + squareHeight() - 1;
		int rightHandedDarkX = x + squareWidth() - 1;
		
		g.drawLine(rightHandedDarkX, y + 1,
				rightHandedDarkX, lowerDarkY);
		
		g.drawLine(x + 1, lowerDarkY,
        		rightHandedDarkX, lowerDarkY);
	}

	private void drawLeftUpperLines(Graphics g, int x, int y, Color color) {
		g.setColor(color.brighter());
        g.drawLine(x, y, 
        		x, y + squareHeight() - 1);
        g.drawLine(x, y, 
        		x + squareWidth() - 1, y);
	}

	public void repaintBoard(List<String> board) {
		this.board = board;
		repaint();
	}
}
