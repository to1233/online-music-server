package com.example.demo.pojo.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/19 16:44
 * @Description
 */
@Data
public class SongSheetHis {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 歌单名称
     */
    private String name;

    /**
     * 歌单id
     */
    private String songSheetId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 收藏时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date collectTime;
}
