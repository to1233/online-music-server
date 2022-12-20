package com.example.demo.service.base;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/30 17:15
 * @Description
 */
@Slf4j
public class BaseQQService {

    @Resource
    private RestTemplate restTemplate;

    /**
     * QQ发送接口
     *
     * @param targetUrl 目标地址
     * @return JSONObject
     */
    public JSONObject sendQQRequest(String targetUrl) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Referer", "https://y.qq.com");
        //封装请求头
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(targetUrl, HttpMethod.GET, formEntity, String.class);
        String body2 = responseEntity.getBody(); //响应体
        String jsonBody = body2.substring("jsonp4(".length(), body2.length() - 1);
        JSONObject result = JSONObject.parseObject(jsonBody);
        log.info("{}", result);
        return result;
    }

    /**
     * 使用占位符来发送对应的消息
     * @param tarUrl 目标url
     * @param jsonParams 占位参数
     * @return JSONObject
     */
    public JSONObject sendQQRequest(String tarUrl, String jsonParams) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Referer", "https://y.qq.com");
        headers.add("User-Agent","Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; BLA-AL00 Build/HUAWEIBLA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/8.9 Mobile Safari/537.36");
        //封装请求头
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(tarUrl+"{jsonParams}",
                HttpMethod.GET, formEntity,String.class,jsonParams);
        String body2 = responseEntity.getBody(); //响应体
        JSONObject result = JSONObject.parseObject(body2);
        log.info("{}", result);
        return result;
    }

}
