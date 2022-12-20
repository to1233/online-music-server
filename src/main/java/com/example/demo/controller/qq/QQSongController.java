package com.example.demo.controller.qq;

import com.example.demo.common.AjaxResult;
import com.example.demo.pojo.vo.song.SongSearchUrlByIdVo;
import com.example.demo.pojo.vo.song.kuwo.SongSearchPageVo;
import com.example.demo.service.Impl.QQSongMusicImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/30 17:08
 * @Description  qq音乐对应歌曲信息
 */
@RestController
@RequestMapping("/qq/song")
public class QQSongController {

    @Resource
    private QQSongMusicImpl qqSongMusic;


    @PostMapping("/findSongList")
    public AjaxResult findSongList(@RequestBody SongSearchPageVo songSearchPageVo) {
        return AjaxResult.ajaxResult(qqSongMusic.search(songSearchPageVo));
    }



    /**
     * 根据歌曲id来查询出对应的歌曲播放url
     * @param songId 歌曲id
     * @return JSONObject
     */
    @GetMapping("/findSongUrl/{songId}")
    public AjaxResult findSongUrl(@PathVariable("songId") String songId) {
        return AjaxResult.ajaxResult(qqSongMusic.findSongUrlById(songId));
    }


}
