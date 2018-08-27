package com.zhouwei0825;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class query {
public void mian(String args[]){
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    String url = "jdbc:sqlserver://192.168.1.2:1433;DatabaseName=miPlatform_Domain;";
    try {
        Connection conn = DriverManager.getConnection(url,"sa","Hin@c0m");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    //使用SQL语句实现数据统计功能；
    String sql = "  select s.FullName,COUNT(*)\n" +
            "  FROM [miPlatform_Domain].[dbo].[Staff] s ,[miPlatform_Domain].[dbo].[Order] o\n" +
            "  where s.UserId = o.ApplyDoctorId\n" +
            "  group by s.FullName";


}
}
