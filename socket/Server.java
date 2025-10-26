
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Receive data from client
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String received = input.readLine();
            System.out.println("Received from client: " + received);

            input.close();
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
