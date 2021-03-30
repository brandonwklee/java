package breakoutGame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static breakoutGame.gameMenu.parentPanel;
import static breakoutGame.gameMenu.switchScreens;

public class scoreboardMenu extends JPanel {
    private JButton exitButton = new JButton("Back");

    public scoreboardMenu() {
        setBounds(0, 0, 500, 800);
        exitButton.addActionListener(new ButtonHandler(this));
        add(exitButton);
    }

    class ButtonHandler implements ActionListener {
        scoreboardMenu theGame;

        public ButtonHandler(scoreboardMenu thisGame) {
            theGame = thisGame;
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitButton) {
                switchScreens.show(parentPanel, "menu");
            }
        }
    }
}
