import java.io.IOException;
import java.net.Socket;

public class Client2 {
    public static void main(String args[]){
        try {
            Socket s =new Socket("127.0.0.1",10086);
            //启动收信息进程
            new SendThread(s).start();
            new ReceiveThread(s).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
