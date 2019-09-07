package com.wunshine.myo2o.controller;

import com.wunshine.myo2o.entity.Area;
import com.wunshine.myo2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("shop/area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping("list")
    @ResponseBody
    public Object getAreas() {
        return areaService.getAll();
    }
}
