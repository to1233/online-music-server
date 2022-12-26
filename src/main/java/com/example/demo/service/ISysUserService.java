package com.example.demo.service;


import com.example.demo.pojo.base.SysUser;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 17:00
 * @Description 用户信息实体类
 */
public interface ISysUserService {

    /**
     * 通过token 去获取缓存中的用户信息
     * @param token token
     * @return SysUser 用户信息
     */
    SysUser getUserByToken(String token);

    /**
     * 将sysUser 内容保存到缓存中
     * @param token 信令
     * @param sysUser 用户信息
     */
    void saveToken(String token, SysUser sysUser);

    /**
     * 使用用户
     * @param phone
     * @return
     */
    SysUser findUserByPhone(String phone);

    /**
     * 根据用户名来查询用户信息
     * @param userName 用户名
     * @return SysUser 用户信息
     */
    SysUser findUserByUserName(String userName);


    /**
     * 根据用户信息创建出token
     *
     * @param user 目标用户信息
     * @return
     */
    String createToken(SysUser user);

    /**
     * 根据用户id来更新用户信息
     * @param sysUser 用户信息
     * @return boolean 更新结果
     */
    boolean updateUserById(SysUser sysUser);

    /**
     * 查询用户信息根据id
     * @param userId
     * @return
     */
    SysUser findUserById(Integer userId);

    /**
     * 根据用户id来注销用户信息
     * @param userId 用户主键
     */
    boolean cancelByUserId(Integer userId);


    /**
     * 校验密码
     * @param userId 用户id
     * @param password 密码
     * @return boolean 校验结果
     */
    boolean verifyPassword(Integer userId, String password);


    /**
     * 新增用户信息
     * @param sysUser 用户信息
     * @return boolean 是否新增成功
     */
    boolean insertUserInfo(SysUser sysUser);

    /**
     * 校验是否存在相同的邮箱
     * @param email 邮箱地址
     * @return
     */
    boolean existEmail(String email);

}
