package com.lsl.enums;


import org.redisson.Redisson;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;

public class LimitStrategyContent implements Comparable{

    /**
     * 限流配置key
     */
    private String apiLockKey;
    /**
     * 限流类  org.redisson.api.RRateLimiter
     */
    private RRateLimiter rateLimiter;
    /**
     * 总令牌数
     */
    private Integer rate;
    /**
     * 限流时间
     */
    private Integer rateInterval;
    /**
     * 时间单位
     */
    private RateIntervalUnit rateIntervalUnit;

    /**
     * 排序
     */
    private Integer sort;


    public RRateLimiter getRateLimiter(){
        return rateLimiter;
    }


    LimitStrategyContent(){

    }

    public LimitStrategyContent(String apiLockKey, Redisson redisson, Integer rate, Integer rateInterval, RateIntervalUnit rateIntervalUnit, Integer sort){
        this.apiLockKey = apiLockKey;
        this.rateLimiter = redisson.getRateLimiter(apiLockKey);
        this.rate = rate;
        this.rateInterval = rateInterval;
        this.rateIntervalUnit = rateIntervalUnit;
        this.sort = sort;
    }

    public boolean trySetRate(){
        return rateLimiter.trySetRate(RateType.OVERALL,rate,rateInterval,rateIntervalUnit);
    }


    @Override
    public int compareTo(Object o) {
        int oSort = (int) o;
        if (this.sort < oSort){
            return -1;
        }
        if (this.sort > oSort){
            return 1;
        }
        return 0;
    }
}

