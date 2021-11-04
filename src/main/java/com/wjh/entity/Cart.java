package com.wjh.entity;

import lombok.Data;

@Data
public class Cart {
    private String id;
    private String title;
    private String description;
    private String image;
    private double price;
    private int num;
}
