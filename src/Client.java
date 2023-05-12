import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args)
    {
        try{
            Socket socket = new Socket("localhost",1234);
            //asking user Input with buffer
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));            
            //taking data from socket buffer
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String sendingMessage , receivingMessage;
            while(true)
            {
                receivingMessage = socketInput.readLine();
                System.out.println("Server:" + receivingMessage);
                sendingMessage = userInput.readLine();
                out.println(sendingMessage);
                out.flush();

            }

        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
