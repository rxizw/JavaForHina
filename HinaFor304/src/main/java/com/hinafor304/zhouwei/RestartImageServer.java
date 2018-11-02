package com.hinafor304.zhouwei;
import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

/**
 * 用于实现医生客户端重启服务器Image服务功能
 */
public class RestartImageServer {
    public static void main(String args[]){
        try {
            TelnetClient tc = new TelnetClient();
            tc.connect("192.1.1.104");
            InputStream in = tc.getInputStream();//获取Telnet服务器的返回信息
            OutputStream os = tc.getOutputStream();//Telnet输出流，用于向Telnet发送指令
            System.out.println(reader(" ",in));
            //write("y",os);
            System.out.println(reader(":",in));
            write("administrator",os);
            System.out.println(reader(":",in));
            write("Hin@c0m",os);
            System.out.println(reader(">",in));
            write("Net Stop miPlatform_Image_Service",os);
            //System.out.println(reader("i c e",in));
            //System.out.println("1");
            //waitTime();
            //System.out.println("2");
            write("Net Start miPlatform_Image_Service",os);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String cmd,OutputStream os){
        cmd = cmd+"\r\n";
        try {
            os.write(cmd.getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static String reader(String cmdend,InputStream is){
        InputStreamReader isr = new InputStreamReader(is);
        char[] tempchar = new char[1024];
        int n =0;
        boolean flag = false;
        String str = "";
        try {
            while ((n = isr.read(tempchar)) != -1){
                for(int i = 0;i<n;i++){
                    char c = (char)tempchar[i];
                    str += c;
                    if(str.endsWith(cmdend)){
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void waitTime(){
        Calendar now = Calendar.getInstance();
        int data1 = now.get(Calendar.SECOND);
        int data2 = now.get(Calendar.SECOND);
        if((data2-data1)<1000000000){
            data2 = now.get(Calendar.SECOND);
        }
    }
}
