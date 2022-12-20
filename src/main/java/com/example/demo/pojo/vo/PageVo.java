package com.example.demo.pojo.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/12/19 15:19
 * @Description
 */
@Data
public class PageVo<T> {

    /**
     * 数据总数
     */
    private Long total;

    /**
     * 总页数
     */
    private Long pages;

    private Long size;

    /**
     * 当前页码
     */
    private Long current;

    /**
     * 当前页记录数
     */
    private List<T> records;


    public PageVo(IPage<T> page) {
        this.total = page.getTotal();
        this.size = page.getSize();
        this.pages = page.getPages();
        this.records = page.getRecords();
    }

    public PageVo(IPage<?> page, List<T> records) {
        this.total = page.getTotal();
        this.size = page.getSize();
        this.current = page.getCurrent();
        this.records = records;
    }

    public PageVo(Long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

}
