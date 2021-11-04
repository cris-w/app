package com.wjh.service;

import com.wjh.common.Wx;
import com.wjh.entity.Admin;
import com.wjh.entity.Cart;
import com.wjh.entity.Gd;
import com.wjh.entity.Good;
import com.wjh.entity.Recommend;
import com.wjh.entity.Solider;
import java.util.List;

/**
 * @author wjh
 * @date 2021/11/4 9:25 下午
 */

public interface GoodsService {

    /**
     * 登录
     * @param admin
     * @return success or not
     */
    boolean login(Admin admin);

    /**
     * 获取所有商品
     * @return
     */
    List<Good> getGoods();

    /**
     * 获取所有轮播图
     * @return
     */
    List<Solider> getSolider();

    /**
     * 通过id获取推荐视屏
     * @param id
     * @return
     */
    Recommend getRecommend(String id);

    /**
     * 通过ID获取商品
     * @param id
     * @return
     */
    Good getGoodById(String id);

    /**
     * 通过Id获取推荐商品
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
     * 通过Id删除商品
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
     * 插入商品信息
     * @param good
     * @return
     */
    int insert(Good good);

    /**
     * 通过Id删除推荐商品
     * @param id
     * @return
     */
    int deleteGd(String id);

    /**
     * 更新推荐商品
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

    /**
     * 查看购物车
     * @return
     */
    List<Cart> lookCart();

    /**
     * 通过id 查询购物车中商品
     * @param id
     * @return
     */
    Cart getCartById(String id);

    /**
     * 插入商品购物车
     * @param cart
     * @return
     */
    int buy(Cart cart);

    /**
     * 更新购物车信息
     * @param cart
     * @return
     */
    int updateCart(Cart cart);

    /**
     * 逻辑购买
     * @param id
     * @return
     */
    int buy(String id);

    /**
     * 删除购物车信息
     * @param id
     * @return
     */
    int del(String id);

    /**
     * 支付
     * @return
     */
    Wx payment();
}
