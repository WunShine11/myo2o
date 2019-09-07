package com.wunshine.myo2o.controller;

import com.wunshine.myo2o.entity.PersonInfo;
import com.wunshine.myo2o.entity.Product;
import com.wunshine.myo2o.query.ProductQuery;
import com.wunshine.myo2o.service.ProductService;
import com.wunshine.myo2o.service.ShopService;
import com.wunshine.myo2o.utils.DataGridView;
import com.wunshine.myo2o.utils.ResultObj;
import com.wunshine.myo2o.utils.SysConstants;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("auth/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ShopService shopService;

    @RequestMapping("list2.html")
    public String list() {
        return "product/list2";
    }

    @RequestMapping("list")
    @ResponseBody
    public DataGridView productByPage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        return productService.getProducts(page, limit);

    }

    @RequestMapping("selectiveProduct")
    @ResponseBody
    public DataGridView selectiveProductByPage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                               @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                                               ProductQuery productQuery, HttpSession session) {
        //封装productQuery
        PersonInfo personInfo = (PersonInfo) session.getAttribute(SysConstants.SESSION_PERSONINFO);
        List<Integer> shopids = shopService.findShopsByUserId(personInfo);
        productQuery.setShopIds(shopids);
        return productService.getProducts(page, limit, productQuery);
    }

    @RequestMapping("changeStatus")
    @ResponseBody
    public Object changeProductStatus(Product product, String option) {
        System.out.println(product.getProductId() + "====" + option);
        try {
            if ("del".equals(option)) {
                product.setEnableStatus(2);
                productService.updateProductStatus(product);
                return ResultObj.DEL_SUCCESS;
            }
            if ("up".equals(option)) {
                product.setEnableStatus(0);
                productService.updateProductStatus(product);
                return ResultObj.UP_SUCCESS;
            }
            if ("down".equals(option)) {
                product.setEnableStatus(1);
                productService.updateProductStatus(product);
                return ResultObj.DOWN_SUCCESS;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.OPTION_FAILURE;
        }

        return ResultObj.OPTION_FAILURE;
    }

    @RequestMapping("updateProduct")
    public Object updateProduct(Product product) {
        try {
            productService.updateProduct(product);
            Integer id = product.getProductId();
            if (id == null) {
                return ResultObj.ADD_SUCCESS;
            } else {
                return ResultObj.UPDATE_SUCCESS;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultObj.OPTION_FAILURE;
    }
}
