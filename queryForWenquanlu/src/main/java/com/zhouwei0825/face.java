package com.zhouwei0825;

import javax.swing.*;

import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;
import org.jdesktop.swingx.JXDatePicker;

import java.awt.*;
import java.util.Date;

public class face {
    public static void main(String args[]){
        //整个外部的框架
        JFrame f = new JFrame("查询");
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
        JLabel lStop = new JLabel("结束日期：");
        lStop.setBounds(37,60,80,30);
        f.add(lStop);

        //显示列表
//        String[] columnNames = new String[]{"序号","姓名","数量"};
//        String[][] heros = new String[][]{{"1","周伟","3"},{"2","冉旭","6"}};
//        JTable t = new JTable(heros,columnNames);
//        JScrollPane sp = new JScrollPane(t);
//        t.getColumnModel().getColumn(0).setPreferredWidth(10);
//        f.add(t,BorderLayout.CENTER);
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
