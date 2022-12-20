package com.example.demo.controller.kuwo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.AjaxResult;
import com.example.demo.pojo.vo.singer.SingerDetailVo;
import com.example.demo.service.Impl.KuwoSingerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/30 10:19
 * @Description
 */
@RestController
@RequestMapping("/kuwo/singer")
public class KuwoSingerController {

    @Resource
    private KuwoSingerServiceImpl kuwoSingerService;

    /**
     * 根据艺术家的id来查询对应的个人信息
     *
     * @param artistid 酷我中对应的艺术家id
     * @return
     */
    @GetMapping("/findSingerDetailById/{artistid}")
    public AjaxResult findSingerDetailById(@PathVariable("artistid") String artistid) {
        // 歌手信息
        JSONObject singerDetailInfo = kuwoSingerService.findSingerDetailById(artistid);
        // 歌手下的歌曲信息
        JSONObject songList = kuwoSingerService.findSingerMusicById(artistid);
        SingerDetailVo singerDetailVo = new SingerDetailVo(singerDetailInfo.getJSONObject("data"), songList.getJSONObject("data"));
        return AjaxResult.ajaxResult(singerDetailVo);
    }

}
