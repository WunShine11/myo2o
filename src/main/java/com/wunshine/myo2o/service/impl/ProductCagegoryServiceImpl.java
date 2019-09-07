package com.wunshine.myo2o.service.impl;

import com.wunshine.myo2o.entity.ProductCategory;
import com.wunshine.myo2o.mapper.ProductCagegoryMapper;
import com.wunshine.myo2o.service.ProductCagegoryService;
import com.wunshine.myo2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCagegoryServiceImpl implements ProductCagegoryService {
    @Autowired
    private ProductCagegoryMapper productCagegoryMapper;

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> categories = productCagegoryMapper.selectList(null);
        return categories;
    }
}
