import com.sun.prism.paint.*;

import java.awt.*;
import java.awt.Color;

public class GameBackground {

    public static final int HEIGHT_TOP = 100;
    public static final int HEIGHT_BOT = 600;

    public void draw(Graphics2D g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        // Draw yellow panels
        g.setColor(Color.yellow);
        g.fillRect(0, 0, Main.WIDTH, GameBackground.HEIGHT_TOP);
        g.fillRect(0, 600, Main.WIDTH, GameBackground.HEIGHT_BOT);
    }
}
