package com.zhouwei09;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;

//解析HTML，并改变HTML时间
public class bianshijian {
    public static void main(String args[]){
        String html = readToString("E:\\zwlearn\\changetime09\\temp.html");
        Document document = Jsoup.parse(html);
        Element checkTime = document.getElementById("checkTime");
        System.out.println(checkTime);
        checkTime.html("<span id=\\\"checkTime\\\" data-field=\\\"OrderForOrderDto_StudyDate\\\">2018-08-08 14:51:56</span>");
        Element reportTime = document.getElementById("reportTime");
        System.out.println(reportTime);
        String checkTime1 = document.getElementById("checkTime").text();
        System.out.println(checkTime1);
        String reportTime1 = document.getElementById("reportTime").text();
        System.out.println(reportTime1);
        System.out.println(document.html());
        File temp12 = new File("temp13.html");
        try {
            FileOutputStream fo = new FileOutputStream(temp12,false);
            OutputStreamWriter ow =new OutputStreamWriter(fo,"UTF-8");
            ow.write(document.html());
            ow.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Element checkDiv = document.select("checkTime").first();
//        System.out.println(checkDiv);
        //checkDiv.html("<span id=\"checkTime\" data-field=\"OrderForOrderDto_StudyDate\">2018-08-08 14:51:56</span>");
    }
//读取HTML内容为String
    public static String readToString(String fileName){
        File OriginalHtml = new File(fileName);
        long fileLength = OriginalHtml.length();
        int i = Integer.parseInt(String.valueOf(fileLength));
        byte filecount[] = new byte[i];
        try {
            FileInputStream fin = new FileInputStream(OriginalHtml);
            fin.read(filecount);
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecount,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

//依据ID修改HTML 报告时间 审核时间 并保存为新的HTML
    public static void bian(String elementID,String time){

    }
}
