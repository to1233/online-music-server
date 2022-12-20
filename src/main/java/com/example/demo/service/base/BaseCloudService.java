package com.example.demo.service.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/19 14:31
 * @Description 公共类实现 搜索 歌单 下载等公共方法
 */
@Slf4j
@Component
public class BaseCloudService {

    @Resource
    private RestTemplate restTemplate;



    /**
     * 共有的请求方法
     *
     * @param aimUrl
     * @param paramVo
     * @param cookie
     * @return
     */
    public JSONObject sendCloudRequest(String aimUrl, ParamVo paramVo, String cookie) {
        try {
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
            headers.setContentType(type);
            headers.add("Referer", "http://music.163.com");
            headers.add("Accept", MediaType.ALL_VALUE);
            headers.add("Accept-Language", "zh-CN,zh;q=0.8,gl;q=0.6,zh-TW;q=0.4");
            headers.add("Connection", "keep-alive");
            headers.add("Cookie", cookie);
            headers.add("Origin", "http://music.163.com");
            headers.add("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
            MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
            requestBody.add("params", paramVo.getParams());
            requestBody.add("encSecKey", paramVo.getEncSecKey());

            HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity( aimUrl, formEntity, String.class);
            String body2 = responseEntity.getBody(); //响应体
            JSONObject result = JSONObject.parseObject(body2);
            log.info("{}", result);
            return result;
        } catch (Exception ex) {
            log.error("捕获到异常信息---{}", ex.getMessage(), ex);
        }
        return null;
    }

}
