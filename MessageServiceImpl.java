import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {
    private String lastMessage = "";

    public MessageServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        System.out.println("Received message: " + message);
        lastMessage = message;
    }

    @Override
    public String receiveMessage() throws RemoteException {
        return lastMessage;
    }
}