package com.wunshine.myo2o.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wunshine.myo2o.entity.LocalAuth;
import com.wunshine.myo2o.entity.PersonInfo;
import com.wunshine.myo2o.mapper.AuthMapper;
import com.wunshine.myo2o.service.AuthService;
import org.apache.catalina.User;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;

    @Override
    public LocalAuth login(LocalAuth auth) {
        QueryWrapper<LocalAuth> wrapper = new QueryWrapper<>(auth);
        return authMapper.selectOne(wrapper);
    }

    @Override
    public void regist(LocalAuth auth) {
        authMapper.insert(auth);
    }


}
