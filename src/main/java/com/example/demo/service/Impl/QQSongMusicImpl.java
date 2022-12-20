package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.vo.song.kuwo.SongSearchPageVo;
import com.example.demo.service.base.BaseQQService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/30 17:14
 * @Description QQ音乐接口
 */
@Service
public class QQSongMusicImpl extends BaseQQService {


    public JSONObject search(SongSearchPageVo songSearchPageVo) {
        String aimUrl = "http://i.y.qq.com/s.music/fcgi-bin/search_for_qq_cp?g_tk=938407465&uin=0&format=jsonp&inCharset=utf-8&outCharset=utf-8&notice=0&platform=h5&needNewCode=1&w=" + songSearchPageVo.getKeyWords() + "&zhidaqu=1&catZhida=1&t=0&flag=1&ie=utf-8&sem=1&aggr=0&perpage=15&n=15&p=" + songSearchPageVo.getPage() + "&remoteplace=txt.mqq.all&_=1459991037831&jsonpCallback=jsonp4";
        return sendQQRequest(aimUrl);
    }

    public JSONObject findSongUrlById(String songId) {
        String paramMap = "{\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"filename\":[\"M500" + songId + songId + ".mp3\"],\"guid\":\"10000\",\"songmid\":[\"" + songId + "\"],\"songtype\":[0],\"uin\":\"0\",\"loginflag\":1,\"platform\":\"20\"}},\"loginUin\":\"0\",\"comm\":{\"uin\":\"0\",\"format\":\"json\",\"ct\":24,\"cv\":0}}";
        String aimUrl = "https://u.y.qq.com/cgi-bin/musicu.fcg?format=json&data=";
        return sendQQRequest(aimUrl, paramMap);
    }
}
