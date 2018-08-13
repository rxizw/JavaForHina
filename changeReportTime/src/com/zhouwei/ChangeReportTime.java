package com.zhouwei;

import java.io.*;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.concurrent.locks.StampedLock;
import org.xhtmlrenderer.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xhtmlrenderer.*;

public class ChangeReportTime {
    public static void main(String args[]){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://192.168.1.2:1433;DatabaseName=miPlatform_Domain;";
            try {
                Connection conn = DriverManager.getConnection(url,"sa","Hin@c0m");
                Statement stme = conn.createStatement();
                String sql = " select Content from [miPlatform_Domain].[dbo].[Report] where OrderId in (select  id FROM [miPlatform_Domain].[dbo].[OrderQuery] where AccessionNumber = 'CR1871300001' )" ;
                ResultSet rs = stme.executeQuery(sql);
                //System.out.println(rs.getString("Content"));
                while (rs.next()){
                    String count = rs.getString("Content");
                    System.out.println(count);
                    File fileTemp = new File("temp.html");
                    if(fileTemp.exists()){
                        fileTemp.delete();
                    }
                    else {
                        try {
                            fileTemp.createNewFile();
                            PrintWriter pw = new PrintWriter(fileTemp);
                            pw.print(count);
                            pw.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    //System.out.println(rs.getString("Content"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Html转换为PDF输出到页面

    }
    public static boolean convertHtmltoPdf(String fileIn,String fileOut){
        try {
            OutputStream os = new FileOutputStream(fileOut);
            //ITextRenderer renderer = new ITextRenderer();
            //String
            try {
                String url = new File(fileIn).toURI().toURL().toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}

