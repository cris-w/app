package com.wjh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wjh
 */
@Data
@TableName("goods")
public class Good {
    private String id;
    private String title;
    private String description;
    private String image;
    private double price;
}
