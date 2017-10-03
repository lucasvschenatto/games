package bad.sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Area extends Actor {

    public Area(int x, int y) {
        super(x, y);

//        URL loc = this.getClass().getResource("./resources/images/bad.sokoban/"+"area.png");
//        ImageIcon iia = new ImageIcon(loc);
        ImageIcon iia = new ImageIcon("./resources/images/bad.sokoban/"+"area.png");
        Image image = iia.getImage();
        this.setImage(image);
    }
}