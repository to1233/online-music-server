package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ParamVo;
import com.example.demo.pojo.vo.song.SongSearchIdVo;
import com.example.demo.pojo.vo.song.SongSearchVo;
import com.example.demo.pojo.vo.songsheet.SearchSheetDetailVo;
import com.example.demo.pojo.vo.songsheet.SearchSongSheetVo;
import com.example.demo.service.base.BaseService;
import com.example.demo.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/23 11:13
 * @Description
 */
@Service
public class CloudSongSheetImpl extends BaseService {

    @Value("${baseUrl.cloud}")
    private String baseUrl;

    @Override
    public JSONObject findSongSheet(SearchSongSheetVo searchSongSheetVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(searchSongSheetVo));
        return super.sendCloudRequest(baseUrl + "/playlist/list", paramVo, "");
    }

    @Override
    public JSONObject findSheetInfoById(SearchSheetDetailVo searchSheetDetailVo) {
        ParamVo paramVo = EncryptUtils.encrypt(JSON.toJSONString(searchSheetDetailVo));
        return super.sendCloudRequest(baseUrl + "/v3/playlist/detail", paramVo, "");
    }
}
