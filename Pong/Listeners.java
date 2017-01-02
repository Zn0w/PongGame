import java.awt.event.*;

public class Listeners implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) Board.up = true;
        if (key == KeyEvent.VK_DOWN) Board.down = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) Board.up = false;
        if (key == KeyEvent.VK_DOWN) Board.down = false;

        if (key == KeyEvent.VK_ENTER) Ball.start = true;
    }
}
