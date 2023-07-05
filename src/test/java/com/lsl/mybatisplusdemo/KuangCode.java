//package com.lsl.mybatisplusdemo;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableFill;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.util.ArrayList;
//
////代码生成器
//public class KuangCode {
//    public static void main(String[] args) {
//        AutoGenerator mpg=new AutoGenerator();
//        //模块引擎
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//
//        //1.全局配置
//        GlobalConfig gc=new GlobalConfig();
//        String projectPath=System.getProperty("user.dir");
//        gc.setOutputDir(projectPath+"/src/main/java");
//        gc.setAuthor("连石磊");
//        gc.setOpen(false);           //是否打开文件夹
//        gc.setFileOverride(false);   //是否覆盖原代码
//        //gc.setServiceName("%Service");//去除Service的I前缀
//        gc.setIdType(IdType.ASSIGN_ID);
//        gc.setDateType(DateType.ONLY_DATE);
//        //gc.setSwagger2(true);
//        mpg.setGlobalConfig(gc);
//
//        //2.设置数据源
//        DataSourceConfig dsc=new DataSourceConfig();
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("root");
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setUrl("jdbc:mysql://192.168.126.128:3306/MybatisPlusdemo?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC");
//        mpg.setDataSource(dsc);
//
//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//        //3.配置包
//        PackageConfig pc = new PackageConfig();
//        //pc.setModuleName("demo"); com.lsl.demo
//        pc.setParent("com.lsl");
//        pc.setEntity("entity");
//        pc.setMapper("mapper");
//        pc.setService("service");
//        pc.setController("controller");
//        mpg.setPackageInfo(pc);
//
//        //4.策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setInclude("Student");//-------------------表名！！！
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
//        strategy.setEntityLombokModel(true); //自动lombok
//        strategy.setRestControllerStyle(true);
//        strategy.setLogicDeleteFieldName("deleted");//逻辑删除自动生成
//
//        //5.自动填充配置
//        TableFill createtime = new TableFill("createtime", FieldFill.INSERT);
//        TableFill updatetime = new TableFill("updatetime", FieldFill.INSERT_UPDATE);
//        ArrayList<TableFill> tablefills = new ArrayList<>();
//        tablefills.add(createtime);
//        tablefills.add(updatetime);
//        strategy.setTableFillList(tablefills);
//
//        //乐观锁的配置
//        strategy.setVersionFieldName("version");
//        strategy.setRestControllerStyle(true);//开启驼峰命名
//        strategy.setControllerMappingHyphenStyle(true); //localhost:8080/test_id_2
//        mpg.setStrategy(strategy);
//
//        mpg.execute();
//    }
//}
