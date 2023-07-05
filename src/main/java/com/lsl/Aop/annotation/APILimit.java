package com.lsl.Aop.annotation;



import com.lsl.enums.StrategyEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author LSL
 * @date 2022/5/13 11:19
 * @Description 接口限流
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface APILimit {


    /**
     * 要获取的令牌数
     */
    int permits() default 1;

    /**
     * 等待时间，在没有令牌可获取的情况下
     */
    int waitingTime() default 0;

    /**
     * 时间单位
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 限流策略
     */
    StrategyEnum limitStrategy() default StrategyEnum.LIMIT_1000;

}
