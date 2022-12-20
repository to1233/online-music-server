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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/24 19:33
 * @Description
 */
@Slf4j
public class BaseKuwoService {


    @Resource
    private RestTemplate restTemplate;


    public String getToken() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://www.kuwo.cn/", String.class);
        List<String> cookieFiled = responseEntity.getHeaders().get("set-cookie");
        if (CollectionUtils.isEmpty(cookieFiled)) {
            return null;
        }
        return getCookieValue(cookieFiled.get(0));
    }

    public String getCookieValue(String cookieFiled) {
        String regx = "kw_token=([^;]+);";
        Pattern r = Pattern.compile(regx);
        Matcher m = r.matcher(cookieFiled);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }


    /**
     * 酷我发送接口
     *
     * @param target_url 目标地址
     * @return JSONObject
     */
    public JSONObject sendKuWoRequestJSON(String target_url) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Referer", "http://www.kuwo.cn");
        headers.add("csrf", "AOPHIP5DF2M");
        headers.add("Cookie",
                "_ga=GA1.2.207336405.1578105222; _gid=GA1.2.1290422414.1578105222; Hm_lvt_cdb524f42f0ce19b169a8071123a4797=1578105222,1578105233,1578123281; Hm_lpvt_cdb524f42f0ce19b169a8071123a4797=1578123667; _gat=1; kw_token=AOPHIP5DF2M");
        //封装请求头
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(target_url, HttpMethod.GET, formEntity, String.class);
        String body2 = responseEntity.getBody(); //响应体
        JSONObject result = JSONObject.parseObject(body2);
        log.info("{}", result);
        return result;
    }


    /**
     * 酷我发送接口
     *
     * @param target_url 目标地址
     * @return JSONObject
     */
    public Object sendKuWoRequest(String target_url) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Referer", "http://www.kuwo.cn");
        //封装请求头
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(target_url, HttpMethod.GET, formEntity, String.class);
        return responseEntity.getBody(); //响应体
    }

}
