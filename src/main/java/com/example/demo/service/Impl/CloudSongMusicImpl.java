package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ParamVo;
import com.example.demo.pojo.vo.song.CloudSearchSuggestVo;
import com.example.demo.pojo.vo.song.SongSearchIdVo;
import com.example.demo.pojo.vo.song.SongSearchUrlByIdVo;
import com.example.demo.pojo.vo.song.SongSearchVo;
import com.example.demo.service.base.BaseService;
import com.example.demo.utils.EncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/19 14:07
 * @Description
 */
@Slf4j
@Service
public class CloudSongMusicImpl extends BaseService {

    @Value("${baseUrl.cloud}")
    private String baseUrl;

    @Override
    public JSONObject search(SongSearchVo songSearchVo) {
        songSearchVo.setTotal("false");
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(songSearchVo));
        JSONObject result = super.sendCloudRequest(baseUrl + "/cloudsearch/get/web", paramVo, "");
        return result.getJSONObject("result");
    }

    /**
     * 搜索数据
     *
     * @return
     */
    @Override
    public JSONObject searchSuggest(CloudSearchSuggestVo cloudSearchSuggestVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(cloudSearchSuggestVo));
        JSONObject result = super.sendCloudRequest(baseUrl + "/search/suggest/web?csrf_token=", paramVo, "");
        return result.getJSONObject("result");
    }

    @Override
    public JSONArray findSongDetailById(SongSearchIdVo songSearchIdVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(songSearchIdVo));
        JSONObject result =  super.sendCloudRequest(baseUrl + "/v3/song/detail", paramVo, "");
        return result.getJSONArray("songs");
    }


    @Override
    public JSONArray findSongUrlById(SongSearchUrlByIdVo songSearchUrlByIdVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(songSearchUrlByIdVo));
        JSONObject result =   super.sendCloudRequest(baseUrl + "/song/enhance/player/url", paramVo, "");
        return result.getJSONArray("data");
    }
}
