package com.example.demo.pojo.vo.songsheet;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/23 14:45
 * @Description
 */
@Data
public class SearchSheetDetailVo {

    /**
     * 歌单id
     */
    private String id;

    /**
     * 歌单详情偏移量
     */
    private Integer offset = 0;

    /**
     * 总数
     */
    private boolean total = false;

    private Integer n = 20;

    private Integer limit = 20;

    private String csrf_token = "";

}
