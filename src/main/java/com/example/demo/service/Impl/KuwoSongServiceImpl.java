package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.AjaxResult;
import com.example.demo.pojo.vo.song.CloudSearchSuggestVo;
import com.example.demo.pojo.vo.song.kuwo.SongSearchPageVo;
import com.example.demo.service.base.BaseKuwoService;
import javafx.util.Duration;
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

    public String findSongLyric(String songId) {
        String aimUrl = String.format("http://m.kuwo.cn/newh5/singles/songinfoandlrc?musicId=%s", songId);
        JSONObject result =  sendKuWoRequestJSON(aimUrl);
        if(result!= null) {
           JSONArray jsonArray =  result.getJSONObject("data").getJSONArray("lrclist");
           StringBuilder sb = new StringBuilder();

            jsonArray.forEach(line->{
                JSONObject itemJsonObject = (JSONObject)line;
                double time = Double.valueOf(itemJsonObject.get("time").toString()) ;
                Duration duration = new Duration(time*1000);
                String timeTick = String.format("%02d:%02d.%d",(int)duration.toMinutes(),(int)duration.toSeconds()%60,(int)duration.toMillis()%1000);
                sb.append("[");
                sb.append(timeTick);
                sb.append("]");
                sb.append(itemJsonObject.get("lineLyric"));
                sb.append("\n");
            });
            return sb.toString();
        }
        return "";
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
