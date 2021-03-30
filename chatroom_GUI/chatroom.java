package chatroom_GUI;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.Socket;

public class chatroom extends JPanel {

    private String name;
    private JPanel chatPanel, messagePanel, parentPanel, textPanel;
    private JTextField  userMessage;
    private JTextArea chatMessages;
    private JScrollPane scrollPane;
    private JButton exit;
    private Socket socket;
    private GridLayout gridLayout;
    private Font font;
    private int fontSize = 20;


    public chatroom() throws IOException {
        font  = new Font("Railway Extra Bold", Font.PLAIN, fontSize);

        userMessage = new JTextField("", 30);
        chatMessages = new JTextArea();

        chatMessages.setEditable(false);
        chatMessages.setPreferredSize(new Dimension(200,300));

        exit = new JButton("Exit");

        chatPanel = new JPanel();
        messagePanel = new JPanel();
        parentPanel = new JPanel();
        textPanel = new JPanel();

        chatMessages.setPreferredSize(new Dimension(350,350));
        chatPanel.setPreferredSize(new Dimension(400,350));
        textPanel.setPreferredSize(new Dimension(300,350));
        parentPanel.setPreferredSize(new Dimension(400,500));
        messagePanel.setPreferredSize(new Dimension(400,100));

        gridLayout = new GridLayout(1,2);

        chatPanel.setLayout(gridLayout);

        chatPanel.add(textPanel);
        textPanel.add(chatMessages);
        messagePanel.add(userMessage);
        messagePanel.setBackground(Color.blue);

        parentPanel.add(chatPanel, BorderLayout.WEST);
        parentPanel.add(messagePanel, BorderLayout.SOUTH);

        add(parentPanel);
        setSize(400, 500);

        socket = new Socket("127.0.0.1", 8888);
        //name = clientGUI.name;
        System.out.println("Server found!");
        //System.out.println(name);

        readThread read = new readThread(socket, this);
        writeThread write = new writeThread(socket, this);
        read.run();
        write.run();

    }

    public void setName(String name) {
        this.name = name;
    }
}