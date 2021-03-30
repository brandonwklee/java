package breakoutGame;
import javax.swing.*;
import java.awt.*;

public abstract class objects extends JPanel {
    public static int xCoords, yCoords;
    public static int width, height, dX, dY;

    public objects (int yPos, int xPos, int width, int height) {
        this.yCoords = yPos;
        this.xCoords = xPos;
        this.width = width;
        this.height = height;
    }

    public abstract void paintComponents(Graphics g);

}
