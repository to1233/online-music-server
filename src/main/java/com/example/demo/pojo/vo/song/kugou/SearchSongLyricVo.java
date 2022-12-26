package com.example.demo.pojo.vo.song.kugou;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/25 12:17
 * @Description
 */
@Data
public class SearchSongLyricVo {

    /**
     * 歌曲id
     */
    private String songId;

    /**
     * 专辑id
     */
    private String albumId;
}
