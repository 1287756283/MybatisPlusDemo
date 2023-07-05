package com.lsl.config;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author ljh
 * @date 2022/3/9 14:32
 */
@Slf4j
public class ThreadPoolTaskExecutorWithLog extends ThreadPoolTaskExecutor {
    @Override
    public void execute(@NonNull Runnable task) {
        logPrint(task.getClass().getSimpleName());
        super.execute(task);
    }

    @Override
    public void execute(@NonNull Runnable task, long startTimeout) {
        logPrint(task.getClass().getSimpleName());
        super.execute(task, startTimeout);
    }

    @Override
    public @NonNull Future<?> submit(@NonNull Runnable task) {
        logPrint(task.getClass().getSimpleName());
        return super.submit(task);
    }

    @Override
    public <T> @NonNull Future<T> submit(Callable<T> task) {
        logPrint(task.getClass().getSimpleName());
        return super.submit(task);
    }

    void logPrint(String taskName) {
        log.debug(
                "\n\tTask名称： {}" +
                "\n\t线程池活跃线程数：{}" +
                "\n\t线程池大小: {}," +
                "\n\t等待队列尺寸: {}",
                taskName,
                this.getThreadPoolExecutor().getActiveCount(),
                this.getThreadPoolExecutor().getMaximumPoolSize(),
                this.getThreadPoolExecutor().getQueue().size()
        );
    }
}
