package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.SongSheetHisMapper;
import com.example.demo.pojo.base.SongHis;
import com.example.demo.pojo.base.SongSheetHis;
import com.example.demo.pojo.vo.PageVo;
import com.example.demo.pojo.vo.sys.SysUserSongPageVo;
import com.example.demo.service.ISongSheetHisService;
import org.springframework.stereotype.Service;

import static com.example.demo.constant.SysConstant.DbColumnKey.SONG_SHEET_ID;
import static com.example.demo.constant.SysConstant.DbColumnKey.USER_ID;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/19 16:49
 * @Description
 */
@Service
public class SongSheetHisServiceImpl extends ServiceImpl<SongSheetHisMapper, SongSheetHis> implements ISongSheetHisService {


    @Override
    public PageVo<SongSheetHis> findSongSheetHisListByUserPage(SysUserSongPageVo sysUserSongPageVo) {
        IPage<SongSheetHis> songHisListPage = page(new Page<>(sysUserSongPageVo.getPageNum(), sysUserSongPageVo.getPageSize()), new QueryWrapper<SongSheetHis>().eq(USER_ID, sysUserSongPageVo.getUserId()));
        return new PageVo<>(songHisListPage, songHisListPage.getRecords());
    }

    @Override
    public boolean deleteSongSheetHis(Integer userId, String songSheetId) {
        return getBaseMapper().delete(new QueryWrapper<SongSheetHis>().eq(USER_ID,userId).eq(SONG_SHEET_ID,songSheetId)) >0;
    }

}
