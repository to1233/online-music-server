package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ParamVo;
import com.example.demo.pojo.vo.song.CloudSearchSuggestVo;
import com.example.demo.pojo.vo.song.SongSearchIdVo;
import com.example.demo.pojo.vo.song.SongSearchUrlByIdVo;
import com.example.demo.pojo.vo.song.SongSearchVo;
import com.example.demo.service.base.BaseCloudService;
import com.example.demo.utils.EncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/19 14:07
 * @Description
 */
@Slf4j
@Service
public class CloudSongMusicImpl extends BaseCloudService {
    @Value("${baseUrl.cloud}")
    private String baseUrl;


    public JSONObject search(SongSearchVo songSearchVo) {
        songSearchVo.setTotal("true");
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(songSearchVo));
        JSONObject result = sendCloudRequest( baseUrl+"/cloudsearch/get/web", paramVo, "");
        return result.getJSONObject("result");
    }

    /**
     * 搜索数据
     *
     * @return
     */
    public JSONObject searchSuggest(CloudSearchSuggestVo cloudSearchSuggestVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(cloudSearchSuggestVo));
        JSONObject result = sendCloudRequest(baseUrl+"/search/suggest/web?csrf_token=", paramVo, "");
        return result.getJSONObject("result");
    }

    public JSONArray findSongDetailById(SongSearchIdVo songSearchIdVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(songSearchIdVo));
        JSONObject result = sendCloudRequest( baseUrl+"/v3/song/detail", paramVo, "");
        return result.getJSONArray("songs");
    }

    public String findSongLyric(String songId) {
        String d = String.format("{\"id\":%s,\"lv\":-1,\"tv\":-1,\"csrf_token\":\"\"}",songId);
        ParamVo paramVo = EncryptUtils.encrypt(d);
        JSONObject result = sendCloudRequest( baseUrl+"/song/lyric?csrf_token=", paramVo, "");
        JSONObject lrc =  result.getJSONObject("lrc");
        if(lrc!=null) {
            return lrc.getString("lyric");
        }
        return "";
    }


    public JSONArray findSongUrlById(SongSearchUrlByIdVo songSearchUrlByIdVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(songSearchUrlByIdVo));
        JSONObject result = sendCloudRequest( baseUrl+"/song/enhance/player/url", paramVo, "");
        return result.getJSONArray("data");
    }


    /**
     * 获取热门歌曲数据
     * @return JSONObject
     */
    public JSONObject hotSearch() {
        Map<String,Integer>  params = new HashMap<>();
        params.put("type",1111);
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(params));
        JSONObject result = sendCloudRequest( baseUrl+"/search/hot", paramVo, "");
        return result.getJSONObject("result");
    }



}
