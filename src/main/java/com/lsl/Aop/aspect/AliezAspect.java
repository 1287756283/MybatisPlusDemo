package com.lsl.Aop.aspect;

import com.lsl.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: lsl
 * @description: Aop测试
 * @date: 2022/7/26 14:51
 */

@Slf4j
@Aspect
@Component
public class AliezAspect {
    static String name = User.class.getName();

    @Pointcut("@annotation(com.lsl.Aop.annotation.Aliez)")
    public void fkjgPointCut() {

    }

    @AfterReturning(pointcut = "fkjgPointCut() && args(user)", returning = "retVal", argNames = "joinPoint, user, retVal")
    public void userSetData(JoinPoint joinPoint, Object user, int retVal) {
        log.info("测试aop");
        System.out.println(retVal);
        System.out.println("user = " + user);
    }
}
