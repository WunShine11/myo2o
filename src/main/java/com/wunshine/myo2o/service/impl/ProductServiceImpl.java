package com.wunshine.myo2o.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.wunshine.myo2o.entity.Product;
import com.wunshine.myo2o.mapper.ProductMapper;
import com.wunshine.myo2o.query.ProductQuery;
import com.wunshine.myo2o.service.ProductService;
import com.wunshine.myo2o.utils.DataGridView;
import com.wunshine.myo2o.utils.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public DataGridView getProducts(Integer page, Integer limit) {
        //pageHelper分页查询
        PageHelper.startPage(page, limit);
        List<Product> products = productMapper.selectList(null);
        PageInfo<Product> PageInfo = new PageInfo<>(products);
        //返回合适的Json类
        DataGridView<Product> dgv = new DataGridView<>();
        dgv.setCount(PageInfo.getTotal());
        dgv.setData(PageInfo.getList());
        //System.out.println(PageInfo.getList()+"===================");
        return dgv;
    }

    @Override
    public DataGridView getProducts(Integer page, Integer limit, ProductQuery productQuery) {

        System.out.println(productQuery);
        //pageHelper分页查询
        PageHelper.startPage(page, limit);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        if (StringUtil.isNotEmpty(productQuery.getId())) {
            wrapper.eq("product_id", productQuery.getId());
        }
        if (StringUtil.isNotEmpty(productQuery.getProductName())) {
            wrapper.like("product_name", productQuery.getProductName());
        }
        if (StringUtil.isNotEmpty(productQuery.getMinPrice())&&StringUtil.isNotEmpty(productQuery.getMaxPrice())) {
            wrapper.between("promotion_price", productQuery.getMinPrice(),productQuery.getMaxPrice());
        }

        if (StringUtil.isNotEmpty(productQuery.getStartTime())) {
            wrapper.gt("create_time", productQuery.getStartTime());
        }
        if (StringUtil.isNotEmpty(productQuery.getEndTime())) {
            wrapper.lt("create_time", productQuery.getEndTime());
        }
        wrapper.in("shop_id", productQuery.getShopIds());
        wrapper.in("enable_status", 0, 1);
        List<Product> products = productMapper.selectList(wrapper);
        PageInfo<Product> pageInfo = new PageInfo<>(products);

        System.out.println(pageInfo);
        //返回合适的Json类
        DataGridView<Product> dgv = new DataGridView<>();
        dgv.setCount(pageInfo.getTotal());
        dgv.setData(pageInfo.getList());

        return dgv;
    }

    @Override
    public void updateProductStatus(Product product) {
        UpdateWrapper<Product> wrapper = new UpdateWrapper<>();
        wrapper.eq("product_id", product.getProductId());
        productMapper.update(product,wrapper);
    }
    @Override
    public void updateProduct(Product product) {
        UpdateWrapper<Product> wrapper = new UpdateWrapper<>();
        if (product.getProductId() != null) {
            wrapper.eq("product_id", product.getProductId());
        }
        productMapper.update(product,wrapper);
    }
}
