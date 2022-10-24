package com.example.demo.pojo;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/20 11:43
 * @Description
 */
@Data
public class ParamVo {


    /**
     * 源参数
     */
    private String params;

    /**
     * 加密后的数据
     */
    private String encSecKey;

}
