package com.example.demo.pojo.base;

import lombok.Data;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/20 14:34
 * @Description
 */
@Data
public class Album {

    private Integer id;

    private String name;

    private List<Artist> artists;

    private String publishTime;

    private Integer size;

    private Integer copyrightId;

    private Integer status;

    private String picId;



}
