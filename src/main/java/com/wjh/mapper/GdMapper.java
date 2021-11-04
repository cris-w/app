package com.wjh.mapper;

import com.wjh.entity.Gd;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author wjh
 * @date 2021/11/4 3:05 下午
 */
public interface GdMapper {

    /**
     * 通过ID获取对应推荐商品
     * @param id
     * @return
     */
    Gd getGdById(String id);

    /**
     * 获取所有推荐商品
     * @return
     */
    List<Gd> getGd();

    /**
     * 通过id删除详情
     * @param id
     * @return
     */
    int deleteGd(String id);

    /**
     * 修改推荐商品信息
     * @param gd
     * @return
     */
    int updateGd(Gd gd);

    /**
     * 增加推荐商品
     * @param gd
     * @return
     */
    int insertGd(Gd gd);
}
