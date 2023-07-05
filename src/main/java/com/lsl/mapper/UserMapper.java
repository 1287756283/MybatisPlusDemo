package com.lsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsl.Aop.annotation.Aliez;
import com.lsl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 连石磊
 * @since 2021-07-09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    String selectTest( Integer id);

    @Aliez
    int updateUser(User user);
}
