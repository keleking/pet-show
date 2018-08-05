package com.cn.wx.wechat.framework.core;

import com.cn.wx.wechat.framework.request.Request;
import com.cn.wx.wechat.framework.response.Response;

/**
 * @program: pet-show
 * @description: ${description}
 * @author: king
 * @create: 2018-07-10 12:45
 **/
public interface Handler {

    /**
     * 具体业务处理方法
     *
     * @param model 业务模型对象
     * @return 处理结果
     */
    Response handle(Request model);
}