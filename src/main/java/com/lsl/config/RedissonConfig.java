package com.lsl.config;


import io.netty.channel.nio.NioEventLoopGroup;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
@Configuration
public class RedissonConfig {
    /*{
        @Value("${spring.redis.host}")
        private String host;

        @Value("${spring.redis.port}")
        private int port;

        @Value("${spring.redis.database}")
        private int database;

        @Value("${spring.redis.password}")
        private String password;


        @Bean
        public Redisson redisson() {
        Config config = new Config();
        {
            config.useClusterServers()
                    .setScanInterval(2000) // 集群状态扫描间隔时间，单位是毫秒
                    //可以用"rediss://"来启用SSL连接
                    .addNodeAddress("redis://127.0.0.1:7000", "redis://127.0.0.1:7001")
                    .addNodeAddress("redis://127.0.0.1:7002");
        }
        config.useSingleServer().setAddress("redis://" + "192.168.126.128:" + "6379");
        config.useSingleServer().setDatabase(1);
        config.setLockWatchdogTimeout(20*1000);
        if(StringUtils.isNotEmpty(password)) {
            config.useSingleServer().setPassword(password);
        }
        return (Redisson) Redisson.create(config);
    }
    }*/



    private String address = "redis://192.168.126.128:6379";
    private int database = 4;



    @Bean
    RedissonClient redisson() throws Exception {
        Config config = new Config();
        config.useSingleServer().setAddress(address)
                .setDatabase(database);
        return Redisson.create(config);
    }

}
