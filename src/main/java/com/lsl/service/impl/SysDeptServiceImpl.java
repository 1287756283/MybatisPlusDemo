package com.lsl.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsl.entity.SysDept;
import com.lsl.entity.User;
import com.lsl.mapper.SysDeptMapper;
import com.lsl.mapper.UserMapper;
import com.lsl.service.IUserService;
import com.lsl.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 连石磊
 * @since 2021-07-09
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    private static final String JIA_XING = "嘉兴";
    private static final String GANG_QU = "港区";

    @Autowired
    private SysDeptMapper sysDeptMapper;

    public Map<String, String> regexAddress(String address) {
        // 自定义正则表达式
        String regex = "((?<province>[^省]+省|))(?<city>[^市]+市|.+区)?(?<country>[^县]+县|.+市|(.?区))";
        // 使用regex正则表达式匹配address地址
        Matcher matcher = Pattern.compile(regex).matcher(address);
        // 定义ArrayList<>()
        Map<String, String> row = null;
        //匹配成功的情况
        while (matcher.find()) {
            row = new LinkedHashMap<>();
            setAddrList(address, matcher, row);
        }
        return row;
    }

    private void setAddrList(String address, Matcher matcher, Map<String, String> row) {
        // 初始化省市县
        String province;
        String city;
        String country;
        province = matcher.group("province");
        row.put("province", province == null ? "" : province.trim());
        city = matcher.group("city");
        Optional<Object> empty = Optional.empty();
        if (address.contains("市")) {
            row.put("city", city == null ? "" : city.trim());
        }
        country = matcher.group("country");
        row.put("country", country == null ? "" : country);
    }

    //获取是否符合条件的状态
    private Boolean getState(SysDept dept, String region) {
        if (StrUtil.isEmpty(region)) {
            return Boolean.FALSE;
        }
        return dept.getDeptId().contains("3304")
                && dept.getIsUse().equals(Boolean.TRUE)
                && (dept.getLev().equals(3) || dept.getLev().equals(2))
                && dept.getShortName().contains(region) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public SysDept guessDeptByAddress(String address) {
        List<SysDept> sysDeptsList;
        LambdaQueryWrapper<SysDept> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(SysDept::getDeptId, "3304")
                .eq(SysDept::getIsUse, true)
                .in(SysDept::getLev, 2, 3);
        sysDeptsList = this.list(queryWrapper);


        Map<String, String> map = regexAddress(address);
        String country;
        String city;
        SysDept sysDept;
        if (ObjectUtil.isNotNull(map)) {
            country = Optional.ofNullable(map.get("country")).orElse("");
            System.out.println("country = " + country);
            sysDept = sysDeptsList.stream().filter(dept -> getState(dept, country)).findFirst().orElse(null);
            if (ObjectUtil.isNotNull(sysDept)) {
                return sysDept;
            }
            city = Optional.ofNullable(map.get("city")).orElse("");
            System.out.println("city = " + city);
            sysDept = sysDeptsList.stream().filter(dept -> getState(dept, city)).findFirst().orElse(null);
            if (ObjectUtil.isNotNull(sysDept)) {
                return sysDept;
            }
        }
        sysDept = sysDeptsList.stream().filter(dept -> getState(dept, address.replaceAll("省", "").replaceAll("市", "").replaceAll("区", "").replaceAll("县", ""))).findFirst().orElse(null);

        return sysDept;
    }

    @Override
    public SysDept guessDeptByAddress2(String address) {

        List<SysDept> sysDeptsList;
        LambdaQueryWrapper<SysDept> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(SysDept::getDeptId, "3304")
                .eq(SysDept::getIsUse, true)
                .in(SysDept::getLev, 2, 3);
        sysDeptsList = this.list(queryWrapper);
        SysDept sysDept = null;
        HashMap<String, String> MAP = new HashMap<String, String>() {{
            put("NAN_HU", "南湖");
            put("JINGJI_KAIFA", "经济开发");
            put("XIU_ZHOU", "秀洲");
            put("HAI_YAN", "海盐");
            put("JIA_SHAN", "嘉善");
            put("TONG_XIANG", "桐乡");
            put("PING_HU", "平湖");
            put("HAI_NING", "海宁");
            put("GANG", "港");
        }};

        for (String key : MAP.keySet()) {
            if (StrUtil.contains(address, MAP.get(key))) {
                sysDept = sysDeptsList.stream().filter(dept -> getState(dept, MAP.get(key))).findFirst().orElse(null);
            }
        }
        if (ObjectUtil.isNull(sysDept)) {
            sysDeptsList.stream().filter(dept -> getState(dept, "嘉兴")).findFirst().orElse(null);
        }
        return sysDept;
    }

    @Override
    public SysDept guessDeptByAddress3(String address) {
        System.out.println("guessDeptByAddress3");
        List<SysDept> sysDeptsList = new ArrayList<>();
        SysDept sysDept = null;
        LambdaQueryWrapper<SysDept> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(SysDept::getDeptId, "3304")
                .eq(SysDept::getIsUse, true)
                .in(SysDept::getLev, 2, 3);
        sysDeptsList = sysDeptMapper.selectList(queryWrapper);


        HashMap<String, String> dictMap = new HashMap<String, String>() {{
            put("NAN_HU", "南湖");
            put("JINGJI_KAIFA", "经济开发");
            put("XIU_ZHOU", "秀洲");
            put("HAI_YAN", "海盐");
            put("JIA_SHAN", "嘉善");
            put("TONG_XIANG", "桐乡");
            put("PING_HU", "平湖");
            put("HAI_NING", "海宁");
            put("GANG", "港");
        }};

        for (String key : dictMap.keySet()) {
            String addressValue = dictMap.get(key);
            if (!dictMap.get(key).equals(GANG_QU)) {
                addressValue = addressValue.replaceAll("省", "").replaceAll("市", "").replaceAll("县", "").replaceAll("区", "");
            }
            if (StrUtil.contains(address, addressValue)) {
                String finalAddressValue = addressValue;
                sysDept = sysDeptsList.stream().filter(dept -> getState(dept, finalAddressValue)).findFirst().orElse(null);
            }
        }
        if (ObjectUtil.isNull(sysDept)) {
            sysDept = sysDeptsList.stream().filter(dept -> getState(dept, JIA_XING)).findFirst().orElse(null);
        }
        return sysDept;
    }
}
