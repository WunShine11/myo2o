package com.wunshine.myo2o.utils;

import lombok.Data;

import java.util.List;

@Data
public class DataGridView<T> {
    private Integer code = 0;
    private String msg = "";
    private Long count;
    private List<T> data;
}
