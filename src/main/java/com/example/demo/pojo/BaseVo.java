package com.example.demo.pojo;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/20 11:45
 * @Description
 */
@Data
public class BaseVo {

    /**
     * 默认  返回总数量
     */
    private String total="true";

    /**
     * 页大小
     */
    private String  limit="15";

    /**
     * 数据偏移量
     */
    private String offset="0";

    private String type="1";

    private String csrf_token ="";
}
