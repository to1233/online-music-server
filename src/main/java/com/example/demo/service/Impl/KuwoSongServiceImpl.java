package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.AjaxResult;
import com.example.demo.pojo.vo.song.CloudSearchSuggestVo;
import com.example.demo.pojo.vo.song.kuwo.SongSearchPageVo;
import com.example.demo.service.base.BaseKuwoService;
import org.springframework.stereotype.Service;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/24 19:29
 * @Description
 */
@Service
public class KuwoSongServiceImpl extends BaseKuwoService {

    public JSONObject search(SongSearchPageVo songSearchPageVo) {
        String aimUrl = "https://www.kuwo.cn/api/www/search/searchMusicBykeyWord?key=" + songSearchPageVo.getKeyWords() + "&pn=" + songSearchPageVo.getPage() + "&rn=15";
        return sendKuWoRequestJSON(aimUrl);
    }

    public JSONObject findSongDetailById(String songId) {
        String aimUrl = "http://antiserver.kuwo.cn/anti.s?type=convert_url&format=mp3&response=url&rid="+songId;
        return sendKuWoRequestJSON(aimUrl);
    }

    public Object findSongUrlById(String songId) {
        String aimUrl = "http://antiserver.kuwo.cn/anti.s?type=convert_url&format=mp3&response=url&rid="+songId;
        return sendKuWoRequest(aimUrl);
    }

    public JSONObject findSearchSugggest(CloudSearchSuggestVo cloudSearchSuggestVo) {
        String  aimUrl = "https://www.kuwo.cn/api/www/search/searchKey?key="+cloudSearchSuggestVo.getS()+"&httpsStatus=1";
        return sendKuWoRequestJSON(aimUrl);
    }
}
