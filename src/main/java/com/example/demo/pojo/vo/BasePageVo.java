package com.example.demo.pojo.vo;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/19 15:40
 * @Description
 */
@Data
public class BasePageVo {

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 页面大小
     */
    private Integer pageSize = 10;
}
