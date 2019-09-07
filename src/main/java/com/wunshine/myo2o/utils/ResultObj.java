package com.wunshine.myo2o.utils;

import lombok.Data;

@Data
public class ResultObj {


    private Integer optionCode ;
    private String msg;

    public ResultObj(Integer optionCode) {
        this.optionCode = optionCode;
    }

    public ResultObj(Integer optionCode, String msg) {
        this.optionCode = optionCode;
        this.msg = msg;
    }

    public static final Object OPTION_FAILURE = new ResultObj(SysConstants.CODE_FAILER,SysConstants.OPTION_FAILURE);

    public static final ResultObj DEL_SUCCESS = new ResultObj(SysConstants.CODE_SUCCESS, SysConstants.DEL_SUCCESS);
    public static final ResultObj DEL_FAILURE = new ResultObj(SysConstants.CODE_FAILER, SysConstants.DEL_FAILURE);

    public static final ResultObj UP_SUCCESS = new ResultObj(SysConstants.CODE_SUCCESS,SysConstants.UP_SUCCESS) ;
    public static final ResultObj UP_FAILURE = new ResultObj(SysConstants.CODE_FAILER,SysConstants.UP_FAILURE) ;

    public static final ResultObj DOWN_SUCCESS = new ResultObj(SysConstants.CODE_SUCCESS,SysConstants.DOWN_SUCCESS) ;
    public static final ResultObj DOWN_FAILURE = new ResultObj(SysConstants.CODE_FAILER,SysConstants.DOWN_FAILURE) ;

    public static final ResultObj ADD_SUCCESS = new ResultObj(SysConstants.CODE_SUCCESS, SysConstants.ADD_SUCCESS);

    public static final ResultObj UPDATE_SUCCESS = new ResultObj(SysConstants.CODE_SUCCESS, SysConstants.UPDATE_SUCCESS);
}
