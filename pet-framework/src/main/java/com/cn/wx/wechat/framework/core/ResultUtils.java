package com.cn.wx.wechat.framework.core;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: pet-show
 * @description: ${description}
 * @author: king
 * @create: 2018-07-17 08:23
 **/
@Data
public class ResultUtils<T> implements Serializable {

    boolean success;

    String msg;

    T data;

    public ResultUtils(){
        success = true;
    }

    public void setErrorMsg(String msg){
        this.msg = msg;
        success = false;
    }

    public void setData(T result){

        this.data = result;
    }

    public Boolean isSuccess(){
        return this.success;
    }
}
