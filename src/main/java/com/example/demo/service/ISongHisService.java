package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.base.Song;
import com.example.demo.pojo.base.SongHis;
import com.example.demo.pojo.base.SongSheetHis;
import com.example.demo.pojo.vo.PageVo;
import com.example.demo.pojo.vo.sys.SysUserSongPageVo;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/7 21:02
 * @Description
 */
public interface ISongHisService extends IService<SongHis> {

    /**
     * 根据用户信息id来查询用户收藏的歌曲信息
     * @param sysUserSongPageVo 用户分页查询
     * @return Page
     */
    PageVo<Song> findSongHisListByUserIdPage(SysUserSongPageVo sysUserSongPageVo);


    /**
     * 根据当前登录的用户id以及歌曲id来查询
     * @param userId 当前登录的用户id
     * @param songId 歌曲id
     */
    boolean deleteSongHis(Integer userId,String songId);


}
