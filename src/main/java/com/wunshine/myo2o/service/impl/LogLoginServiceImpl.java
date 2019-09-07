package com.wunshine.myo2o.service.impl;

import com.wunshine.myo2o.entity.LogLogin;
import com.wunshine.myo2o.mapper.LogLoginMapper;
import com.wunshine.myo2o.service.LogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogLoginServiceImpl implements LogLoginService {

    @Autowired
    private LogLoginMapper logLoginMapper;
    @Override
    public void addLoginLog(LogLogin logLogin) {
        logLoginMapper.insert(logLogin);
    }
}
