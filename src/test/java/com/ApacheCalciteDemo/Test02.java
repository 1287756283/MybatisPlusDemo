//package com.ApacheCalciteDemo;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// *
// */
//public class Test02 {
//
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//        Class.forName("com.esproc.jdbc.InternalDriver");
//
//        Connection connection = DriverManager.getConnection("jdbc:esproc:local://");
//
////调用esProc程序(存储过程)，其中test是dfx的文件名
//
//        com.esproc.jdbc.InternalCStatementst;
//
//        st =(com.esproc.jdbc.InternalCStatement)con.prepareCall("calltest()");
//
////执行esProc存储过程
//
//        st.execute();
//
////获取结果集
//
//        ResultSet set = st.getResultSet();
//    }
//}
