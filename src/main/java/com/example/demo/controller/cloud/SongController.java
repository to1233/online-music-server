package com.example.demo.controller.cloud;

import com.example.demo.common.AjaxResult;
import com.example.demo.pojo.vo.song.*;
import com.example.demo.service.Impl.CloudSongMusicImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/19 15:57
 * @Description
 */
@RestController
@RequestMapping("/cloud/song")
public class SongController {


    @Resource
    private CloudSongMusicImpl cloudMusic;


    /**
     * 根据关键词来搜索歌曲信息
     * @param cloudSearchSuggestVo 搜索参数对象
     * @return JSONObject
     */
    @PostMapping("/searchSuggest")
    public AjaxResult searchSuggest(@RequestBody CloudSearchSuggestVo cloudSearchSuggestVo) {
        return AjaxResult.ajaxResult(cloudMusic.searchSuggest(cloudSearchSuggestVo));
    }


    @GetMapping("/hotSearch")
    public AjaxResult hotSearch() {
        return AjaxResult.ajaxResult(cloudMusic.hotSearch());
    }

    /**
     * 根据关键字来查询出 歌曲信息
     * @param songSearchVo 关键字
     * @return
     */
    @PostMapping("/findSongList")
    public AjaxResult findSongList(@RequestBody SongSearchVo songSearchVo) {
        return AjaxResult.ajaxResult(cloudMusic.search(songSearchVo));
    }


    /**
     * 根据歌曲id 来查询出对应的歌曲详情信息
     * @param songId 歌曲id
     * @return JSONObject
     */
    @GetMapping("/detail/{songId}")
    public AjaxResult findSongDetail(@PathVariable("songId") Integer songId) {
        List<Integer> ids = new ArrayList<>();
        ids.add(songId);
        SongSearchIdVo searchIdVo = new SongSearchIdVo(songId, "[{id:"+songId+"}]", ids, "");
        return AjaxResult.ajaxResult(cloudMusic.findSongDetailById(searchIdVo));
    }

    /**
     * 根据歌曲id来查询出对应的歌曲播放url
     * @param songId 歌曲id
     * @return JSONObject
     */
    @GetMapping("/findSongUrl/{songId}")
    public AjaxResult findSongUrl(@PathVariable("songId") Integer songId) {
        SongSearchUrlByIdVo songSearchUrlByIdVo = new SongSearchUrlByIdVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(songId);
        songSearchUrlByIdVo.setIds(ids);
        return AjaxResult.ajaxResult(cloudMusic.findSongUrlById(songSearchUrlByIdVo));
    }

}
