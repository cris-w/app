package com.wjh.common;

import java.util.List;
import lombok.Data;

/**
 * 管理系统 通用返回类
 * @author wjh
 * @date 2021/11/4 2:08 下午
 */
@Data
public class Msg<T> {
    private Integer code;
    private List<T> data;
    private String mag;

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(0);
        msg.setMag(" ");
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(404);
        msg.setMag("fail");
        return msg;
    }

    public Msg<T> add(List<T> o) {
        this.setData(o);
        return this;
    }
}
