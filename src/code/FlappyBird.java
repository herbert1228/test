package code;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlappyBird implements ActionListener {

    public static FlappyBird flappyBird;

    public final int WIDTH = 800, HEIGHT = 800;

    public Rectangle bird;

    public Renderer renderer;

    public FlappyBird() {

        JFrame jframe = new JFrame();
        Timer timer = new Timer(20, this);

        renderer = new Renderer();

        jframe.add(renderer);
        jframe.setTitle("Flappy Bird");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setResizable(false);
        jframe.setVisible(true);

        bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);

        timer.start();
    }

    public void repaint(Graphics g) {

        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.red);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);
    }

    public static void main(String[] args) {
        flappyBird = new FlappyBird();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderer.repaint();
    }

}
