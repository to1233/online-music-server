package com.example.demo.pojo.vo.song;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/20 14:38
 * @Description 返回前台的歌曲信息
 */
@Data
public class SongVo {

    private Integer id;

    private String name;

    private String artistName;

    private Integer artistId;

    private String albumName;

    private Integer albumId;

    private String source;

    private String sourceUrl;

    private String imgUrl;

    private String url;

    private Boolean disabled;



}
