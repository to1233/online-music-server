package com.example.demo.config;

import com.example.demo.constant.SysConstant;
import com.example.demo.filter.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @ClassName SysConfig
 * @Description 跨域配置类
 * @Author zhangyang
 * @Date 2022/5/29 17:41
 * @Version 1.0
 */
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    @Bean
    LoginInterceptor getInInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginUserHandlerMethodArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInInterceptor())
                //设置拦截路径，我是全部拦截，根据自己项目配置
                .addPathPatterns("/sys/userInfo");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/avatorImages/**")
                .addResourceLocations(SysConstant.AVATOR_IMAGES_PATH);
    }

    /**
     * 乱码处理
     */
    public HttpMessageConverter<String> responseBodyConverter() {
        final StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converter.setWriteAcceptCharset(false);
        return converter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        if (converters.size() > 0) {
            converters.add(converters.get(0));
            converters.set(0, responseBodyConverter());
        } else {
            converters.add(responseBodyConverter());
        }
    }
}
