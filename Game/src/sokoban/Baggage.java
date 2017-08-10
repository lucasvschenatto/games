package sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Baggage extends Actor {

    public Baggage(int x, int y) {
        super(x, y);
//        URL loc = this.getClass().getResource("./resources/images/sokoban/"+"baggage.png");
//        ImageIcon iia = new ImageIcon(loc);
        ImageIcon iia = new ImageIcon("./resources/images/sokoban/"+"baggage.png");
        
        Image image = iia.getImage();
        this.setImage(image);
    }

    public void move(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
    }
}