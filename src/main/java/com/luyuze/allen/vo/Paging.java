package com.luyuze.allen.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 查询出来的分页Page对象使用的VO类
 * @param <T>
 */
@Getter
@Setter
@NoArgsConstructor
public class Paging<T> {

    private Long total;
    private Long count;
    private Long page;
    private Long totalPage;
    private List<T> items;

    public Paging(Page<T> pageT) {
        this.initPageParameters(pageT);
        this.items = pageT.getRecords();
    }

    void initPageParameters(Page<T> pageT) {
        this.total = pageT.getTotal();
        this.count = pageT.getSize();
        this.page = pageT.getCurrent();
        this.totalPage = pageT.getPages();
    }
}
