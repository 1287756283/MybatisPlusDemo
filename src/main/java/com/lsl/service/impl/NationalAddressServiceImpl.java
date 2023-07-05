package com.lsl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsl.entity.NationalAddress;
import com.lsl.mapper.NationalAddressMapper;
import com.lsl.service.INationalAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LSL
 * @since 2022-11-17
 */
@Service
public class NationalAddressServiceImpl extends ServiceImpl<NationalAddressMapper, NationalAddress> implements INationalAddressService {

    @Override
    public  IPage<NationalAddress> findListByPage(Integer page, Integer pageCount){
        IPage<NationalAddress> wherePage = new Page<>(page, pageCount);
        NationalAddress where = new NationalAddress();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(NationalAddress nationalAddress){
        return baseMapper.insert(nationalAddress);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(NationalAddress nationalAddress){
        return baseMapper.updateById(nationalAddress);
    }

    @Override
    public NationalAddress findById(Long id){
        return  baseMapper.selectById(id);
    }
}
