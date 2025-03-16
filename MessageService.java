import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageService extends Remote {
    void sendMessage(String message) throws RemoteException;
    String receiveMessage() throws RemoteException;
}