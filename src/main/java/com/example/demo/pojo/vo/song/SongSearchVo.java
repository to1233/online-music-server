package com.example.demo.pojo.vo.song;

import com.example.demo.pojo.BaseVo;
import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/19 15:49
 * @Description
 */
@Data
public class SongSearchVo extends BaseVo {

    /**
     * 搜索关键字
     */
    String s = "海阔天空";

    String  hlposttag = "</span>";

    String hlpretag = "<span class=\"s-fc7\">";
}
