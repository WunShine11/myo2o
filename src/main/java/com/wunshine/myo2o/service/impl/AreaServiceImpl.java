package com.wunshine.myo2o.service.impl;

import com.wunshine.myo2o.entity.Area;
import com.wunshine.myo2o.mapper.AreaMapper;
import com.wunshine.myo2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public List<Area> getAll() {
        //return areaMapper.selectList(null);
        return areaMapper.getAll();
    }
}
