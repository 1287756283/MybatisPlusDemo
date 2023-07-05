package com.lsl.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
        int val;
    Tree left;
    Tree right;

    Tree(int x) {
            val = x;
        }


    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Tree(), SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteMapNullValue));
    }
}
