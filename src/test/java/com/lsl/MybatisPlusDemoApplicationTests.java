package com.lsl;

import cn.hutool.core.util.StrUtil;
import com.lsl.entity.SysDept;
import com.lsl.entity.SystemDictData;
import com.lsl.entity.User;
import com.lsl.mapper.SystemDictDataMapper;
import com.lsl.mapper.SystemDictTypeMapper;
import com.lsl.service.IUserService;
import com.lsl.service.SysDeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    IUserService userService;
    @Autowired
    SystemDictDataMapper systemDictDataMapper;
    @Autowired
    SystemDictTypeMapper systemDictTypeMapper;


    @Test
    public void add() {
        SystemDictData systemDictData = new SystemDictData();
        systemDictData.setDictType("11");
        systemDictDataMapper.insert(systemDictData);
    }

    @Test
    void test() {

        User user = new User();
        user.setEmail(Arrays.asList("1", "2", "3").toString());
        userService.save(user);
    }


    @Test
    void contextLoads() {
        /*user.setName("111");
        user.setEmail("111");
        user.setAge(111);
        int result =userMapper.insert(user);
        System.out.println(result);
        System.out.println(userService.getById(520));*/
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 6, 7, 8, 2, 2, 2, 2);
        long count = integers.stream().distinct().count();
        List list = integers.stream().limit(5).collect(Collectors.toList());
        if (integers.stream().anyMatch(s -> s > 10)) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }

    }

    @Test
    void RegexMatches() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        String str = "(\"1\"+\"2\"+\"3\")*(\"4\"+\"1\"+\"2\")";
        String str1 = "(\"1\"+\"2\"+\"3\")*(\"4\"+\"1\"+\"2\")";
        String pattern = "\\d+";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);

        while (m.find()) {
            String group = m.group();
            stringStringHashMap.computeIfAbsent(group, s -> {
                return s + s;
            });

        }

        for (Map.Entry<String, String> stringStringEntry : stringStringHashMap.entrySet()) {
            str = str.replaceAll(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        System.out.println(str);
    }

    @Test
    void test1111() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("a=" + i);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                System.out.println("b=" + j);
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Test
    void ll() {
        //System.out.println(Integer.valueOf(""));
        System.out.println(Integer.parseInt("1002"));
    }


    @Test

    public void testSQL() {
        //创建ExpressionParser解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        String v1 = "(";
        String s1 = "1";
        String v2 = "+";
        String s2 = "2";
        String v3 = ")";
        String s3 = "1+1";
        String s4 = "100*4%";

        //表达式放置
        Expression ex3 = parser.parseExpression(s3);
        //执行表达式，默认容器是spring本身的容器：ApplicationContext
        Object value1 = ex3.getValue();
        System.out.println(value1.toString());
        /**如果使用其他的容器，则用下面的方法*//*
            //创建一个虚拟的容器EvaluationContext
            StandardEvaluationContext ctx = new StandardEvaluationContext();
            //向容器内添加bean
            BeanA beanA = new BeanA();
            ctx.setVariable("bean_id", beanA);
            //setRootObject并非必须；一个EvaluationContext只能有一个RootObject，引用它的属性时，可以不加前缀
            ctx.setRootObject(XXX);
            //getValue有参数ctx，从新的容器中根据SpEL表达式获取所需的值
            Object value = exp.getValue(ctx);*/
    }


    @Test
    void test333() {
        String s = "0b294c4a4aeb4662beba354ab31aff42.jpg";
        String unqualify = StringUtils.unqualify(s, '.');
        System.out.println(unqualify);
    }

    @Test
    void test11() {
        String a = "(1441297223099674626+1441297435079798785)*1441292356507463681";

        //创建ExpressionParser解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String pattern = "\\d+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(a);

        while (m.find()) {
            String group = m.group();
            stringStringHashMap.computeIfAbsent(group, s -> {
                return s + a;
            });

        }
    }

}



