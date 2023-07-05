package com.lsl.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsl.Aop.annotation.APILimit;
import com.lsl.config.RedissonConfig;
import com.lsl.entity.User;
import com.lsl.mapper.UserMapper;
import com.lsl.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    RedissonConfig config;

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        System.out.println(userService.removeProcessContent(id));
        return "删除成功";
    }

    @GetMapping("/add")
    public boolean add() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(3);
        user.setName("aaa3");
        user.setEmail(Collections.singletonList("aaa3@qq.com").toString());
        user.setAge(3);
        users.add(user);
        return userService.saveOrUpdateBatch(users);
    }

    @GetMapping("/update")
    public boolean update() {
        User user = new User();
        user.setId(1);
        user.setName("连石磊11");
        user.setEmail("sss@qq.com");
        user.setAge(199);
        int i = userService.updateUser(user);
        return true;
    }


    @PostMapping("/list")
    public List<User> getProcessByPage(@RequestBody User processReq) {
        List<User> list = userService.findList(processReq);
        System.out.println(list);
        return list;
    }

    @PostMapping("/test")
    public String getTest() {
        String byone = userService.Byone();
        return byone;
    }

    @PostMapping("/test1")
    public void getTest1() {
 /*       Config config = new Config();
        config.useSingleServer().setAddress("redis://" + "192.168.126.128:" + "6379");
        config.useSingleServer().setDatabase(1);
        RedissonClient redissonClient = Redisson.create(config);
        redissonClient.getSemaphore("zsd").delete();

        RSemaphore zsd = redissonClient.getSemaphore("zsd");
        System.out.println(zsd.trySetPermits(3));*/

/*        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    zsd.acquire(1);
                    System.out.println("do something");
                    Thread.sleep(2000);
                    zsd.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "获取锁");

            }).start();
        }*/
    }



}
