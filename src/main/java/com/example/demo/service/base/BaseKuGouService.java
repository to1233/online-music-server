package com.example.demo.service.base;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/1 20:32
 * @Description
 */
@Slf4j
public class BaseKuGouService {

    @Resource
    private RestTemplate restTemplate;




    public JSONObject sendKuGouRequest(String tarUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Referer", "http://m.kugou.com");
        //封装请求头
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(tarUrl, HttpMethod.GET, formEntity, String.class);
        String body2 = responseEntity.getBody(); //响应体
        JSONObject result = JSONObject.parseObject(body2);
        log.info("{}", result);
        return result;
    }
}
