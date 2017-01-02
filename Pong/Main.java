import javax.swing.*;

public class Main {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    public static JFrame mainFrame;

    public static void main(String[] args) {
        mainFrame = new JFrame("GamePong");
        GamePanel panel = new GamePanel();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setFocusable(true);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null); // To open at center
        mainFrame.setContentPane(panel);

        mainFrame.addKeyListener(new Listeners());

        // Start thread
        panel.setUp();
    }
}
