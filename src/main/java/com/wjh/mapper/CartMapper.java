package com.wjh.mapper;

import com.wjh.entity.Cart;
import java.util.List;

/**
 * @author wjh
 * @date 2021/11/4 2:26 下午
 */

public interface CartMapper{

    /**
     * 查看购物车的全部数据
     * @return
     */
    List<Cart> look();

    /**
     * 通过ID查询购物车商品
     * @param id
     * @return
     */
    Cart getCartById(String id);

    /**
     * 购买商品
     * @param cart
     * @return
     */
    int Buy(Cart cart);

    /**
     * 更新购物车信息
     * @param cart
     * @return
     */
    int updateCart(Cart cart);

    /**
     * 删除购物车记录
     * @param id
     * @return
     */
    int delById(String id);
}
