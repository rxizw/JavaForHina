import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]){
        while (true){
        try {
                ServerSocket ss = new ServerSocket(10086);
                System.out.println("在监听10086端口");
                Socket s = ss.accept();

                //启动发送消息进程
                new SendThread(s).start();
                //启动收消息进程
                new ReceiveThread(s).start();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    }
