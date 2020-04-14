package home_work_3.AppTransferFile;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class AppObjectTransfer_Client {
    public static void main(String[] args) {
        Socket socket;
        Cat mycat;
        try {
            socket = new Socket("127.0.0.1", 8189);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            mycat = (Cat) in.readObject();
            in.close();
            mycat.info();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}