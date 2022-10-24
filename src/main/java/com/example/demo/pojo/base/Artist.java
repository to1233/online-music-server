package com.example.demo.pojo.base;

import lombok.Data;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/20 14:30
 * @Description 艺术家
 */
@Data
public class Artist {

    private Integer id;

    private String name;

    private String picUrl;

    private List<String> alias;

    private Integer albumSize;

    private Integer picId;

    private Integer fansGroup;

    private String img1v1Url;


}
