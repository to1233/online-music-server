package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName CodeEnum
 * @Description 返回码枚举
 * @Author zhangyang
 * @Date 2022/6/1 11:55
 * @Version 1.0
 */
@AllArgsConstructor
public enum CodeEnum {

    /**
     * 接口返回码--处理成功
     */
    SUCCESS(200, "成功"),

    /**
     * 内部异常
     */
    ERROR(-500, "服务器内部错误"),


    /**
     * 业务处理失败
     */
    DB_ERROR(1000, "数据库操作失败"),
    LOGIN_FAIL(1001, "密码不正确"),
    NOT_LOGIN(401, "用户未登录"),
    PASSWORD_ERROR(402,"密码错误"),
    INSERT_FAIL(1002,"新增异常"),
    DELETE_FAIL(1003,"删除异常"),
    LIKE_FAIL(1004,"点赞失败"),
    UPDATE_FAIL(1005,"更新异常"),
    NOT_USER_NAME(1006,"用户名不存在"),
    NOT_PHONE(1007,"手机号不存在"),
    LOGIN_ID_COMPARE(1008,"当前登录人员不匹配"),
    EMAIL_EXIST(1009,"邮箱已经存在");

    @Getter
    private final Integer code;
    @Getter
    private final String msg;
}
