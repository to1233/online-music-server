package com.example.demo.pojo.vo.song;

import com.example.demo.pojo.base.IdVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/21 9:47
 * @Description
 */
@AllArgsConstructor
@Data
public class SongSearchIdVo {

    private Integer id;

    // JSON.stringify([{id: id}])
    private String c;

    // [ id ]
    private List<Integer> ids;

    private String csrf_token ="";
}
