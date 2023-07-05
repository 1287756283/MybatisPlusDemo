package com.lsl.Test;

import cn.hutool.core.collection.CollUtil;
import com.lsl.entity.User;
import com.lsl.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: lsl
 * @description:
 * @date: 2022/8/16 17:38
 */
@Slf4j
@SpringBootTest
public class TransactionalTest {

    @Autowired
    IUserService userService;

    @Test
    public void testTransactional() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("a1");
        user.setEmail(Collections.singletonList("a1@qq.com").toString());
        user.setAge(1);
        User user2 = new User();
        user2.setId(2);
        user2.setName("a2");
        user2.setEmail(Collections.singletonList("a2@qq.com").toString());
        user2.setAge(2);
        User user3 = new User();
        user3.setId(3);
        user3.setName("a3");
        user3.setEmail(Collections.singletonList("a3@qq.com").toString());
        user3.setAge(3);
        users.add(user);
        ArrayList<User> userArrayList = CollUtil.newArrayList(user, user2, user3);
        userArrayList.parallelStream().forEach(user1->{
            try {
                save(user1);
            }catch (Exception e){
                log.error("插入操作被撤回->{}"+user1);
            }
        });
    }


    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        if (user.getName().equals("a2")) {
            int a = 1 / 0;
        }
        userService.save(user);
    }
}
