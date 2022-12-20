package com.example.demo.pojo.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SongHis {

    /**
     * 保存主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户主键
     */
    private Integer userId;

    /**
     * 歌曲信息id
     */
    private String songId;


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
     * 专辑名称
     */
    private String album;


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
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
