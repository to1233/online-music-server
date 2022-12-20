package com.example.demo.pojo.vo.song.kuwo;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/24 19:31
 * @Description
 */
@Data
public class SongSearchPageVo {

    /**
     * 搜索关键词
     */
    private String keyWords = "周杰伦";

    /**
     * 当前页码
     */
    private Integer page = 1;
}
