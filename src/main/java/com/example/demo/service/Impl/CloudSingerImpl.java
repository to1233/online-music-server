package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ParamVo;
import com.example.demo.pojo.vo.singer.SearchSingerDetailVo;
import com.example.demo.pojo.vo.singer.SearchSingerVo;
import com.example.demo.service.base.BaseService;
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
public class CloudSingerImpl extends BaseService {


    @Value("${baseUrl.cloud}")
    private String baseUrl;

    @Override
    public JSONObject findSinger(SearchSingerVo searchSingerVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(searchSingerVo));
        return super.sendCloudRequest(baseUrl + "/artist/top", paramVo, "");
    }


    @Override
    public JSONObject findSingerDetailById(String singerId, SearchSingerDetailVo searchSingerDetailVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(searchSingerDetailVo));
        return super.sendCloudRequest(baseUrl + "/v1/artist/" +singerId, paramVo, "");
    }
}
