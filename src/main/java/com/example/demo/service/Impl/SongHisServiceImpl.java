package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.SongHisMapper;
import com.example.demo.pojo.base.Song;
import com.example.demo.pojo.base.SongHis;
import com.example.demo.pojo.base.SongSheetHis;
import com.example.demo.pojo.vo.PageVo;
import com.example.demo.pojo.vo.sys.SysUserSongPageVo;
import com.example.demo.service.ISongHisService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.constant.SysConstant.DbColumnKey.SONG_ID;
import static com.example.demo.constant.SysConstant.DbColumnKey.USER_ID;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/7 21:05
 * @Description
 */
@Service
public class SongHisServiceImpl extends ServiceImpl<SongHisMapper, SongHis> implements ISongHisService {


    @Override
    public PageVo<Song> findSongHisListByUserIdPage(SysUserSongPageVo sysUserSongPageVo) {
        IPage<SongHis> songHisListPage = page(new Page<>(sysUserSongPageVo.getPageNum(), sysUserSongPageVo.getPageSize()), new QueryWrapper<SongHis>().eq(USER_ID, sysUserSongPageVo.getUserId()));
        List<Song> songList = songHisListPage.getRecords().stream().map(item -> {
            Song song = new Song();
            BeanUtils.copyProperties(item, song);
            song.setId(item.getSongId());
            return song;
        }).collect(Collectors.toList());
        return new PageVo<>(songHisListPage, songList);
    }

    @Override
    public boolean deleteSongHis(Integer userId, String songId) {
        return getBaseMapper().delete(new QueryWrapper<SongHis>().eq(USER_ID, userId).eq(SONG_ID, songId)) > 0;
    }


}
