package com.example.demo.pojo.vo.singer;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/24 11:41
 * @Description 热门歌手分页查询信息
 */
@Data
public class SearchSingerVo {

    private Integer offset = 0;

    private Boolean total = true;

    private Integer limit = 20;
}
