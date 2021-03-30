package chatroom_GUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class readThread extends Thread {
    private Socket socket;
    private chatroom chatroom;
    private InputStream receiveFromServer;
    private BufferedReader reader;
    static String message;

    public readThread(Socket socket, chatroom chatroom) {
        this.socket = socket;
        this.chatroom = chatroom;
        try {
            receiveFromServer = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(receiveFromServer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                message = reader.readLine();
                System.out.println(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
