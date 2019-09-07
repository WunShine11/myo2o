package com.wunshine.myo2o.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class Product {
    @TableId(value = "product_id",type = IdType.AUTO)
    private Integer productId;

    private String productName;

    private String productDesc;

    private String imgAddr;

    private String normalPrice;

    private String promotionPrice;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    private Integer enableStatus;

    private Integer point;

    private Integer productCategoryId;

    private Integer shopId;


}