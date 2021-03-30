package breakoutGame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gamePlay extends JFrame implements ActionListener, KeyListener {

    Timer gameInterval = new Timer(5, this);
    repaint paint = new repaint();
    static ball ball = new ball(100,600,20, 500, 800);
    static paddle paddle = new paddle(250,600,80,20);

    public gamePlay() {
        gameInterval.start();
        add(paint);
        addKeyListener(this);
        setTitle("Breakout");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,800);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        ball.checkPaddleCollision();
        repaint();

    }

    static void repaint(Graphics g) {
        ball.paintComponents(g);
        paddle.paintComponents(g);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
            paddle.moveLeft();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
            paddle.moveRight();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight();        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
            paddle.moveLeft();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
            paddle.moveRight();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
            paddle.moveLeft();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
            paddle.moveRight();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight();
        }
    }
}