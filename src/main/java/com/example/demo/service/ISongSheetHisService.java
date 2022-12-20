package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.base.SongSheetHis;
import com.example.demo.pojo.vo.PageVo;
import com.example.demo.pojo.vo.sys.SysUserSongPageVo;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/19 16:48
 * @Description
 */
public interface ISongSheetHisService extends IService<SongSheetHis> {


    /**
     * 根据用户信息id来查询用户收藏的歌单信息
     * @param sysUserSongPageVo 用户分页查询
     * @return Page
     */
    PageVo<SongSheetHis> findSongSheetHisListByUserPage(SysUserSongPageVo sysUserSongPageVo);

    /**
     * 移除用户收藏的歌单id
     * @param userId 用户id
     * @param songSheetId 歌单id
     * @return
     */
    boolean deleteSongSheetHis(Integer userId,String songSheetId);
}
