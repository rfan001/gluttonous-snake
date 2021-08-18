import javax.swing.*;

public class SnakeDemo
{
    public static int START = 0;
    public static int score = 0;

    private static void createGUI()
    {
        JFrame frame = new GameFrame("Gluttonous Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocation(400,200);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                createGUI();
            }
        });

    }
}
