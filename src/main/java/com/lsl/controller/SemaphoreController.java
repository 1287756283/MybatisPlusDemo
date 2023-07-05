package com.lsl.controller;

import cn.hutool.log.Log;
import io.lettuce.core.RedisClient;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Semaphore;

@Slf4j
@RestController
@RequestMapping("/redis")
public class SemaphoreController {
    @Autowired
    RedissonClient redissonClient;


    @PostMapping("/add")
    public String add() throws InterruptedException {
        redissonClient.getSemaphore("lsl");
        RSemaphore zsd = redissonClient.getSemaphore("lsl");
        System.out.println(zsd.trySetPermits(3));
        return "设置成功!";
    }

    @PostMapping("/park")
    public String park() throws InterruptedException {
        //获得信号量
        RSemaphore park = redissonClient.getSemaphore("park");
        //park.trySetPermits(5);
        log.error("占用车位前可用许可证的数量:{}", park.availablePermits());
        //占用车位
        if (park.tryAcquire()) {
            log.error("可用许可证的数量:{}", park.availablePermits());
            log.error("获取并返回所有立即可用的许可证:{}", park.drainPermits());
            return "获得一个车位...";
        }
        log.error("可用许可证的数量:{}", park.availablePermits());
        log.error("获取并返回所有立即可用的许可证:{}", park.drainPermits());
        return "暂时没车位了";
    }

    @PostMapping("/leave")
    public String leave() {
        RSemaphore park = redissonClient.getSemaphore("park");
        park.release();//释放一个车位
        log.error("可用许可证的数量:{}", park.availablePermits());
        log.error("获取并返回所有立即可用的许可证:{}", park.drainPermits());
        return "释放一个车位...";
    }


}
