package com.wunshine.myo2o.service;

import com.wunshine.myo2o.entity.PersonInfo;

public interface PersonInfoService {
    PersonInfo findPersonInfoById(Integer id);

    void insertPersonInfo(PersonInfo personInfo);
}
