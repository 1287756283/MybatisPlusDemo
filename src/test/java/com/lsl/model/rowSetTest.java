package com.lsl.model;


import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JoinRowSetImpl;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import java.sql.SQLException;

/**
 *
 */
public class rowSetTest {

    public static void CachedRowSetTest() throws SQLException {
        CachedRowSet crs1 = new CachedRowSetImpl();
        crs1.setUrl("jdbc:mysql://192.168.126.128:3306/MybatisPlusdemo?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC");
        crs1.setUsername("root");
        crs1.setPassword("root");
        crs1.setCommand("select * from feeplan limit 1");
        crs1.execute();
        CachedRowSet crs2 = new CachedRowSetImpl();
        crs2.setUrl("jdbc:mysql://192.168.0.118:3306/cboard_test?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC");
        crs2.setUsername("cboard_test");
        crs2.setPassword("test@cboard");
        crs2.setCommand("select * from analog_data limit 1");
        crs2.execute();
        JoinRowSet jrs = new JoinRowSetImpl();
        jrs.addRowSet(crs1, "id");
        jrs.addRowSet(crs2, "id");
        System.out.println("测试");
        while (jrs.next()) {
            //System.out.println(jrs.getInt("id") + "/t/t" + jrs.getString("name") + "/t/t" + jrs.getString("info"));
            System.out.println(jrs.getString(1));
            String[] rowSetNames = jrs.getRowSetNames();
            System.out.println(rowSetNames);
        }
    }


    public static void main(String[] args) throws SQLException {
        rowSetTest.CachedRowSetTest();
    }
}
