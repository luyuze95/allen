package com.luyuze.allen.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询出来的分页Page对象使用的VO类，支持自定义单体VO类
 * @param <T>
 * @param <K>
 */
public class PagingDozer<T, K> extends Paging {

    @SuppressWarnings("unchecked")
    public PagingDozer(Page<T> pageT, Class<K> classK) {
        super.initPageParameters(pageT);
        List<T> tList = pageT.getRecords();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> voList = new ArrayList<>();
        tList.forEach(t -> {
            K k = mapper.map(t, classK);
            voList.add(k);
        });
        this.setItems(voList);
    }
}
