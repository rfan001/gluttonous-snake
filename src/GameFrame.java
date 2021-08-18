import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(String title){
        super(title);
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        GameBoard gameBoard = new GameBoard();
        root.add(gameBoard);
        root.add(new Menu(gameBoard));
        this.addKeyListener(new MyKeyListener());
    }

    @Override
    public void repaint() {
        super.repaint();
    }

}
