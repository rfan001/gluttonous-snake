import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    private static int WIDTH = 200;
    private static int HEIGHT = 400;
    private static int OFF_HEIGHT = 50;
    private static int OFF_WIDTH = 500;
    private static JButton startButton = new JButton("Start");
    private static JButton pauseButton = new JButton("Pause");
    private static JButton restartButton = new JButton("Restart");
    private static JLabel score = new JLabel("Score: "+SnakeDemo.score);
    private GameBoard gameBoard;
    public Menu(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.setSize(WIDTH,HEIGHT);
        this.setLocation(OFF_WIDTH,OFF_HEIGHT);
        this.setLayout(null);
        score.setBounds(50,135,100,25);
        startButton.setBounds(50,170,100,25);
        pauseButton.setBounds(50,205,100,25);
        restartButton.setBounds(50,245,100,25);
        pauseButton.setEnabled(false);
        restartButton.setEnabled(false);
        startButton.addActionListener(e -> {
            getTopLevelAncestor().requestFocus(); //重要
            SnakeDemo.START = 1;
            startButton.setEnabled(false);
            pauseButton.setEnabled(true);

        });
        pauseButton.addActionListener(e -> {
            SnakeDemo.START = 0;
            getTopLevelAncestor().requestFocus(); //重要
            startButton.setEnabled(true);
            pauseButton.setEnabled(false);
        });
        restartButton.addActionListener(e -> {
            getTopLevelAncestor().requestFocus(); //重要
            gameBoard.restart();
        });
        startButton.setFocusPainted(false);
        this.add(score);
        this.add(startButton);
        this.add(pauseButton);
        this.add(restartButton);
    }
    public static void addRestartButton(){
        pauseButton.setEnabled(false);
        restartButton.setEnabled(true);
    }
    public static void restart(){
        pauseButton.setEnabled(false);
        restartButton.setEnabled(false);
        startButton.setEnabled(true);
        SnakeDemo.score = 0;
        changeScore();
    }
    public static void changeScore(){
        score.setText("Score: "+SnakeDemo.score);
    }

}
