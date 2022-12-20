package com.example.demo.pojo.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/7 13:37
 * @Description
 */
@Data
public class SysUser {

    /**
     * 用户主键
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像地址
     */
    private String avator;

    /**
     * 密码
     */
    private String password;

    /**
     * 账号创建时间
     */
    private Date createTime;

    /**
     * 个人用户简介
     */
    private String introduction;


    /**
     * 逻辑删除（1：已删除，0：未删除）
     */
    @TableLogic
    private Integer isDeleted;
}
