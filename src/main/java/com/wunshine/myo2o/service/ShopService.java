package com.wunshine.myo2o.service;

import com.wunshine.myo2o.entity.LocalAuth;
import com.wunshine.myo2o.entity.PersonInfo;

import java.util.List;

public interface ShopService {
    List<Integer> findShopsByUserId(PersonInfo personInfo);
}
