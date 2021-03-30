package chatroom_GUI;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class writeThread extends Thread {
    private Socket socket;
    private chatroom chatroom;
    private OutputStream sendToServer;
    private PrintWriter write;
    private String message;
    private Scanner scanner;

    public writeThread(Socket socket, chatroom chatroom) {
        this.socket = socket;
        this.chatroom = chatroom;
        try {
            sendToServer = socket.getOutputStream();
            write = new PrintWriter(sendToServer, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.next();
        chatroom.setName(name);
        write.println(name);
        do {
            message = scanner.nextLine();
            if (!message.equals("")) {
                write.println(message);
            }
            else {
                System.out.println("Say something.... Type QUIT to leave the room");
            }
        }
        while (!message.equals("QUIT"));
        System.out.println("Bye!");
        return;
    }
}
