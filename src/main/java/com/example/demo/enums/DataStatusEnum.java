package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/17 16:41
 * @Description
 */
@AllArgsConstructor
public enum DataStatusEnum {

    USING(0,"正常"),
    NO_USING(1,"注销");

    /**
     * 用户状态标识
     */
    @Getter
    private Integer status;

    /**
     * 用户含义
     */
    @Getter
    private String label;
}
