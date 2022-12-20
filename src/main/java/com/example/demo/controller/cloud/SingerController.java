package com.example.demo.controller.cloud;

import com.example.demo.common.AjaxResult;
import com.example.demo.pojo.vo.singer.SearchSingerDetailVo;
import com.example.demo.pojo.vo.singer.SearchSingerVo;
import com.example.demo.service.Impl.CloudSingerImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/24 11:37
 * @Description
 */
@RestController
@RequestMapping("/cloud/singer")
public class SingerController {

    @Resource
    private CloudSingerImpl cloudSingerService;

    /**
     * 查询热门歌手
     * @return
     */
    @PostMapping("/top/list")
    public AjaxResult findSingerPage(@RequestBody SearchSingerVo searchSingerVo) {
        return AjaxResult.ajaxResult(cloudSingerService.findSinger(searchSingerVo));
    }

    @PostMapping("/findSingerDetailById/{singerId}")
    public AjaxResult findSingerDetailById(@PathVariable("singerId") String singerId, @RequestBody SearchSingerDetailVo searchSingerDetailVo) {
        return AjaxResult.ajaxResult(cloudSingerService.findSingerDetailById(singerId,searchSingerDetailVo));
    }
}
