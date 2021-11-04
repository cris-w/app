package com.wjh.entity;

import lombok.Data;

@Data
public class Pay {
    private String nonceStr;
    private String pack;
    private String paySign;
    private String timeStamp;
}
