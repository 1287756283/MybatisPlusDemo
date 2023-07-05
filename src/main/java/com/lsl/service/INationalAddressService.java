package com.lsl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsl.entity.NationalAddress;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LSL
 * @since 2022-11-17
 */
public interface INationalAddressService extends IService<NationalAddress> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<NationalAddress>
     */
    IPage<NationalAddress> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param nationalAddress
     * @return int
     */
    int add(NationalAddress nationalAddress);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param nationalAddress
     * @return int
     */
    int updateData(NationalAddress nationalAddress);

    /**
     * id查询数据
     *
     * @param id id
     * @return NationalAddress
     */
    NationalAddress findById(Long id);
}
