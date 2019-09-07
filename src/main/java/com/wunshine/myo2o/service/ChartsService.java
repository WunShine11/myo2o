package com.wunshine.myo2o.service;

import java.util.List;
import java.util.Map;

public interface ChartsService {
    List<Map<String, Object>> getTop5Product(Map<String, String> map);
}
