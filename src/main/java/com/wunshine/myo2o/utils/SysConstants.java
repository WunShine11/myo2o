package com.wunshine.myo2o.utils;

/**
 * 该接口，我们定义系统常量
 * 定义接口的目的：是可以省略public  static final
 * @author azzhu
 * @create 2019-09-04 09:20:02
 */
public interface SysConstants {
    String SESSION_USER = "user";
    String SESSION_PERSONINFO = "personInfo";

    Integer CODE_SUCCESS = 0;//添加成功
    Integer CODE_FAILER = 1;//添加失败

    String DEL_SUCCESS = "删除成功";
    String DEL_FAILURE = "删除失败";

    String UP_SUCCESS = "上架成功";
    String UP_FAILURE = "上架失败";

    String DOWN_SUCCESS = "下架成功";
    String DOWN_FAILURE = "下架失败";

    String OPTION_FAILURE = "更改失败";

    String ADD_SUCCESS = "新增成功";

    String UPDATE_SUCCESS = "更新成功";

    /**
     * 临时文件标记
     */
    String FILE_UPLOAD_TEMP = "_temp";

}
