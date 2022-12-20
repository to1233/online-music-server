package com.example.demo.controller.kuwo;

import com.example.demo.common.AjaxResult;
import com.example.demo.pojo.vo.song.CloudSearchSuggestVo;
import com.example.demo.pojo.vo.song.kuwo.SongSearchPageVo;
import com.example.demo.service.Impl.KuwoSongServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/19 15:57
 * @Description
 */
@RestController
@RequestMapping("/kuwo/song")
public class KuwoSongController {


    @Resource
    private KuwoSongServiceImpl kuwoSongService;

    /**
     * 根据关键字来查询出 歌曲信息
     * @param songSearchPageVo 关键字
     * @return
     */
    @PostMapping("/findSongList")
    public AjaxResult findSongList(@RequestBody SongSearchPageVo songSearchPageVo) {
        return AjaxResult.ajaxResult(kuwoSongService.search(songSearchPageVo));
    }

    /**
     * 热门搜索
     * @param cloudSearchSuggestVo 搜索参数
     * @return
     */
    @PostMapping("/searchSuggest")
    public AjaxResult searchSuggest(@RequestBody CloudSearchSuggestVo cloudSearchSuggestVo) {
        return AjaxResult.ajaxResult(kuwoSongService.findSearchSugggest(cloudSearchSuggestVo));
    }


    /**
     * 根据歌曲id 来查询出对应的歌曲详情信息
     * @param songId 歌曲id
     * @return JSONObject
     */
    @GetMapping("/detail/{songId}")
    public AjaxResult findSongDetail(@PathVariable("songId") String songId) {
        return AjaxResult.ajaxResult(kuwoSongService.findSongDetailById(songId));
    }

    /**
     * 根据歌曲id来查询出对应的歌曲播放url
     * @param songId 歌曲id
     * @return JSONObject
     */
    @GetMapping("/findSongUrl/{songId}")
    public AjaxResult findSongUrl(@PathVariable("songId") String songId) {
        return AjaxResult.ajaxResult(kuwoSongService.findSongUrlById(songId));
    }

}
