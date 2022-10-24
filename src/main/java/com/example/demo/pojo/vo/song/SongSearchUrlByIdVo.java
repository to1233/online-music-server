package com.example.demo.pojo.vo.song;

import lombok.Data;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/21 13:32
 * @Description
 */
@Data
public class SongSearchUrlByIdVo {

    private List<Integer> ids;

    private Integer br = 128000;

    private String csrf_token = "";
}
