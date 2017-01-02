import java.awt.*;

public class Board {

    private int x, y;
    private final int speed = 10;
    public static boolean up, down;

    public Board(int s_x, int s_y) {
        x = s_x;
        y= s_y;
    }

    public void update() {
        if (up && y > 0) y -= speed;
        if (down && y < Main.HEIGHT - 60) y += speed;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 20, 60);
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
