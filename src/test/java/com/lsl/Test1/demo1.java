package com.lsl.Test1;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lsl.entity.NationalAddress;
import com.lsl.service.INationalAddressService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class demo1 {

    @Autowired
    private INationalAddressService addressService;

    @Test
    public void logTest() {
        //1 查询省份
        List<NationalAddress> addressList = addressService.list();

        List<NationalAddress> shi = addressList.stream().filter(s -> s.getLev().equals(2)).collect(Collectors.toList());
        List<NationalAddress> qu = addressList.stream().filter(s -> s.getLev().equals(3)).collect(Collectors.toList());


//        List<NationalAddress> setdata=new ArrayList<>();
//        //130100
//        for (NationalAddress oneshi : shi) {
//            String addrId = oneshi.getAddrId();
//            String substring = addrId.substring(0, 4);
//            List<NationalAddress> substring1 = qu.stream().filter(s ->
//                s.getAddrId().substring(0,4).equals(substring)
//            ).collect(Collectors.toList());
//            substring1.stream().forEach(a -> a.setParentId(addrId));
//            setdata.addAll(substring1);
//        }
//        addressService.updateBatchById(setdata);

        
    }

}
