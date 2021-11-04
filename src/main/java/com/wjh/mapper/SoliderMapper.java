package com.wjh.mapper;

import com.wjh.entity.Solider;
import java.util.List;

/**
 * @author wjh
 * @date 2021/11/4 2:55 下午
 */
public interface SoliderMapper {

    /**
     * 获取所有滑动图片
     * @return
     */
    List<Solider> getSolider();
}
