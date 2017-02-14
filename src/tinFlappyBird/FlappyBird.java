package tinFlappyBird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.List;
import java.util.ArrayList;

public class FlappyBird {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Simulation simulation = new Simulation(new Vec2(800, 800));
        frame.add(simulation);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // stage setup
        simulation.entities.add(new Player(simulation));
        Pipe.randomPipe(simulation);
    }
}

class Simulation extends JComponent implements ActionListener, KeyListener {
    private static double targetFps = 120;
    private static final int pipeInterval = 2300; //ms

    double timeElapsed;
    Vec2 size;
    List<Entity> entities;
    Timer timer;

    public Simulation(Vec2 size) {
        super();
        this.timeElapsed = 0;
        this.size = size;
        entities = new ArrayList<Entity>();

        setFocusable(true);
        setPreferredSize(new Dimension((int) size.x, (int) size.y));
        addKeyListener(this);
        timer = new Timer((int) (1000.0 / targetFps), this);
        timer.start();

        Timer pipeGenerator = new Timer(pipeInterval, e -> Pipe.randomPipe(this));
        pipeGenerator.start();
    }

    public void reset() {
        SwingUtilities.invokeLater(() -> {
            entities.removeIf(ent -> ent instanceof Pipe);
        });
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(101, 175, 172));
        g.fillRect(0, 0, (int) size.x, (int) size.y);

        for (Entity ent : entities) {
            ent.render(g);
        }
    }

    public void keyPressed(KeyEvent e) {
        for (Entity ent : entities) {
            ent.keyPressed(e);
        }
    }

    public void keyReleased(KeyEvent e) {
        for (Entity ent : entities) {
            ent.keyPressed(e);
        }
    }

    public void keyTyped(KeyEvent e) {
        for (Entity ent : entities) {
            ent.keyPressed(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        double dt = 1 / targetFps;
        timeElapsed += dt;
        for (Entity ent : entities) {
            ent.update(dt);
        }
        repaint();
    }
}

class Entity implements KeyListener {
    protected Vec2 position;
    protected Vec2 velocity;
    protected Vec2 acceleration;

    protected Vec2 size;
    protected Color color;

    protected Simulation stage;

//    protected Image image = null;

    private boolean overlap(double x0, double x1, double y0, double y1) {
        return !(x1 < y0 || y1 < x0);
    }

    public Entity(Simulation stage) {
        this.stage = stage;
        position = new Vec2();
        velocity = new Vec2();
        acceleration = new Vec2();
        size = new Vec2(1, 1);
        color = new Color(219, 218, 94);
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) position.x, (int) position.y, (int) size.x, (int) size.y);

//        if(image!=null){ //horse
//            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
//        }
    }

    public void physicsUpdate(double dt) {
        velocity = velocity.add(acceleration.mul(dt));
        position = position.add(velocity.mul(dt));
    }

    public boolean collideWith(Entity other) {
        return overlap(top(), bottom(), other.top(), other.bottom()) &&
                overlap(left(), right(), other.left(), other.right());
    }

    public void update(double dt) {
        physicsUpdate(dt);
    }

    private double top() {
        return position.y;
    }

    private double bottom() {
        return position.y + size.y;
    }

    private double left() {
        return position.x;
    }

    private double right() {
        return position.x + size.x;
    }

    public void keyPressed(KeyEvent e) {
        /* nothing */
    }

    public void keyReleased(KeyEvent e) {
        /* nothing */
    }

    public void keyTyped(KeyEvent e) {
        /* nothing */
    }
}

class Vec2 {
    public double x;
    public double y;

    public Vec2() {
        this(0, 0);
    }

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2 add(Vec2 other) {
        return new Vec2(this.x + other.x, this.y + other.y);
    }

    public Vec2 mul(double scalar) {
        return new Vec2(this.x * scalar, this.y * scalar);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Player extends Entity {
    public static final double jumpStrength = 250; // pixels
    public static final double jumpInterval = 0.5; // seconds

    private double lastJumped = 0;

    public Player(Simulation simulation) {
        super(simulation);

        this.position = new Vec2(30, 200);
        this.acceleration = new Vec2(0, 450);
        this.size = new Vec2(25, 25);
        this.color = new Color(206, 207, 79);
    }

    @Override
    public void update(double dt) {
        physicsUpdate(dt);

        for (Entity ent : stage.entities) {
            if (ent instanceof Pipe && collideWith(ent)) {
                stage.reset();
                return;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (stage.timeElapsed >= lastJumped + jumpInterval) {
            velocity = new Vec2(0, -jumpStrength);
            lastJumped = stage.timeElapsed;
        }
    }
}

class Pipe extends Entity {
    public static final double speed = 150;
    public static final Vec2 gapSize = new Vec2(40, 120);
    public static final double generateInterval = 0.5;

    public static void randomPipe(Simulation stage) {
        double gapY = Math.random() * (stage.size.y - gapSize.y);
        double pipeX = stage.size.x;

        Pipe upper = new Pipe(
                stage,
                new Vec2(pipeX, 0),
                new Vec2(gapSize.x, gapY)
        );
        Pipe lower = new Pipe(
                stage,
                new Vec2(pipeX, gapY + gapSize.y),
                new Vec2(gapSize.x, stage.size.y - gapSize.y - gapY)
        );

        stage.entities.add(upper);
        stage.entities.add(lower);
    }

    public Pipe(Simulation simulation, Vec2 position, Vec2 size) {
        super(simulation);

        this.position = position;
        this.size = size;
        this.velocity = new Vec2(-speed, 0);
        this.color = new Color(57, 168, 37);
    }

    @Override
    public void update(double dt) {
        physicsUpdate(dt);
    }

}