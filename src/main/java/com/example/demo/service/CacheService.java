package com.example.demo.service;

import com.example.demo.constant.SysConstant;
import com.example.demo.pojo.base.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName CacheService
 * @Description 缓存信息
 * @Author zhangyang
 * @Date 2022/6/2 19:39
 * @Version 1.0
 */
@Slf4j
@Service
public class CacheService {


    @Cacheable(cacheNames = SysConstant.MANAGEMENT_AUTH, key = "#token")
    public SysUser getUserByToken(String token) {
        return null;
    }

    @CachePut(cacheNames = SysConstant.MANAGEMENT_AUTH, key = "#token")
    public SysUser cacheUserByToken(String token, SysUser user) {
        return user;
    }

    @CacheEvict(cacheNames = SysConstant.MANAGEMENT_AUTH, key = "#token")
    public void removeUserByToken(String token) {
        log.info("缓存移除:管理端token token={}", token);
    }


}
