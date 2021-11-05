package com.wjh.common;

import lombok.Data;

/**
 * wx 小程序通用返回类
 *
 * @author wjh
 * @date 2021/11/4 2:08 下午
 */
@Data
public class Wx {
    private Integer code;
    /**
     * 返回给浏览器的数据
     */
    private Object data;

    public static Wx success() {
        Wx wx = new Wx();
        wx.setCode(200);
        return wx;
    }

    public static Wx fail() {
        Wx wx = new Wx();
        wx.setCode(404);
        return wx;
    }

    public Wx add(Object obj) {
        this.setData(obj);
        return this;
    }
}
