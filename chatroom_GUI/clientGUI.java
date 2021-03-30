package chatroom_GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clientGUI extends JFrame {
    private JPanel parentPanel, addressPanel, bottomPanel, middlePanel, topPanel;
    private JLabel nameLabel, IPLabel, PortLabel, label, message;
    private JTextField nameField, IPField, PortField;
    private JButton button;
    private CardLayout switchScreens;
    private GridLayout gridLayout;
    private chatroom chatroom;
    static String name;
    private Font font;
    private int fontSize = 20;

    public clientGUI() throws Exception {

        font = new Font("Railway Extra Bold", Font.PLAIN, fontSize);

        switchScreens = new CardLayout();

        nameLabel = new JLabel("Username: ");
        IPLabel = new JLabel("IP Address: ");
        PortLabel = new JLabel("Port Address: ");
        label = new JLabel("Enter IP address and Port Number");
        nameLabel.setFont(font);
        IPLabel.setFont(font);
        PortLabel.setFont(font);
        label.setFont(font);

        message = new JLabel();

        nameField = new JTextField(1);
        IPField = new JTextField(1);
        PortField = new JTextField(1);
        button = new JButton("Go!");

        button.setFont(font);

        IPField.addActionListener(new ButtonHandler(this));
        PortField.addActionListener(new ButtonHandler(this));
        button.addActionListener(new ButtonHandler(this));

        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();
        parentPanel = new JPanel();
        addressPanel = new JPanel();
        //chatroom = new chatroom();

        gridLayout = new GridLayout(4, 2);

        topPanel.add(label);
        middlePanel.add(message);
        bottomPanel.setLayout(gridLayout);
        bottomPanel.add(nameLabel);
        bottomPanel.add(nameField);
        bottomPanel.add(IPLabel);
        bottomPanel.add(IPField);
        bottomPanel.add(PortLabel);
        bottomPanel.add(PortField);
        bottomPanel.add(button);

        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));

        addressPanel.add(topPanel);
        addressPanel.add(middlePanel);
        addressPanel.add(bottomPanel);

        parentPanel.setLayout(switchScreens);
        parentPanel.add(addressPanel, "menu");
        //parentPanel.add(chatroom, "chatroom");
        switchScreens.show(parentPanel, "menu");

        add(parentPanel);
        setTitle("Chat Room");
        setVisible(true);
        setResizable(false);
        setSize(400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) throws Exception {
        new clientGUI();
    }


    class ButtonHandler implements ActionListener {
        clientGUI theapp;

        public ButtonHandler(clientGUI thisApp) {
            this.theapp = thisApp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                name = nameField.getText();
                String IPAddress = IPField.getText();
                String getPort = PortField.getText();
                if (IPAddress == "127.0.0.1" && getPort == "8888") {
                    switchScreens.show(parentPanel, "chatroom");
                }
            }
        }
    }
}