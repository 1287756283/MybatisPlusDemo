//package com.lsl.model;
//
//import com.sun.rowset.JdbcRowSetImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.sql.RowSet;
//import java.sql.SQLException;
//
///**
// *
// */
//
//@Slf4j
//@SpringBootTest
//public class ModelTest {
//
//    @Test
////    public void rowSetTest() throws SQLException {
//        rs.setUrl("jdbc:mysql://192.168.126.128:3306/MybatisPlusdemo?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC");
//        rs.setUsername("root");
//        rs.setPassword("root");
//        rs.setCommand("select * from feeplan limit 1");
//        rs.execute();
//        show(rs);
//    }
//
//
//    public static void show(RowSet rs) {
//        try {
//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(1));
//
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//}
//
