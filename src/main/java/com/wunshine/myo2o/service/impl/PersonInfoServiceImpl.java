package com.wunshine.myo2o.service.impl;

import com.wunshine.myo2o.entity.PersonInfo;
import com.wunshine.myo2o.mapper.PersonInfoMapper;
import com.wunshine.myo2o.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Override
    public PersonInfo findPersonInfoById(Integer id) {
        return personInfoMapper.selectById(id);
    }
    @Override
    public void insertPersonInfo(PersonInfo personInfo) {

        personInfoMapper.insert(personInfo);
    }
}
