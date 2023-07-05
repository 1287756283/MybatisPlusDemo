package com.lsl.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 连石磊
 * @since 2021-07-09
 */
@RestController
@Slf4j
@RequestMapping("/thread")
public class ThreadTest {

    @GetMapping("/get")
    public String a1() throws InterruptedException {
        Thread.sleep(5000);
        return "test";
    }


    @GetMapping("/test")
    public String test() {
        RestTemplate restTemplate = new RestTemplate();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {
            List<String> list = new CopyOnWriteArrayList<>();
            IntStream.range(0, 100).forEach(value -> {
                executorService.execute(() -> {
                    String body = restTemplate.getForEntity("http://localhost:8089/thread/get", String.class).getBody();
                    list.add(body);
                });
            });
            addMySql(list);
        });
        return "test";
    }




    public boolean addMySql( List<String> list) {
        LongAdder insertCounter = new LongAdder();
        System.out.println(Arrays.asList(list));
        return true;
    }



}
