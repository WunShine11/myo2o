package com.wunshine.myo2o.service.impl;

import com.wunshine.myo2o.mapper.ChartsMapper;
import com.wunshine.myo2o.service.ChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChartsServiceImpl implements ChartsService {

    @Autowired
    private ChartsMapper chartsMapper;

    @Override
    public List<Map<String, Object>> getTop5Product(Map<String, String> map) {
        List<Map<String, Object>> top5Product = chartsMapper.getTopProduct(map);
        return top5Product;
    }
}
