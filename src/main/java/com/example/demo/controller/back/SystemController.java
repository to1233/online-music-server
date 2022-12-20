package com.example.demo.controller.back;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.annotations.LoginUser;
import com.example.demo.common.AjaxResult;
import com.example.demo.enums.CodeEnum;
import com.example.demo.pojo.base.Song;
import com.example.demo.pojo.base.SongHis;
import com.example.demo.pojo.base.SongSheetHis;
import com.example.demo.pojo.base.SysUser;
import com.example.demo.pojo.vo.sys.*;
import com.example.demo.service.ISongHisService;
import com.example.demo.service.ISongSheetHisService;
import com.example.demo.service.ISysUserService;
import com.example.demo.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.constant.SysConstant.DbColumnKey.*;


/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/7 12:02
 * @Description 处理用户登录
 */
@Slf4j
@RestController
@RequestMapping("/sys")
public class SystemController {

    @Resource
    private ISysUserService iSysUserService;

    /**
     * 登录信息
     *
     * @param loginVo
     * @return
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginVo loginVo) {
        SysUser sysUser = iSysUserService.findUserByPhone(loginVo.getPhone());
        // 核验密码
        if (sysUser == null) {
            return AjaxResult.error(CodeEnum.NOT_PHONE);
        }
        if (checkPassword(sysUser, loginVo.getPassword())) {
            LoginSuccessVo loginSuccessVo = new LoginSuccessVo();
            BeanUtils.copyProperties(sysUser, loginSuccessVo);
            String token = JWTUtil.createToken(sysUser);
            loginSuccessVo.setToken(token);
            loginSuccessVo.setUserId(sysUser.getId());
            iSysUserService.updateUserById(sysUser);
            return AjaxResult.success("登录成功", loginSuccessVo);
        } else {
            log.warn("登录失败，密码错误 手机号：{}，原始密码:{}", loginVo.getPhone(), sysUser.getPassword());
            return AjaxResult.error(CodeEnum.LOGIN_FAIL);
        }

    }

    @Resource
    private ISongHisService iSongHisService;

    @Resource
    private ISongSheetHisService iSongSheetHisService;

    @PostMapping("/saveUserSongInfo")
    public AjaxResult saveUserSongInfo(@LoginUser SysUser userVo, @RequestBody Song song) {
        if (userVo == null) {
            return AjaxResult.error(CodeEnum.NOT_LOGIN);
        }
        SongHis songHis = new SongHis();
        BeanUtils.copyProperties(song, songHis);
        songHis.setUserId(userVo.getId());
        songHis.setSongId(song.getId());
        songHis.setCreateTime(new Date());
        // 查询歌曲id是否存在
        Integer existCount = iSongHisService.count(new QueryWrapper<SongHis>().eq(SONG_ID, songHis.getSongId()).eq(USER_ID, userVo.getId()));
        if (existCount <= 0) {
            iSongHisService.save(songHis);
        }
        return AjaxResult.success();
    }



    @PostMapping("/saveUserTempPlayList")
    public AjaxResult saveUserTempPlayList(@LoginUser SysUser userVo, @RequestBody List<Song> songList) {
        if (userVo == null) {
            return AjaxResult.error(CodeEnum.NOT_LOGIN);
        }
        List<SongHis> songHisList = songList.stream().map(item -> {
            SongHis songHis = new SongHis();
            BeanUtils.copyProperties(item, songHis);
            songHis.setUserId(userVo.getId());
            songHis.setSongId(item.getId());
            songHis.setCreateTime(new Date());
            return songHis;
        }).collect(Collectors.toList());
        for (SongHis songHis : songHisList) {
            // 查询歌曲id是否存在
            Integer existCount = iSongHisService.count(new QueryWrapper<SongHis>().eq(SONG_ID, songHis.getSongId()).eq(USER_ID, userVo.getId()));
            if (existCount <= 0) {
                iSongHisService.save(songHis);
            }
        }
        return AjaxResult.success();
    }

    @PostMapping("/saveUserSongSheet")
    public AjaxResult saveUserSongSheet(@LoginUser SysUser userVo, @RequestBody SongSheetVo songSheetVo) {
        if (userVo == null) {
            return AjaxResult.error(CodeEnum.NOT_LOGIN);
        }
        SongSheetHis songSheetHis = new SongSheetHis();
        songSheetHis.setName(songSheetVo.getName());
        songSheetHis.setSongSheetId(songSheetVo.getSongSheetId());
        songSheetHis.setUserId(userVo.getId());
        songSheetHis.setCollectTime(new Date());
        // 查询歌曲id是否存在
        Integer existCount = iSongSheetHisService.count(new QueryWrapper<SongSheetHis>().eq(SONG_SHEET_ID, songSheetHis.getSongSheetId()).eq(USER_ID, userVo.getId()));
        if (existCount <= 0) {
            iSongSheetHisService.save(songSheetHis);
        }
        return AjaxResult.success();
    }


    /**
     * 查询该用户下的收藏的歌曲信息
     *
     * @param sysUserSongPageVo 分页查询用户收藏歌曲信息
     * @return List<Song>
     */
    @PostMapping("/getCollectInfoSong")
    public AjaxResult getCollectInfo(@RequestBody SysUserSongPageVo sysUserSongPageVo) {
        return AjaxResult.ajaxResult(iSongHisService.findSongHisListByUserIdPage(sysUserSongPageVo));
    }


