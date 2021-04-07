package gp_surgery;

import javax.swing.*;

public class clientGUI extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JButton button;
    private JTextField textField;
    private JCheckBox checkBox;
    private JDialog dialog;
    private JTable table;

    public clientGUI() {
        setSize(1200, 700);
        setVisible(true);
        setResizable(false);
        setTitle("GP Surgery Records");
    }
}