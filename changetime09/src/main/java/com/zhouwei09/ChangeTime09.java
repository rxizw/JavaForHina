package com.zhouwei09;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.net.MalformedURLException;
import java.sql.*;

public class ChangeTime09 {
    public static void main(String args[]){
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://192.168.1.2:1433;DatabaseName=miPlatform_Domain;";
//            try {
//                Connection conn = DriverManager.getConnection(url,"sa","Hin@c0m");
//                Statement stme = conn.createStatement();
//                String sql = " select Content from [miPlatform_Domain].[dbo].[Report] where OrderId in (select  id FROM [miPlatform_Domain].[dbo].[OrderQuery] where AccessionNumber = 'CR1871300001' )" ;
//                ResultSet rs = stme.executeQuery(sql);
//                //System.out.println(rs.getString("Content"));
//                while (rs.next()){
//                    String count = rs.getString("Content");
//                    System.out.println(count);
//                    File fileTemp = new File("temp.html");
//                    if(fileTemp.exists()){
//                        fileTemp.delete();
//                    }
//                    else {
//                        try {
//                            fileTemp.createNewFile();
//                            PrintWriter pw = new PrintWriter(fileTemp);
//                            pw.print(count);
//                            pw.flush();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                    //System.out.println(rs.getString("Content"));
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        //Html转换为PDF输出到页面
        //ITextRenderer renderer = new ITextRenderer();
        convertHtmltoPdf("E:\\zwlearn\\changetime09\\temp.html","E:\\zwlearn\\changetime09\\temp.pdf");
    }
    public static boolean convertHtmltoPdf(String fileIn,String fileOut){
        try {
            OutputStream os = new FileOutputStream(fileOut);
            ITextRenderer renderer = new ITextRenderer();
            ITextFontResolver fontResolver = renderer.getFontResolver();
            //假设HTML采用的是宋体
            try {
                fontResolver.addFont("E:\\zwlearn\\changetime09\\lib\\simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //ITextRenderer renderer = new ITextRenderer();
            //String
            try {
                String url = new File(fileIn).toURI().toURL().toString();
                renderer.setDocument(url);
                renderer.layout();
                try {
                    try {
                        renderer.createPDF(os);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                os.flush();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
