
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6000)) {
            System.out.println("Connected to server.");

            // Send data to server
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter a message for the server: ");
            String message = userInput.readLine();
            output.println(message);
            System.out.println("Message sent to server.");

            output.close();
            userInput.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
