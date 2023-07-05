package com.lsl.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;

import java.sql.*;

/**
 *
 */
public class MySqlUtils {

    public boolean isExistOfTableName(String tableName) throws SQLException, ClassNotFoundException {
        boolean isExist = false;
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306/cboard_test?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC","cboard_test","test@cboard");
        //3.编写sql
        String sql = StrUtil.format("select 1 from information_schema.TABLES where TABLE_NAME = {}", tableName);
        //4.执行sql
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println();
        return true;
    }
}
