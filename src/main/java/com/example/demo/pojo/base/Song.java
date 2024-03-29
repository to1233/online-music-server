package com.example.demo.pojo.base;

import lombok.Data;

@Data
public class Song {

    /**
     * 保存主键
     */
    private String id;


    /**
     * 歌曲url
     */
    private String url;

    /**
     * 封面图
     */
    private String pic;

    /**
     * 歌曲名称
     */
    private String songTitle;

    /**
     * 歌手名称
     */
    private String singerName;

    /**
     * 歌手id
     */
    private String singerId;

    /**
     * 歌曲来源
     */
    private String source;

    /**
     * 歌词
     */
    private String lyric;

    /**
     * 是否
     */
    private Boolean hoverFlag;


    /**
     * 专辑名称
     */
    private String album;

}
