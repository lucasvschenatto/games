package clean.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TetrisJPanel extends JPanel{
	private static final long serialVersionUID = 176803555182914844L;
	private String[][] board;
	public TetrisJPanel(){
		setFocusable(true);
	}
	
    int squareWidth() { return (int) getSize().getWidth() / getBoardWidth(); }

	private int getBoardWidth() {
		return board.length;
	}
    int squareHeight() { return (int) getSize().getHeight() / getBoardHeight(); }

	private int getBoardHeight() {
		return board[0].length;
	}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(board == null)
        	return;
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - getBoardHeight() * squareHeight();


        for (int i = 0; i < getBoardWidth(); ++i) {
            for (int j = 0; j < getBoardHeight(); ++j) {
                if (this.board[i][j] != null)
                    drawSquare(g, 0 + i * squareWidth(),
                               boardTop + j * squareHeight(), new Color(255,255,255));
            }
        }

//        if (curPiece != null) {
//            for (int i = 0; i < 4; ++i) {
//                int x = curX + curPiece.x(i);
//                int y = curY - curPiece.y(i);
//                drawSquare(g, 0 + x * squareWidth(),
//                           boardTop + (height - y - 1) * squareHeight(),
//                           curPiece);
//            }
//        }
    }
    
    private void drawSquare(Graphics g, int x, int y, Color color){
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                         x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                         x + squareWidth() - 1, y + 1);
    }

	public void repaintBoard(String[][] board) {
		this.board = board;
		repaint();
	}
}
