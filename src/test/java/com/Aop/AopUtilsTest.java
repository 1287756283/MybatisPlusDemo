package com.Aop;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lsl.entity.SystemDictData;
import com.lsl.entity.dataDict;
import com.lsl.entity.dataDictType;
import com.lsl.entity.items;
import com.lsl.mapper.SystemDictDataMapper;
import com.lsl.mapper.SystemDictTypeMapper;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.junit.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @author: lsl
 * @description:
 * @date: 2023/1/17 15:03
 */
public class AopUtilsTest {

    @Autowired
    SystemDictDataMapper systemDictDataMapper;
    @Autowired
    SystemDictTypeMapper systemDictTypeMapper;


    @Test
    public void AopUtils() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        XmlMapper build = XmlMapper.builder()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
                .build();
        ClassPathResource classPathResource = new ClassPathResource("./data_dicts_pcsmk.xml");
        items items = build.readValue(classPathResource.getFile(), items.class);
        List<dataDictType> dataDictTypes = items.getDataDictTypes();
        List<dataDict> dataDicts = items.getDataDicts();
        List<String> collect = dataDicts.stream().map(s -> s.getTypeCode()).distinct().collect(Collectors.toList());
        for (String key : collect) {
            for (dataDictType dataDictType : dataDictTypes) {
                if (dataDictType.getCode().equals(key)) {

                }
            }
        }
    }

    @Test
    public void add() throws IOException {
        SystemDictData systemDictData = new SystemDictData();
        systemDictData.setDictType("11");
        systemDictDataMapper.insert(systemDictData);
    }
}
