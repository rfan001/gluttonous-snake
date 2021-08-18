public class SnakeThread implements Runnable{
    private Snake snake;

    public SnakeThread(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void run() {
        while (true){
            try {
                int rate = 1+SnakeDemo.score/100;
                int temp = 200/rate;
                Thread.sleep(temp);
                if(SnakeDemo.START == 1){
                    if (this.snake.checkHit()){
                        break;
                    }
                    this.snake.move();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
