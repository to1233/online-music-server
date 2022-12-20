package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ParamVo;
import com.example.demo.pojo.vo.singer.SearchSingerDetailVo;
import com.example.demo.pojo.vo.singer.SearchSingerVo;
import com.example.demo.service.base.BaseCloudService;
import com.example.demo.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/24 11:46
 * @Description
 */
@Service
public class CloudSingerImpl extends BaseCloudService {

    @Value("${baseUrl.cloud}")
    private String baseUrl;

    public JSONObject findSinger(SearchSingerVo searchSingerVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(searchSingerVo));
        return sendCloudRequest(baseUrl + "/artist/top", paramVo, "");
    }

    public JSONObject findSingerDetailById(String singerId, SearchSingerDetailVo searchSingerDetailVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(searchSingerDetailVo));
        return sendCloudRequest(baseUrl + "/v1/artist/" + singerId, paramVo, "");
    }
}
