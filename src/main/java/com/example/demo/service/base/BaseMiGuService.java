package com.example.demo.service.base;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/3 18:22
 * @Description
 */
@Slf4j
public class BaseMiGuService {

    @Resource
    private RestTemplate restTemplate;

    public JSONObject sendMiGuRequest(String tarUrl,String jsonParams) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("uiVersion", "A_music_3.3.0");
        headers.add("Origin", "http://music.migu.cn/v3/music/player/audio?from=migu");
        headers.add("Referer", "http://music.migu.cn/v3/music/player/audio?from=migu");
       /* headers.add("appId", "yyapp2");
        headers.add("deviceId", "B9A586BA72F3916E7B4145588DCA82A2");
        headers.add("sign", "ccb172ce98809a350e7ffc6e9667575c");*/
        headers.add("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36");
        //封装请求头
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(tarUrl,
                HttpMethod.GET, formEntity,String.class,jsonParams);
        String body2 = responseEntity.getBody(); //响应体
        JSONObject result = JSONObject.parseObject(body2);
        log.info("{}", result);
        return result;
    }
}
