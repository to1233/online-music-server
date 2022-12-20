package com.example.demo.controller.kugou;

import com.example.demo.common.AjaxResult;
import com.example.demo.pojo.vo.song.kuwo.SongSearchPageVo;
import com.example.demo.service.Impl.KuGouSongServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/1 20:30
 * @Description
 */
@RestController
@RequestMapping("/kuGou/song")
public class KuGouSongController {


    @Resource
    private KuGouSongServiceImpl kuGouSongService;

    /**
     * 根据关键字来查询出 歌曲信息
     * @param songSearchPageVo 关键字
     * @return
     */
    @PostMapping("/findSongList")
    public AjaxResult findSongList(@RequestBody SongSearchPageVo songSearchPageVo) {
        return AjaxResult.ajaxResult(kuGouSongService.search(songSearchPageVo));
    }


    /**
     * 根据歌曲id来查询出对应的歌曲播放url
     * @param songId 歌曲id
     * @return JSONObject
     */
    @GetMapping("/findSongUrl/{songId}")
    public AjaxResult findSongUrl(@PathVariable("songId") String songId) {
        return AjaxResult.ajaxResult(kuGouSongService.findSongUrlById(songId));
    }

    @GetMapping("/findSongUrlVip/{songId}")
    public AjaxResult findSongUrlVip(@PathVariable("songId") String songId) {
        return AjaxResult.ajaxResult(kuGouSongService.findSongUrlVip(songId));
    }

}
