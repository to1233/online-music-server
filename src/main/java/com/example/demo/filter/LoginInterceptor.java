package com.example.demo.filter;

import com.example.demo.common.AjaxResult;
import com.example.demo.enums.CodeEnum;
import com.example.demo.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/7 14:40
 * @Description
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }


        PrintWriter out = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        String token = request.getHeader("AuthToken");

        if(ObjectUtils.isEmpty(token)) {
            try {
                out = response.getWriter();
                out.append(AjaxResult.error(CodeEnum.NOT_LOGIN).toString());
                return  false;
            } catch (Exception ex) {
                log.error("校验登录失败");
                return false;
            }
        }


        try {
            boolean b = JWTUtil.verifyToken(token);
        } catch (Exception ex) {
            out = response.getWriter();
            out.append(AjaxResult.error(CodeEnum.NOT_LOGIN).toString());
            return  false;
        }

        return  true;
    }
}