    @DeleteMapping("/deleteCollectSong/{songId}")
    public AjaxResult deleteCollectSong(@LoginUser SysUser userVo, @PathVariable("songId") String songId) {
        return AjaxResult.ajaxResult(iSongHisService.deleteSongHis(userVo.getId(), songId));
    }


    @DeleteMapping("/deleteCollectSongSheet/{songSheetId}")
    public AjaxResult deleteCollectSongSheet(@LoginUser SysUser userVo, @PathVariable("songSheetId") String songSheetId) {
        return AjaxResult.ajaxResult(iSongSheetHisService.deleteSongSheetHis(userVo.getId(), songSheetId));
    }


    /**
     * 查询该用户下的收藏的歌单信息
     *
     * @param sysUserSongPageVo 分页查询用户收藏歌单信息
     * @return List<Song>
     */
    @PostMapping("/getCollectInfoSongSheet")
    public AjaxResult getCollectInfoSongSheet(@RequestBody SysUserSongPageVo sysUserSongPageVo) {
        return AjaxResult.ajaxResult(iSongSheetHisService.findSongSheetHisListByUserPage(sysUserSongPageVo));
    }


    /**
     * 更新用户信息
     *
     * @param sysUser 更新后的用户信息
     * @return
     */
    @PostMapping("/updateUserInfo")
    public AjaxResult findUpdateUserInfo(@RequestBody SysUser sysUser) {
        return AjaxResult.ajaxResult(iSysUserService.updateUserById(sysUser));
    }


    /**
     * 查询用户详情Id
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/detail/{userId}")
    public AjaxResult userDetailById(@PathVariable("userId") Integer userId) {
        return AjaxResult.ajaxResult(iSysUserService.findUserById(userId));
    }


    /**
     * 更新用户信息
     *
     * @param sysUser 用户信息
     * @return
     */
    @PostMapping("/updateUserMsg")
    public AjaxResult updateUserMsg(@RequestBody SysUser sysUser) {
        return AjaxResult.ajaxResult(iSysUserService.updateUserById(sysUser));
    }

    /**
     * 更新用户密码
     *
     * @param sysUserPasswordVo 更新密码对象
     * @return
     */
    @PostMapping("/updateUserPassword")
    public AjaxResult updatePassword(@RequestBody SysUserPasswordVo sysUserPasswordVo) {
        boolean res = iSysUserService.verifyPassword(sysUserPasswordVo.getUserId(), sysUserPasswordVo.getOldPassword());
        if (!res) {
            return AjaxResult.error(CodeEnum.PASSWORD_ERROR);
        }
        SysUser sysUser = new SysUser();
        sysUser.setId(sysUserPasswordVo.getUserId());
        sysUser.setPassword(sysUserPasswordVo.getNewPassword());
        return AjaxResult.ajaxResult(iSysUserService.updateUserById(sysUser));
    }

    /**
     * 注销当前用户
     *
     * @param userVo 当前登录用户信息
     * @param userId 用户id
     * @return AjaxResult
     */
    @PostMapping("/deleteUser/{userId}")
    public AjaxResult deleteUser(@LoginUser SysUser userVo, @PathVariable("userId") Integer userId) {
        if (userVo.getId() != userId) {
            return AjaxResult.error(CodeEnum.LOGIN_ID_COMPARE);
        }
        return AjaxResult.ajaxResult(iSysUserService.cancelByUserId(userId));
    }


    /**
     * 注册对应的用户信息
     *
     * @param sysUser 用户信息
     * @return
     */
    @PostMapping("/register")
    public AjaxResult signUp(@RequestBody SysUser sysUser) {
        iSysUserService.insertUserInfo(sysUser);
        // 注册成功之后返回对应的token
        return AjaxResult.success();
    }


    /**
     * 校验密码
     *
     * @param user     数据库用户信息
     * @param password 登录传输的加密的MD5信息
     * @return 是否相同
     */
    private boolean checkPassword(SysUser user, String password) {
        return password.equals(user.getPassword());
    }
}
