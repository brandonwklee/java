package breakoutGame;
import java.awt.*;

public class paddle extends objects {
    int units = 15;

    public paddle(int yPos, int xPos, int width, int height) {
        super(yPos, xPos, width, height);
    }

    @Override
    public void paintComponents(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(yCoords, xCoords, width, height);
    }

    public void moveLeft() {
        if (yCoords < 5) {
            yCoords = 5;
        }
        yCoords -= units;
    }

    public void moveRight() {
        if (yCoords > 400) {
            yCoords = 400;
        }
        yCoords += units;
    }
}