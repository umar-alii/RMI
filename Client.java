import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.manager", "allow");
            
            String host = (args.length < 1) ? "localhost" : args[0];
            System.out.println("Connecting to server at: " + host);
            
            
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            
            MessageService messageService = (MessageService) registry.lookup("MessageService");
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a message to send to the server:");
            String message = scanner.nextLine();
            messageService.sendMessage(message);
            
            System.out.println("Message sent successfully");
            
            
            String echo = messageService.receiveMessage();
            System.out.println("Server has stored: " + echo);
            
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}