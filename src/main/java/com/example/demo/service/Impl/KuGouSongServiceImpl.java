package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.vo.song.kuwo.SongSearchPageVo;
import com.example.demo.service.base.BaseKuGouService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/1 20:33
 * @Description
 */
@Service
public class KuGouSongServiceImpl extends BaseKuGouService {

    /**
     * 根据关键词来搜索对应的歌曲信息
     * @param songSearchPageVo 搜索信息
     * @return JSONObject
     */
    public JSONObject search(SongSearchPageVo songSearchPageVo) {
        String target_url = String.format("http://songsearch.kugou.com/song_search_v2?keyword=%s&page=%d", songSearchPageVo.getKeyWords(), songSearchPageVo.getPage());
        return sendKuGouRequest(target_url).getJSONObject("data");
    }


    public Object findSongUrlById(String songId) {
        String aimUrl = "http://m.kugou.com/app/i/getSongInfo.php?cmd=playInfo&hash="+songId;
        return sendKuGouRequest(aimUrl);
    }

    public Object findSongUrlVip(String songId) {
        String md5 =  DigestUtils.md5Hex(songId + "kgcloudv2").toLowerCase();
        String aimUrl = String.format("http://trackercdnbj.kugou.com/i/v2/?cmd=23&pid=1&behavior=download&hash=%s&key=%s", songId, md5);
        return sendKuGouRequest(aimUrl);
    }

}
