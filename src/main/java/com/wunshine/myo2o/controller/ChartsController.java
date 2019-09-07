package com.wunshine.myo2o.controller;

import com.wunshine.myo2o.service.ChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("charts")
public class ChartsController {
    @Autowired
    private ChartsService chartsService;

    @GetMapping("top5Product")
    @ResponseBody
    public Object top5Product(@RequestParam(value = "month",required = false)String month,
                              @RequestParam(value = "startTime",required = false)String startTime,
                              @RequestParam(value = "endTime",required = false)String endTime ) {

        HashMap<String, String> map = new HashMap<>();
        map.put("month",month);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        return chartsService.getTop5Product(map);
    }
}
