package chatroom_console;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class clientHandler extends Thread {
    private Socket socket;
    private server server;
    private PrintWriter sentToClient;
    private BufferedReader reader;
    private InputStream receivedFromClient;
    private String clientMessage;
    private SimpleDateFormat df;
    private Calendar cal;

    public clientHandler(Socket socket, server server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            System.out.println("Connection found!");

            receivedFromClient = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(receivedFromClient));

            OutputStream os = socket.getOutputStream();
            sentToClient = new PrintWriter(os, true);

            String userName = reader.readLine();
            System.out.println("New user connection from " + userName);
            cal = Calendar.getInstance();
            df = new SimpleDateFormat("HH:mm");
            String serverMessage = "--- " + userName + " has entered the chatroom ---";

            server.addName(userName);
            server.broadCast(serverMessage);

            do {
                clientMessage = reader.readLine();
                server.broadCast("[" + df.format(cal.getTime()) + "]" + userName + ": " + clientMessage);
            }
            while (!clientMessage.equals("QUIT"));

            String clientLeft = "--- " + userName + " has left the chat ---";
            server.broadCast(clientLeft);
            server.remove(this, userName);
            socket.close();

        } catch (Exception e) {
            System.out.println("Lost connection - " + e);
        }
    }

    public void sendMessage(String message) {
        sentToClient.println(message);
    }
}