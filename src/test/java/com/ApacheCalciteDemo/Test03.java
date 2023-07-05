package com.ApacheCalciteDemo;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.*;

/**
 *
 */
public class Test03 {
    public static void main(String[] args) throws JSQLParserException {
        // 使用工具类把SQL转换为Select对象
        Select select = (Select) CCJSqlParserUtil.parse("SELECT t.username tname,stu.id as sid from student stu inner join teacher t on t.id=stu.tid");
        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
        System.out.println(plainSelect.getFromItem());//获取表名
        System.out.println("plainSelect.getFirst() = " + plainSelect.getFirst());
        System.out.println("plainSelect.getFromItem() = " + plainSelect.getFromItem());
        System.out.println("plainSelect.getDistinct() = " + plainSelect.getDistinct());
        System.out.println("plainSelect.getFetch() = " + plainSelect.getFetch());
        System.out.println("plainSelect.getJoins() = " + plainSelect.getJoins());
    }


}
