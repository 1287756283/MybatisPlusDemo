package com.lsl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsl.Aop.annotation.Aliez;
import com.lsl.entity.User;
import com.lsl.mapper.UserMapper;
import com.lsl.service.IUserService;
import com.lsl.utils.FzYjhfZbExportConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 连石磊
 * @since 2021-07-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    FzYjhfZbExportConsumer service;
    @Override
    public List<User> findList(User req) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //查询条件判断！
        wrapper.eq(!StringUtils.isEmpty(req.getName()), User::getName, req.getName());

        return list(wrapper);
    }

    @Override
    public boolean removeProcessContent(int id) {
        baseMapper.deleteById(id);
        return false;
    }

    @Override
    public void testThread() {
        service.signJob();
    }

    @Override
    @Aliez
    public String Byone() {
        return this.baseMapper.selectTest(1);
    }

    @Override
    public int updateUser(User user) {
        return this.baseMapper.updateUser(user);
    }

}
