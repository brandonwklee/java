package chatroom_console;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class server {
    private int port;
    private clientHandler userClient;
    private Set<String> allUsers = new HashSet<>();
    private Set<clientHandler> allClientHandlers = new HashSet<>();
    static ServerSocket serverSocket;

    public server(int port) {
        this.port = port;
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Searching for connections...");
            while (true) {
                Socket socket = serverSocket.accept();
                clientHandler userClient = new clientHandler(socket, this);
                allClientHandlers.add(userClient);
                userClient.start();
            }
        } catch (IOException e) {
            System.out.println("Unable to connect to client - " + e);
        }
    }

    public void broadCast(String message) {
        System.out.println("Sending message to all users: " + message);
        for (clientHandler clientNo : allClientHandlers) {
            clientNo.sendMessage(message);
        }
    }

    public void addName(String name) {
        allUsers.add(name);
    }

    public void remove(clientHandler userClient, String clientName) {
        allClientHandlers.remove(userClient);
        allUsers.remove(clientName);
    }

    public static void main(String[] args) {
        server server = new server(8888);
        server.run();
    }
}