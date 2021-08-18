import java.awt.*;
import java.util.Random;

public class Food {
    private Random random = new Random();
    private int x= random.nextInt(40)*10;
    private int y= random.nextInt(40)*10;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
