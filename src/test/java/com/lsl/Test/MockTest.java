package com.lsl.Test;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lsl.entity.SysDept;
import com.lsl.service.SysDeptService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class MockTest {

    @Autowired
    private SysDeptService sysDeptService;

    @Test
    public void adderTest() {
        LongAdder insertCounter = new LongAdder();
        insertCounter.add(12);
        System.out.println("insertCounter.intValue() = " + insertCounter.intValue());
    }


    @Test
    public void getSysdeptList() {

        List<SysDept> list = new ArrayList<>();
        SysDept sysDept1 = sysDeptService.guessDeptByAddress3("浙江省杭州市余杭区"); //通过
        log.info(String.valueOf(sysDept1));
    }

    @Test
    public void test_() {
        String s = "330205240000";
        System.out.println("s.length() = " + s.length());
        String s1 = shortDeptId(s);
        System.out.println("s1.length() = " + s1.length());
    }

    public static String shortDeptId(String deptId) {
        if (StrUtil.isEmpty(deptId)) {
            return "";
        }
        int len;
        StringBuilder sb = new StringBuilder();
        byte[] bytes = deptId.getBytes(StandardCharsets.UTF_8);
        for (len = bytes.length - 1; len > 0; len--) {
            if (bytes[len] != '0') {
                len += 1;
                break;
            }
        }

        for (int i = 0; i < len; i++) {
            sb.append((char) bytes[i]);
        }
        // 如果奇数 则补一位代码 0
        if (len % 2 != 0) {
            sb.append("0");
        }
        return sb.toString();
    }

    @Test
    public void getSysDeptList() {
        List<SysDept> list = sysDeptService.list(new LambdaQueryWrapper<SysDept>().eq(SysDept::getLev, 3).eq(SysDept::getIsUse, 1).like(SysDept::getParentId, "3304").select(SysDept::getShortName, SysDept::getCreateTime));
        list.forEach(sysDept -> sysDept.setCreateTime(null));
        try {
            SysDept sysDept1 = list.stream().max((o1, o2) -> DateUtil.compare(o1.getCreateTime(),o2.getCreateTime())).get();
            SysDept sysDept2 = list.stream().max(Comparator.comparing(SysDept::getCreateTime)).get();
        }catch (Exception e){
            System.out.println("e = " + e);
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("e.getCause() = " + e.getCause());
        }

    }
}
