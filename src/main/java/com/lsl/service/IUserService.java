package com.lsl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lsl.Aop.annotation.Aliez;
import com.lsl.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 连石磊
 * @since 2021-07-09
 */
public interface IUserService extends IService<User>{
    List<User> findList(User req);

    boolean removeProcessContent(int id);

    void testThread();

    String Byone();


    int updateUser(User user);
}
