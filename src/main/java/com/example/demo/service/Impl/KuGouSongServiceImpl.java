package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.vo.song.kugou.SearchSongLyricVo;
import com.example.demo.pojo.vo.song.kuwo.SongSearchPageVo;
import com.example.demo.service.base.BaseKuGouService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/1 20:33
 * @Description
 */
@Slf4j
@Service
public class KuGouSongServiceImpl extends BaseKuGouService {

    /**
     * 根据关键词来搜索对应的歌曲信息
     *
     * @param songSearchPageVo 搜索信息
     * @return JSONObject
     */
    public JSONObject search(SongSearchPageVo songSearchPageVo) {
        String target_url = String.format("http://songsearch.kugou.com/song_search_v2?keyword=%s&page=%d", songSearchPageVo.getKeyWords(), songSearchPageVo.getPage());
        return sendKuGouRequest(target_url).getJSONObject("data");
    }


    public Object findSongUrlById(SearchSongLyricVo searchSongLyricVo) {
        // String aimUrl = "http://m.kugou.com/app/i/getSongInfo.php?cmd=playInfo&hash="+songId;
        // String aimUrl = "https://wwwapi.kugou.com/yy/index.php?r=play/getdata&mid=1&hash=" + songId;
        String aimUrl = "https://wwwapi.kugou.com/yy/index.php?r=play/getdata&mid=1&hash="+searchSongLyricVo.getSongId()+"&platid=4&_=1671939443715" +
                ( StringUtils.isNotEmpty(searchSongLyricVo.getAlbumId()) ? "&album_id="+searchSongLyricVo.getAlbumId() : "" )  ;
        JSONObject response = sendKuGouRequest(aimUrl);
        try {
            return response.getJSONObject("data");
        } catch (Exception ex) {
            log.error("捕获到歌词异常---{}", ex.getMessage(), ex);
        }
        return "";
    }

    public Object findSongUrlVip(String songId) {
        String md5 = DigestUtils.md5Hex(songId + "kgcloudv2").toLowerCase();
        String aimUrl = String.format("http://trackercdnbj.kugou.com/i/v2/?cmd=23&pid=1&behavior=download&hash=%s&key=%s", songId, md5);
        JSONObject result = sendKuGouRequest(aimUrl);
        String lyrics = findSongLyricInfo(songId);
        result.put("lyric", lyrics);
        return result;
    }

    public String findSongLyricInfo(String songId) {
        String target_url = "https://wwwapi.kugou.com/yy/index.php?r=play/getdata&mid=1&hash=" + songId + "&platid=4&_=1671939443715";
        JSONObject response = sendKuGouRequest(target_url);
        try {
            return response.getJSONObject("data").get("lyrics").toString();
        } catch (Exception ex) {
            log.error("捕获到歌词异常---{}", ex.getMessage(), ex);
        }
        return "";
    }


}
