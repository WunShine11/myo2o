package com.wunshine.myo2o.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wunshine.myo2o.entity.LocalAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthMapper extends BaseMapper<LocalAuth> {
}
