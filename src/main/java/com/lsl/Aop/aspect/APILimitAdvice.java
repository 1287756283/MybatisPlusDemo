package com.lsl.Aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class APILimitAdvice{


   /* @Autowired
    private Redisson redisson;
    @Around(value = "@annotation(apiLimit)")
    public void around(ProceedingJoinPoint pjp, APILimit apiLimit) throws Throwable {




        int permits = apiLimit.permits();
        //获取方法名
        String name = pjp.getSignature().getName();

        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + "192.168.126.128:" + "6379");
        config.useSingleServer().setDatabase(1);
        RedissonClient redissonClient = Redisson.create(config);
        redissonClient.getSemaphore("zsd").delete();

        RSemaphore zsd = redissonClient.getSemaphore("zsd");
        System.out.println(zsd.trySetPermits(permits));

    }*/

}
