package com.lsl.utils;


import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * @author ljh
 * @date 2022/2/8 10:15
 */
@Slf4j
@Component
public class FzYjhfZbExportConsumer implements Runnable {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private FzYjhfZbExportConsumer consumer;
    private Integer threadCount;


    @PostConstruct
    void init() {
        threadPoolTaskExecutor.setCorePoolSize(3);
        if (threadCount == null) {
            threadCount = 3;
        }
        for (int i = 0; i < threadCount; i++) {
            threadPoolTaskExecutor.execute(consumer);
        }
    }

    public synchronized void signJob() {
        System.out.println(1111);
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
    /*    Config config = new Config();
        config.useSingleServer().setAddress("redis://" + "192.168.126.128:" + "6379");
        config.useSingleServer().setDatabase(2);
        RedissonClient redissonClient = Redisson.create(config);
        RSemaphore park = redissonClient.getSemaphore("park");
        park.release();//释放一个车位*/
        int a=10;
        do {
            if (a==0) {
                continue;
            }
            try {
                a=a--;
            } catch (Exception ex) {
                System.out.println("失败");
            }finally {
               // park.release();
            }
        } while (true);
    }
}
