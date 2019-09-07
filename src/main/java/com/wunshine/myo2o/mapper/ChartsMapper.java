package com.wunshine.myo2o.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Repository
public interface ChartsMapper {
    List<Map<String, Object>> getTopProduct(Map<String, String> map);
}
