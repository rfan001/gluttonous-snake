import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Snake {
    private LinkedList<SnakeNode> snake;
    private Random random = new Random();
    private SnakeNode head;
    public static int direction;
    private int length=2;
    private GameBoard gameBoard;
    private Food food;
    public Snake(GameBoard gameBoard, Food food1) {
        snake = new LinkedList<>();
        int x= random.nextInt(40)*10;
        while (x==0){
            x= random.nextInt(40)*10;
        }
        int y= random.nextInt(39)*10;
        head = new SnakeNode(x,y);
        snake.addFirst(head);
        snake.add(new SnakeNode(x,y+10));
        this.gameBoard = gameBoard;
        while (checkFoodInSnack(food1)){
            food1 = new Food();
        }
        this.food = food1;
        this.gameBoard.setFood(food1);
    }

    public LinkedList<SnakeNode> getSnake() {
        return snake;
    }

    public boolean gotFood(){
        if(head.getX() == this.food.getX() && head.getY() == this.food.getY()){
            this.length++;
            SnakeDemo.score += 10;
            Menu.changeScore();
            Food newFood = new Food();
            while (checkFoodInSnack(newFood)){
                newFood = new Food();
            }
            this.food = newFood;
            this.gameBoard.setFood(food);
            return true;
        }
        return false;
    }

    private boolean checkFoodInSnack(Food newFood) {
        for (SnakeNode node:snake) {
            if(newFood.getX()==node.getX()&&newFood.getY()==node.getY()) return true;
        }
        return false;
    }

    public boolean checkHit(){
        if(head.getX()>=400 || head.getY()>=400 || head.getX()<0 || head.getY()<0){
            return true;
        }
        for (int i = 0; i < this.snake.size(); i++) {
            if(i==0) continue;
            if(this.snake.get(i).getX()==head.getX()&&this.snake.get(i).getY()==head.getY()) {
                return true;
            }
        }
        return false;
    }

    public void move(){
        if(!this.gotFood()){
            snake.remove(length-1);
        }
        int a=0;
        int b=0;
        switch (direction){
            case 0:
            {
                b=-10;
                break;
            }
            case 1:
            {
                b=10;
                break;
            }
            case 2:
            {
                a=-10;
                break;
            }
            case 3:
            {
                a=10;
                break;
            }
        }
        SnakeNode node = new SnakeNode(this.head.getX()+a, this.head.getY()+b);

        snake.addFirst(node);
        head=node;
        if(checkHit()) {
            SnakeDemo.START = 0;
            JOptionPane.showMessageDialog(this.gameBoard, "Game Over！");
            Menu.addRestartButton();
            return;
        }
        gameBoard.repaint(new Rectangle(0,0,400,400));
    }
}
