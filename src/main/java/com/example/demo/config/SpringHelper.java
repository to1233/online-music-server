package com.example.demo.config;

import com.example.demo.pojo.base.SysUser;
import com.example.demo.utils.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/7 20:36
 * @Description
 */
public class SpringHelper {

    public static HttpServletRequest getCurrentRequest() {
        HttpServletRequest request = null;
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (null == requestAttributes) {
                return null;
            }
            request = ((ServletRequestAttributes) requestAttributes).getRequest();
        } catch (Exception e) {
            return request;
        }
        return request;
    }

    public static SysUser getLoginUser() {
        String authToken = getCurrentRequest().getHeader("AuthToken");
        return StringUtils.isBlank(authToken) ? null : JWTUtil.getUserInfo(authToken);
    }
}
