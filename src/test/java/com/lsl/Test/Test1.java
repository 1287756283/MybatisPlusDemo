package com.lsl.Test;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import org.aspectj.apache.bcel.classfile.Code;
import org.junit.jupiter.api.Test;
import sun.nio.cs.ext.MacTurkish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
*@author LIAN
*@create 2021/9/10 17:43
*/public class Test1 {
}


class Aliez{

    @Test
    void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(list);
        long count = list.stream().filter(s->s==1).count();
        System.out.println(count);
    }

    @Test
    void ttt(){
        String a="group1/M00/00/53/dD-gDWFRlcCAV-s3AAEAAHMGD_8161.xls";
        String[] split = a.split("/", 2);
        Arrays.stream(split).forEach(System.out::println);
      /*  System.out.println(split[0]);
        System.out.println(split[1]);*/
    }

    public String getURL(String geturl) throws IOException {
        URL url = new URL(geturl);
        StringBuffer buffer = new StringBuffer();
        //http协议传输
        HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
        httpUrlConn.setDoOutput(true);
        httpUrlConn.setDoInput(true);
        httpUrlConn.setUseCaches(false);
        httpUrlConn.connect();
        //将返回的输入流转换成字符串
        InputStream inputStream = httpUrlConn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        //释放资源
        inputStream.close();
        inputStream = null;
        httpUrlConn.disconnect();
        return buffer.toString();
    }

    @Test
    void MockTest1() throws IOException {
        //根据url获取返回的结果
        //geturl为外部接口地址
/*
        String url = getURL("https://console-mock.apipost.cn/app/mock/project/df794758-5a65-49ba-9c1d-b40490cd550f/getList");
        System.out.println(url);
        JSONObject jsonObject = new JSONObject(url);
        Object code = jsonObject.get("data");
        System.out.println(code);

        Map map= (Map) JSON.parse(url);
        System.out.println(map);*/
        Map<String, Object> params = new HashMap<>();
        String post = HttpUtil.get("https://console-mock.apipost.cn/app/mock/project/df794758-5a65-49ba-9c1d-b40490cd550f/getList");
        System.out.println(post);
        String post1 = HttpUtil.post("https://console-mock.apipost.cn/app/mock/project/df794758-5a65-49ba-9c1d-b40490cd550f/warnDataFzeq/locationData",params);
        System.out.println("post-->"+post1);
    }
}
