package com.wjh.service.impl;

import com.wjh.common.Wx;
import com.wjh.entity.Admin;
import com.wjh.entity.Cart;
import com.wjh.entity.Gd;
import com.wjh.entity.Good;
import com.wjh.entity.Pay;
import com.wjh.entity.Recommend;
import com.wjh.entity.Solider;
import com.wjh.mapper.AdminMapper;
import com.wjh.mapper.CartMapper;
import com.wjh.mapper.GdMapper;
import com.wjh.mapper.GoodsMapper;
import com.wjh.mapper.RecommendMapper;
import com.wjh.mapper.SoliderMapper;
import com.wjh.service.GoodsService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wjh
 * @date 2021/11/4 2:29 下午
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    AdminMapper adminMapper;
    @Resource
    GoodsMapper goodsMapper;
    @Resource
    SoliderMapper soliderMapper;
    @Resource
    RecommendMapper recommendMapper;
    @Resource
    GdMapper gdMapper;
    @Resource
    CartMapper cartMapper;

    @Override
    public boolean login(Admin admin) {
        Admin login = adminMapper.login(admin);
        return login != null;
    }

    @Override
    public List<Good> getGoods() {
        return goodsMapper.getGoods();
    }

    @Override
    public List<Solider> getSolider() {
        return soliderMapper.getSolider();
    }

    @Override
    public Recommend getRecommend(String id) {
        return recommendMapper.getRecommendById(id);
    }

    @Override
    public Good getGoodById(String id) {
        return goodsMapper.getGoodById(id);
    }

    @Override
    public Gd getGdById(String id) {
        return gdMapper.getGdById(id);
    }

    @Override
    public List<Gd> getGd() {
        return gdMapper.getGd();
    }

    @Override
    public int delete(String id) {
        return goodsMapper.delete(id);
    }

    @Override
    public int update(Good good) {
        return goodsMapper.update(good);
    }

    @Override
    public int insert(Good good) {
        return goodsMapper.insert(good);
    }

    @Override
    public int deleteGd(String id) {
        return gdMapper.deleteGd(id);
    }

    @Override
    public int updateGd(Gd gd) {
        return gdMapper.updateGd(gd);
    }

    @Override
    public int insertGd(Gd gd) {
        return gdMapper.insertGd(gd);
    }

    @Override
    public List<Cart> lookCart() {
        return cartMapper.look();
    }

    @Override
    public Cart getCartById(String id) {
        return cartMapper.getCartById(id);
    }

    @Override
    public int buy(Cart cart) {
        return cartMapper.Buy(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateCart(cart);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int buy(String id) {
        Cart cartById = getCartById(id);
        if (cartById == null){
            int num = 1;
            Good good = getGoodById(id);
            Cart cart = new Cart();
            // 将商品信息加入购物车
            cart.setId(good.getId());
            cart.setDescription(good.getDescription());
            cart.setImage(good.getImage());
            cart.setPrice(good.getPrice());
            cart.setTitle(good.getTitle());
            cart.setNum(num);
            return buy(cart);
        }else {
            int num = cartById.getNum();
            cartById.setNum(num+1);
            cartById.setPrice((cartById.getPrice() / num) * (num+1));
            return updateCart(cartById);
        }
    }

    @Override
    public int del(String id) {
        return cartMapper.delById(id);
    }

    @Override
    public Wx payment() {
        Pay pay = new Pay();
        pay.setNonceStr("qwer");
        pay.setPack("prepay_id=***");
        pay.setPaySign("wjh");
        pay.setTimeStamp(String.valueOf(System.currentTimeMillis()));
        return Wx.success().add(pay);
    }
}
