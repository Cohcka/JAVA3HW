package home_work_3.AppTransferFile;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class AppObjectTransfer_Server {
    public static void main(String[] args){
        Socket serverSocket;
        Cat cat1 = new Cat("Barsik", 12);
        try (ServerSocket server = new ServerSocket(8189)) {
            serverSocket = server.accept();
            ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
            out.writeObject(cat1);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}