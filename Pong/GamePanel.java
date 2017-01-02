import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {

    private Thread thread;

    private BufferedImage image;
    private Graphics2D g;

    private Board boardR;
    private Board boardL;
    private Ball ball;
    private GameBackground background;
    private Stats stat;

    public void setUp() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        image = new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        boardR = new Board(645, 325);
        boardL = new Board(35, 325);
        ball = new Ball(340, 340);
        background = new GameBackground();
        stat = new Stats();

        while (true) {
            gameUpdate();
            gameRender();
            gameDraw();

            if (Stats.lost) {
                load2ndFrame();
                break;
            }

            try {
                thread.sleep(25);
            } catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void gameUpdate() {
        boardR.update();
        boardL.update();
        ball.update(boardL, boardR);
        stat.update();
    }

    public void gameRender() {
        background.draw(g);
        boardR.draw(g);
        boardL.draw(g);
        ball.draw(g);
    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    public void load2ndFrame() {
        JFrame statFrame = new JFrame("Your stats");
        statFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        statFrame.setSize(500, 300);
        statFrame.setLocationRelativeTo(null); // To open centered

        JPanel statPanel = new JPanel();
        statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.Y_AXIS));

        JLabel l_score = new JLabel("Score: " + Stats.score);
        JLabel l_highScore = new JLabel("Highscore: " + Stats.highScore);

        statPanel.add(l_score);
        statPanel.add(l_highScore);
        statFrame.add(statPanel);

        Main.mainFrame.setVisible(false);
        statFrame.setVisible(true);

        // Saving highscore
        try {
            FileWriter writer = new FileWriter("stats.txt", false);
            writer.write(Stats.highScore);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
