import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GameModel extends JPanel implements Runnable {

    Thread gameThread;

    //FPS
    int FPS = 60;
    int screenWidth = 800, screenHeight = 600;  //choose screenWidth and screenHeight here

    public GameModel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void update() {
        //update game status here, no drawing
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; //~0.01666seconds, or 1/60
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int frames = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval; //amount of time passed divided by drawInterval
            //once the amount of time passed has reached the drawInterval, then it will be >=1
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= 1) {
                //Update stuff like character positions
                update();
                //Draw the screen with updated stuff
                repaint();
                //reset delta and increment frame count
                delta = 0;
                frames++;
            }

            //if 1 second has passed, print information and reset frame counter and timer
            if (timer >= 1000000000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer = 0;
            }

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        //draw stuff here

        //dispose(clear up memory)
        g2d.dispose();
    }
}
