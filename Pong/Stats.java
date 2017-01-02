import java.io.*;

public class Stats implements Serializable {

    public static boolean lost;
    public static int score = 0;
    public static int highScore = 0;

    public Stats() {
        try {
            FileReader reader = new FileReader("stats.txt");
            highScore = reader.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void update() {
        if (score > highScore) highScore = score;
    }
}
