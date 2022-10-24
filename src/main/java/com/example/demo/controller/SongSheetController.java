package com.example.demo.controller;

import com.example.demo.common.AjaxResult;
import com.example.demo.pojo.vo.songsheet.SearchSheetDetailVo;
import com.example.demo.pojo.vo.songsheet.SearchSongSheetVo;
import com.example.demo.service.Impl.CloudSongSheetImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/23 11:04
 * @Description
 */
@RequestMapping("/songSheet")
@RestController
public class SongSheetController {

    @Resource
    private CloudSongSheetImpl cloudSongSheetService;

    @PostMapping("/findSongSheet")
    public AjaxResult findSongSheetList(@RequestBody SearchSongSheetVo searchSongSheetVo) {
        return AjaxResult.ajaxResult(cloudSongSheetService.findSongSheet(searchSongSheetVo));
    }

    @PostMapping("/findSheetInfoById")
    public AjaxResult findSheetInfoById(@RequestBody SearchSheetDetailVo searchSheetDetailVo) {
        return AjaxResult.ajaxResult(cloudSongSheetService.findSheetInfoById(searchSheetDetailVo));
    }
}
