package com.example.demo.pojo.vo.sys;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/7 13:30
 * @Description
 */
@Data
public class LoginVo {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 登录密码
     */
    private String password;

}
