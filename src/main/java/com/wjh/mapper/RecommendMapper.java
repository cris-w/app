package com.wjh.mapper;

import com.wjh.entity.Recommend;

/**
 * @author wjh
 * @date 2021/11/4 2:57 下午
 */
public interface RecommendMapper {

    /**
     * 通过Id 获取推荐视频
     * @param id id
     * @return recommend
     */
    Recommend getRecommendById(String id);
}
