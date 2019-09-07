package com.wunshine.myo2o.query;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductQuery {
    private String id;
    private String productName;
    private String maxPrice;
    private String minPrice;
    private String startTime;
    private String endTime;
    private List<Integer> shopIds;
}
