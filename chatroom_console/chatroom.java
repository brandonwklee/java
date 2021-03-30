package chatroom_console;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class chatroom {
    private String ip;
    private int port;
    private String userName;

    public chatroom() {
        System.out.println("Enter <ip address> and <port number>");
        Scanner scanner = new Scanner(System.in);
        ip = scanner.nextLine();
        port = scanner.nextInt();
        try {
            Socket socket = new Socket(ip, port);
            System.out.println("Server found!");
            readThread read = new readThread(socket, this);
            writeThread write = new writeThread(socket, this);
            read.start();
            write.start(); }
        catch (UnknownHostException e) {
            e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    void setName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) {
        chatroom client = new chatroom();
    }
}
