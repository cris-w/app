package com.wjh.controller;

import com.wjh.common.Wx;
import com.wjh.entity.*;
import com.wjh.service.GoodsService;
import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wjh
 */
@RestController
@CrossOrigin
@RequestMapping("/wx")
public class WxController {
    @Resource
    GoodsService goodsService;

    /**
     * 获取所有商品
     * @return
     */
    @RequestMapping("/getGoods")
    public Wx getGoods(){
        List<Good> goods = goodsService.getGoods();
        return Wx.success().add(goods);
    }

    /**
     * 获取所有solider
     * @return
     */
    @RequestMapping("/getSolider")
        public Wx getSolider(){
        List<Solider> solider = goodsService.getSolider();
        return Wx.success().add(solider);
    }

    /**
     * 通过id  获取指定推荐视屏
     * @param id
     * @return
     */
    @RequestMapping("/getRecommend")
    public Wx getRecommend(String id){
        Recommend recommend = goodsService.getRecommend(id);
        return Wx.success().add(recommend);
    }


    /**
     * 通过ID 获取商品
     * @param id
     * @return
     */
    @RequestMapping("/getGoodById")
    public Wx getGoodById(String id){
        Good goodById = goodsService.getGoodById(id);
        List<Good> goods = new ArrayList<>();
        goods.add(goodById);
        return Wx.success().add(goods);
    }

    /**
     * 通过ID 获取推荐商品
     * @param id
     * @return
     */
    @RequestMapping("/getGdById")
    public Wx getGdById(String id){
        return Wx.success().add(goodsService.getGdById(id));
    }

    /**
     * 直播
     * @return
     */
    @RequestMapping("/live")
    public Wx live(){
        return Wx.success().add("https://domain/pull_stream");
    }

    /**
     * 支付
     * @return
     */
    @RequestMapping("/payment")
    public Wx payment(){
        return goodsService.payment();
    }

    /**
     * 查看购物车
     * @return
     */
    @RequestMapping("/Look")
    public Wx look(){
        return Wx.success().add(goodsService.lookCart());
    }

    /* 通过Id 获取购物车数据
    public cart getCartById(String id){
        return service.getCartById(id);
    }*/

    /**
     * 购买商品
     * @param id
     * @return
     */
    @RequestMapping("/buy")
    public int buy(String id){
        return goodsService.buy(id);
    }

    /**
     * 删除购物车记录
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public int del(String id){
        return goodsService.del(id);
    }
}
