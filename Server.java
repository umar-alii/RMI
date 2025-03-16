import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.manager", "allow");
            Registry registry = LocateRegistry.createRegistry(1099);
            
            MessageService messageService = new MessageServiceImpl();
            
            registry.rebind("MessageService", messageService);
            
            System.out.println("Server is running on port 1099...");
            System.out.println("Press Ctrl+C to exit");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}