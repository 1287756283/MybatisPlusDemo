package com.lsl.entity;

import lombok.Data;

import java.util.List;

@Data
public class items {
    String componentId;

    String componentVersion;

    List<dataDictType> dataDictTypes;
    List<dataDict> dataDicts;
}
