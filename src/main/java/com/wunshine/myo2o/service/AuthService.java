package com.wunshine.myo2o.service;

import com.wunshine.myo2o.entity.LocalAuth;

public interface AuthService {
    public LocalAuth login(LocalAuth auth);

    public void regist(LocalAuth auth);
}
