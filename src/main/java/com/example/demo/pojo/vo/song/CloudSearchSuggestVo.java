package com.example.demo.pojo.vo.song;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/22 10:27
 * @Description 网易云智能搜索
 */
@Data
public class CloudSearchSuggestVo {

    /**
     * 搜索关键词
     */
    private String s = "海阔天空";

    /**
     * 搜索类型
     */
    private Integer type = 1;

    private String csrf_token = "";
}
