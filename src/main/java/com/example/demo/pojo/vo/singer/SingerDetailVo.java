package com.example.demo.pojo.vo.singer;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/30 11:20
 * @Description
 */
@AllArgsConstructor
@Data
public class SingerDetailVo {

    /**
     * 艺术家信息
     */
    private JSONObject artist;

    /**
     * 歌曲信息
     */
    private JSONObject songs;
}
