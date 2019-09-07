package com.wunshine.myo2o.service;

import com.wunshine.myo2o.entity.Product;
import com.wunshine.myo2o.query.ProductQuery;
import com.wunshine.myo2o.utils.DataGridView;

public interface ProductService {
    DataGridView getProducts(Integer page, Integer limit);

    DataGridView getProducts(Integer page, Integer limit, ProductQuery productQuery);

    void updateProductStatus(Product product);

    void updateProduct(Product product);
}
