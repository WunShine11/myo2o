package com.wunshine.myo2o.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.wunshine.myo2o.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper extends BaseMapper<Area> {

    List<Area> getAll();
}
