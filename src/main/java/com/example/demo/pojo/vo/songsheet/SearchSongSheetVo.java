package com.example.demo.pojo.vo.songsheet;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/23 11:06
 * @Description
 */
@Data
public class SearchSongSheetVo {


    /**
     * 偏移量
     */
    private Integer offset = 0;

    /**
     * 排序类型
     */
    private String order = "host";

    /**
     * 页大小
     */
    private Integer limit = 20;

    /**
     * 歌单类型
     */
    private String cat = "全部歌单";

    private String csrf_token = "";
}
