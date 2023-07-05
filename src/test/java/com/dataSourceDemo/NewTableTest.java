package com.dataSourceDemo;

import com.lsl.utils.MySqlUtils;

import java.sql.*;

/**
 *
 */
public class NewTableTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        //1.加载驱动
//        Class.forName("com.mysql.jdbc.Driver");
//        //2.获取连接
//        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306/cboard_test?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC","cboard_test","test@cboard");
//        //3.编写sql
//        String sql="DROP TABLE IF EXISTS %s lsl";
//        //4.执行sql
//        Statement statement = connection.createStatement();
//        int i = statement.executeUpdate(sql);
//        System.out.println("execute = " + i);
//        //5.释放连接



        PreparedStatement ps = null;
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306/cboard_test?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC","cboard_test","test@cboard");
        ps = connection.prepareStatement(
                String.format("DROP TABLE IF EXISTS %s", "lsl"));
        boolean result = ps.execute();
    }
}
