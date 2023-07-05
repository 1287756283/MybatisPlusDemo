//package com.lsl.mybatisplusdemo;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableFill;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//// 执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
//public class CodeGenerator {
//
//    private static String modelName = "MybatisPlusdemo";
//
//    // 生成的代码放到哪个工程中
//    private static String PROJECT_NAME = modelName;
//
//    // 数据库名称
//    private static String DATABASE_NAME = modelName;
//
//    // 子包名
//    private static String MODULE_NAME = "hundwe." + modelName + ".";
//
//    public static void main(String[] args) throws IOException {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://192.168.126.128:3306/" + DATABASE_NAME + "?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("hundwe");
//        dsc.setPassword("Hundwe_2021@)@!");
//        mpg.setDataSource(dsc);
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
////        String projectPath = System.getProperty("user.dir") + "/";
//        gc.setOutputDir("E:/idea_workspace/table/" + PROJECT_NAME + "/src/main/java");
//        gc.setIdType(IdType.ASSIGN_ID); // 分布式id
//        gc.setAuthor("tangyy");
//        gc.setFileOverride(true); //覆盖现有的
//        gc.setOpen(false); //是否生成后打开
//        gc.setDateType(DateType.ONLY_DATE);
//        gc.setSwagger2(true); //实体属性 Swagger2 注解
//        mpg.setGlobalConfig(gc);
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com"); //父包名
//        pc.setController(MODULE_NAME + "controller"); // com.hundwe.part3.controller
//        pc.setService(MODULE_NAME + "service");
//        pc.setServiceImpl(MODULE_NAME + "service.impl");
//        pc.setMapper(MODULE_NAME + "mapper");
//        pc.setXml(MODULE_NAME + "mapper.xml");
//        pc.setEntity("hundwe.api.entities");
//        mpg.setPackageInfo(pc);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setEntityLombokModel(true); //使用lombok
//        strategy.setEntitySerialVersionUID(true);// 实体类的实现接口Serializable
//        strategy.setRestControllerStyle(true); // @RestController
//        // 表的自动填充字段
//        List<TableFill> tableFills = new ArrayList<TableFill>() {{
//            add(new TableFill("create_time", FieldFill.INSERT));
//            add(new TableFill("create_persons", FieldFill.INSERT));
//            add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
//            add(new TableFill("modified_by", FieldFill.INSERT_UPDATE));
//        }};
//        strategy.setTableFillList(tableFills);
//        strategy.setLogicDeleteFieldName("deleted");
//
////        strategy.setInclude("parameter_yield");
//        strategy.setControllerMappingHyphenStyle(true);
//
//        mpg.setStrategy(strategy);
//
//        // 配置模板
//        TemplateConfig tc = new TemplateConfig();
//        tc.setEntity("templates/entity.my.java");
//        mpg.setTemplate(tc);
//
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//
//
//    /**
//     * <p>
//     * 读取控制台内容
//     * </p>
//     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotBlank(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//}
