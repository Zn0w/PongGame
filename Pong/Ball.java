import java.awt.*;

public class Ball {

    private int x, y, r;
    private int speedX = 10;
    private int speedY = 5;
    public static boolean start;

    public Ball(int s_x, int s_y) {
        x = s_x;
        y = s_y;
        r = 10;
    }

    public void update(Board bL, Board bR) {
        if (start) {
            if (x > 0 && x < Main.WIDTH) x -= speedX;
            if (y >= GameBackground.HEIGHT_TOP && y <= GameBackground.HEIGHT_BOT) y -= speedY;

            if ((x <= bL.getX() + 20 || x >= bR.getX() - 20) && (y >= bL.getY() && y <= bL.getY() + 60 || y >= bR.getY() && y <= bR.getY() + 60)) {
                speedX = speedX * -1;
                if (!Stats.lost) Stats.score += Stats.score + 1;
            }
            if (y <= GameBackground.HEIGHT_TOP || y >= GameBackground.HEIGHT_BOT) speedY = speedY * -1;
            if (x <= bL.getX() || x >= bR.getX()) {
                start = false;
                Stats.lost = true;
            }
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        g.fillOval(x, y, r, r);
    }
}
