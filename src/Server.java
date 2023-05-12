import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serversocket = new ServerSocket(1234);
        Socket socket = serversocket.accept();
        System.out.println("Client Added");

        //asking the input from user
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        //taking the input from socket
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //To send a message i need a pen
        OutputStream outputstream = socket.getOutputStream();
        PrintWriter out = new PrintWriter(outputstream);

        String sendingMessage , receivingMessage;
        while(true)
        {
            sendingMessage= userInput.readLine();
            out.println(sendingMessage);
            out.flush();
            receivingMessage = socketInput.readLine();
            System.out.println("Message from client: " + receivingMessage);
        }
    }
}