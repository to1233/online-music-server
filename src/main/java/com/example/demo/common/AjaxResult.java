package com.example.demo.common;


import com.example.demo.enums.CodeEnum;

import java.util.HashMap;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 16:20
 * @Description 返回结果类
 */
public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 返回的状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回的内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的AjaxResult 对象
     */
    public AjaxResult() {

    }

    /**
     * 初始化一个新创建的AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回的内容
     */
    public AjaxResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);

    }

    /**
     * 初始化一个新创建的AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回的内容
     */
    public AjaxResult(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }

    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg, null);
    }

    public static AjaxResult ajaxResult(Object data) {
        return AjaxResult.success("操作成功", data);
    }

    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(200, msg, data);
    }

    public static AjaxResult error() {
        return AjaxResult.error("操作失败", null);
    }

    public static AjaxResult error(String msg, Object data) {
        return new AjaxResult(500, msg, data);
    }

    public static AjaxResult error(CodeEnum codeEnum) {
        return new AjaxResult(codeEnum.getCode(),codeEnum.getMsg());
    }

    public static AjaxResult error(int code,String msg) {
        return new AjaxResult(code,msg);
    }



}
