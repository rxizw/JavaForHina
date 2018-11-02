import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RemoteDoIt {
    public static void main(String args[]){
        try {
            //服务端打开端口10086
            ServerSocket ss = new ServerSocket(10086);

            //在端口10086上进行监听，看是否有链接
            System.out.println("在监听10086端口");
            Socket s = ss.accept();
            System.out.println(s+"连过来了！");

            //打开输入流
            InputStream is = s.getInputStream();
            //把输入流封装在DataInputstram中
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            while (true){
                String msg = dis.readUTF();
                System.out.println("客户端发来的信息是："+msg);
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                dos.writeUTF(str);
            }
            //读取客户端发送的数据
//            String msg = dis.readUTF();
//            System.out.println(msg);
//            s.close();
//            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
