package com.wjh.mapper;

import com.wjh.entity.Good;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author wjh
 * @date 2021/11/4 2:50 下午
 */
public interface GoodsMapper {

    /**
     * 获取所有商品
     * @return
     */
    List<Good> getGoods();

    /**
     * 通过ID 获取商品
     * @param id id
     * @return good
     */
    Good getGoodById( String id);

    /**
     * 通过id 删除商品
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改商品信息
     * @param good
     * @return
     */
    int update(Good good);

    /**
     * 增加商品
     * @param good
     * @return
     */
    int insert(Good good);
}
