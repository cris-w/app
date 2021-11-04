package com.wjh.controller;

import com.wjh.common.Msg;
import com.wjh.entity.*;
import com.wjh.service.GoodsService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Lay")
public class LayController {
    @Resource
    GoodsService service;

    @RequestMapping("/login")
    public boolean login (Admin admin){
        return service.login(admin);
    }

    /**
     * 获取所有商品
     * @return
     */
    @RequestMapping("/getGoods")
    public Msg getGoods(){
        return Msg.success().add(service.getGoods());
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public int delete(String id){
        return service.delete(id);
    }

    /**
     * 修改商品信息
     * @param good
     * @return
     */
    @PutMapping("/update")
    public int update(@RequestBody Good good){
        return service.update(good);
    }

    /**
     * 增加商品
     * @param good
     * @return
     */
    @PostMapping("/insert")
    public int insert(@RequestBody Good good){
        if(service.getGoodById(good.getId()) == null) {
            return service.insert(good);
        }
        return 0;
    }

    /**
     * 获取商品详细信息
     * @param id
     * @return
     */
    @GetMapping("/getGdById")
    public Msg getGdById(String id){
        List<Gd> list = new ArrayList<>();
        Gd gd= service.getGdById(id);
        list.add(gd);
        return Msg.success().add(list);
    }

    /**
     * 获取所有商品详细信息
     * @return
     */
    @GetMapping("/getGd")
    public Msg getGd(){
        return Msg.success().add(service.getGd());
    }

    /**
     * 增加商品详情
     * @param gd
     * @return
     */
    @PostMapping("/insertGd")
    public int insertGd(@RequestBody Gd gd){
        if (service.getGdById(gd.getId()) == null){
            return service.insertGd(gd);
        }
        return 0;
    }

    /**
     * 删除商品详情
     * @param id
     * @return
     */
    @RequestMapping("/deleteGd")
    public int deleteGd(String id){
        return service.deleteGd(id);
    }

    /**
     * 修改商品详情
     * @param gd
     * @return
     */
    @PutMapping("/updateGd")
    public int updateGd (@RequestBody Gd gd){
        return service.updateGd(gd);
    }

    /**
     * 查看订单信息
     * @return
     */
    @GetMapping("/getAll")
    public Msg getAll(){
        List<Cart> look = service.lookCart();
        return Msg.success().add(look);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/Do")
    public int del(String id){
        return service.del(id);
    }
}
