package breakoutGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameMenu extends JFrame {
    private JPanel menuPanel = new JPanel();
    private static JButton playButton = new JButton("Play");
    private static JButton scoreBoardButton = new JButton("Scoreboard");
    private static JButton exitButton = new JButton("Exit");
    public static final CardLayout switchScreens = new CardLayout();
    public static final JPanel parentPanel = new JPanel();

    public gameMenu() {
        playButton.addActionListener(new ButtonHandler(this));
        scoreBoardButton.addActionListener(new ButtonHandler(this));
        exitButton.addActionListener(new ButtonHandler(this));

        menuPanel.add(playButton);
        menuPanel.add(scoreBoardButton);
        menuPanel.add(exitButton);

        scoreboardMenu scoreBoard = new scoreboardMenu();
        parentPanel.setLayout(switchScreens);
        switchScreens.show(parentPanel, "parent");
        parentPanel.add(menuPanel, "menu");
        parentPanel.add(scoreBoard, "scoreboard");

        add(parentPanel);
        setTitle("Breakout");
        setSize(500, 800);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    class ButtonHandler implements ActionListener {
        gameMenu theGame;

        public ButtonHandler(gameMenu thisGame) {

            theGame = thisGame;
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playButton) {
                gamePlay game = new gamePlay();
                game.setVisible(true);
                setVisible(false);
            }
            if (e.getSource() == scoreBoardButton) {
                switchScreens.show(parentPanel, "scoreboard");
            }
            if (e.getSource() == exitButton) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new gameMenu();
    }
}