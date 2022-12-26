package com.example.demo.pojo.vo.song;

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

    private String id;

    // JSON.stringify([{id: id}])
    private String c;

    // [ id ]
    private List<String> ids;

    private String csrf_token ="";
}
