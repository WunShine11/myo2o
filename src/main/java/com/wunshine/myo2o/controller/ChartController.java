package com.wunshine.myo2o.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth/chart")
public class ChartController {

    @RequestMapping("order.html")
    public String orderChart() {
        return "charts/order";
    }
}
