import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==38){
            if(Snake.direction == 2 || Snake.direction == 3 ){
                Snake.direction = 0; //only direction is left or right can change to up
            }
        } else if(e.getKeyCode()==40){
            if(Snake.direction == 2 || Snake.direction == 3 ){
                Snake.direction = 1; //only direction is left or right can change to down
            }
        } else if(e.getKeyCode()==37){
            if(Snake.direction == 0 || Snake.direction == 1 ){
                Snake.direction = 2; //only direction is up or down can change to left
            }
        } else if(e.getKeyCode()==39){
            if(Snake.direction == 0 || Snake.direction == 1 ){
                Snake.direction = 3; //only direction is up or down can change to right
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
