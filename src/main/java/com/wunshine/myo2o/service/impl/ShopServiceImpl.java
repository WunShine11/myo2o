package com.wunshine.myo2o.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wunshine.myo2o.entity.LocalAuth;
import com.wunshine.myo2o.entity.PersonInfo;
import com.wunshine.myo2o.entity.Shop;
import com.wunshine.myo2o.mapper.ShopMapper;
import com.wunshine.myo2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Override

    public List<Integer> findShopsByUserId(PersonInfo personInfo) {
        QueryWrapper<Shop> wrapper = new QueryWrapper<>();
        wrapper.eq("owner_id", personInfo.getUserId());
        List<Shop> shops = shopMapper.selectList(wrapper);
        ArrayList<Integer> shopids = new ArrayList<>();
        for (Shop shop:shops ) {
            shopids.add(shop.getShopId());
        }
        return shopids;
    }
}
