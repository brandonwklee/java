package breakoutGame;
import javax.swing.*;
import java.awt.*;

public class repaint extends JPanel{

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gamePlay.repaint(g);
    }
}