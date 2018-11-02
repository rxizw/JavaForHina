import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args[]){
        try {
            //链接到本机的10086端口
            Socket s = new Socket("127.0.0.1",10086);
            //System.out.println(s);
            //打开输出流
            OutputStream os = s.getOutputStream();
            //把字符串封装在DataOutputStream中
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is =s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true){
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                String msg = dis.readUTF();
                System.out.println("收到了服务端的信息："+msg);
            }
            //Scanner sc = new Scanner(System.in);
            //String str = sc.next();
            //使用writeUTF发送字符串
            //dos.writeUTF(str);
//            //发送命令到服务器
//            os.write(100);
            //s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
