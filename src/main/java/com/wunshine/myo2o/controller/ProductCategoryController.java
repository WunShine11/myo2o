package com.wunshine.myo2o.controller;

import com.wunshine.myo2o.entity.ProductCategory;
import com.wunshine.myo2o.service.ProductCagegoryService;
import com.wunshine.myo2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("auth/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCagegoryService productCagegoryService;
    @RequestMapping("list")
    @ResponseBody
    public Object categoryList() {
        List<ProductCategory> all = productCagegoryService.findAll();
        return all;
    }
}
