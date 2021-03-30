package breakoutGame;
import java.awt.*;

public class ball extends objects {
    static int xBoundary, yBoundary, radius;
    static int speed = 2;
    static int x = 200, y = 300;

    public ball(int ball_xPos, int ball_yPos, int radius, int xBound, int yBound) {
        super(ball_xPos, ball_yPos, 100, 20);
        this.radius = radius;
        this.dX = 2;
        this.dY = 2;
        xBoundary = xBound;
        yBoundary = yBound;
    }

    public void move() {
        x += dX;
        y += dY;
        if (x + dX < 0) {
            dX = speed;
        } else if (x + dX > xBoundary - radius) {
            dX = -speed;
        } else if (y + dY < 0) {
            dY = speed;
        } else if (y + dY > yBoundary - radius) {
            dY = -speed;
        }
    }

    public void checkPaddleCollision() {
        if (x > paddle.xCoords ) {
        }
    }

    @Override
    public void paintComponents(Graphics g) {
        g.fillOval(x, y, radius, radius);
    }
}