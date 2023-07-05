package com.ApacheCalciteDemo;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.calcite.adapter.jdbc.JdbcSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaPlus;

import java.sql.*;
import java.util.Properties;

/**
 *
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        Class.forName("org.apache.calcite.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Properties info = new Properties();
        info.setProperty("lex", "JAVA");
        info.setProperty("remarks", "true");
        info.setProperty("parserFactory", "org.apache.calcite.sql.parser.impl.SqlParserImpl#FACTORY");

        Connection connection = DriverManager.getConnection("jdbc:calcite:", info);
        CalciteConnection calciteConnection = connection.unwrap(CalciteConnection.class);
        System.out.println(calciteConnection.getProperties());
        SchemaPlus rootSchema = calciteConnection.getRootSchema();

        MysqlDataSource dataSource1 = new MysqlDataSource();
        dataSource1.setUrl("jdbc:mysql://192.168.126.128:3306/MybatisPlusdemo?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC");
        dataSource1.setUser("root");
        dataSource1.setPassword("root");
        Schema schema1 = JdbcSchema.create(rootSchema, "MybatisPlusdemo", dataSource1, null, "MybatisPlusdemo");
        rootSchema.add("MybatisPlusdemo", schema1);
        Statement statement1 = calciteConnection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(
                "select * from MybatisPlusdemo.feeplan");
        while (resultSet1.next()) {
            String name1 = resultSet1.getString("number_of_periods");
            System.out.println(name1);
        }
        //========================================================================================
        MysqlDataSource dataSource2 = new MysqlDataSource();
        dataSource2.setUrl("jdbc:mysql://192.168.0.118:3306/cboard_test?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC");
        dataSource2.setUser("cboard_test");
        dataSource2.setPassword("test@cboard");
        Schema schema2 = JdbcSchema.create(rootSchema, "cboard_test", dataSource2, null, "cboard_test");
        rootSchema.add("cboard_test", schema2);

        // run sql query
        Statement statement2 = calciteConnection.createStatement();
        ResultSet resultSet2 = statement2.executeQuery(
                "select * from cboard_test.analog_data");
        while (resultSet2.next()) {
            String name = resultSet2.getString("sql_detail");
            System.out.println(name);
        }

        System.out.println("__________________");
        ResultSet resultSet3 = statement2.executeQuery(
                "select * from cboard_test.analog_data a left join MybatisPlusdemo.feeplan b on a.id=b.id");

        while (resultSet3.next()) {
            String name = resultSet3.getString(1);
            System.out.println(name);
        }
        statement1.close();
        statement2.close();
        connection.close();
    }

}
