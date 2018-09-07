package com.zhouwei0825;

import javax.swing.*;

import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;
import org.jdesktop.swingx.JXDatePicker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class face {
    public static void main(String args[]){
        //整个外部的框架
        final JFrame f = new JFrame("查询");
        f.setSize(800,600);
        f.setLocation(50,50);
        f.setLayout(null);
        //查询按钮
        JButton b = new JButton("查询");
        b.setBounds(400,60,100,30);
        f.add(b);
        //设置日历选时间
        Date date = new Date();
        final JXDatePicker datepick = new JXDatePicker();
        datepick.setBounds(150,20,177,30);
        f.add(datepick);
        final JXDatePicker datepick1 = new JXDatePicker();
        datepick1.setBounds(150,60,177,30);
        f.add(datepick1);

        //显示控件
        JLabel lStart = new JLabel("开始日期：");
        lStart.setBounds(37,20,80,30);
        f.add(lStart);

        //获取开始时间
        String timeStart = null;
        String timeEnd = null;
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date timeStart = datepick.getDate();
                Date timeEnd = datepick1.getDate();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeStart1 = formatter.format(timeStart);
                String timeEnd1 = formatter.format(timeEnd);
                File timeStartFile = new File("timeStart.txt");
                try {
                    PrintStream ps1 = new PrintStream(timeStartFile);
                    ps1.print(timeStart1);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                File timeEndFile = new File("timeEnd.txt");
                try {
                    PrintStream ps2 = new PrintStream(timeEndFile);
                    ps2.print(timeEnd1);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                System.out.println(datepick.getDate());
                System.out.println(datepick1.getDate());
            }
        });
//        b.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(datepick.getValue());
//            }
//        });

        JLabel lStop = new JLabel("结束日期：");
        lStop.setBounds(37,60,80,30);
        f.add(lStop);

        //显示列表
        String[] columnNames = new String[] { "id", "name", "hp", "damage" };
        String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },
                { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" } };
        JTable t = new JTable(heros, columnNames);
        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(37,100,500,400);
        f.add(sp, BorderLayout.CENTER);

        f.setVisible(true);

    }
}
