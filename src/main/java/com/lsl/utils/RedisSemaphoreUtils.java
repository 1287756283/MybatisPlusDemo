package com.lsl.utils;

import cn.hutool.core.lang.Assert;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;

public class RedisSemaphoreUtils {

    @Resource
    private RedissonClient redissonClient;

    /**
     * 获取 字符串 的 RAtomicLong
     *
     * @param name 名称
     * @return 返回 值
     */
    public RSemaphore getSemaphore(String name) {
        RSemaphore semaphore = redissonClient.getSemaphore(name);
        Assert.notNull(semaphore, "semaphore is null");
        return semaphore;
    }

    /**
     * 获取 访问许可
     *
     * @param name 名称
     * @return 返回 访问许可
     */
    public boolean tryAcquire(String name) {
        return this.getSemaphore(name).tryAcquire();
    }

    /**
     * 获取 访问许可
     *
     * @param name    名称
     * @param permits 数量
     * @return 返回 访问许可
     */
    public boolean tryAcquire(String name, int permits) {
        return this.getSemaphore(name).tryAcquire(permits);
    }

    /**
     * 获取 访问许可
     *
     * @param name 名称
     * @throws InterruptedException interruptedException
     */
    public void acquire(String name) throws InterruptedException {
        this.getSemaphore(name).acquire();
    }

    /**
     * 获取 访问许可
     *
     * @param name    名称
     * @param permits 数量
     * @return 返回 访问许可
     * @throws InterruptedException interruptedException
     */
    public void acquire(String name, int permits) throws InterruptedException {
        this.getSemaphore(name).acquire(permits);
    }

    /**
     * await
     *
     * @param name 名称
     */
    public void release(String name) {
        this.getSemaphore(name).release();
    }

    /**
     * release
     *
     * @param name 名称
     * @param permits 数量
     */
    public void release(String name, int permits) {
        this.getSemaphore(name).release(permits);
    }

}
