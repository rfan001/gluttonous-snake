import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.LinkedList;

public class GameBoard extends JPanel {
    private static int GAMEBOARD_WIDTH = 400;
    private static int GAMEBOARD_HEIGHT = 400;
    private static int LOCATION_HEIGHT = 50;
    private static int LOCATION_WIDTH = 50;
    private Food food = new Food();
    private Snake snake = new Snake(this,food);

    public GameBoard() {
        this.setSize(GAMEBOARD_WIDTH,GAMEBOARD_HEIGHT);
        this.setLocation(LOCATION_WIDTH,LOCATION_HEIGHT);
        Border border = BorderFactory.createLineBorder(Color. GRAY, 1);
        this.setBorder(border);

        Thread thread = new Thread(new SnakeThread(this.snake));
        thread.start();

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);   //important or you need to repaint boarder
        g.setColor(Color.gray);  //paint food
        g.fillRect(food.getX(), food.getY(), 10, 10);
        //paint snake;
        LinkedList<SnakeNode> snake1 = snake.getSnake();
        for (int i = 0; i < snake1.size(); i++) {
            if(i==0){
                g.setColor(Color.orange);   //head is orange;
            } else {
                g.setColor(Color.green);
            }
            g.fillRect(snake1.get(i).getX(),snake1.get(i).getY() , 10, 10);
        }
    }

    public void setFood(Food food) {
        this.food = food;
        this.repaint(0,0,400,400);
    }

    public void restart() {
        this.food = new Food();
        this.snake = new Snake(this,food);

        Thread thread = new Thread(new SnakeThread(this.snake));
        thread.start();
        this.repaint(0,0,400,400);
        Menu.restart();
    }
}
