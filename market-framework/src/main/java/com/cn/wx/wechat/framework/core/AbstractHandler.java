package com.cn.wx.wechat.framework.core;

import com.cn.wx.wechat.framework.request.Request;
import com.cn.wx.wechat.framework.response.Response;
import com.cn.wx.wechat.framework.transaction.TransactionWrapper;
import com.mysql.jdbc.log.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ValidationUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: pet-show
 * @description: ${description}
 * @author: king
 * @create: 2018-07-10 12:47
 **/
public abstract class AbstractHandler extends TransactionWrapper implements Handler{

    protected Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     * 具体业务方法,业务具体类必须实现此方法
     *
     * @param request 请求对象
     * @return 根据具体业务逻辑决定
     */
    protected abstract Response execute(Request request);

    /**
     * 前置  业务校验
     *
     * @param request 请求对象
     */
    protected abstract void before(Request request);

    @Override
    public Response handle(Request request) {
        Response result = null;
        try {
            //1.前处理
            doBefore(request);

            //2.执行具体业务
            result = doExecute(request);

            //3.后处理
            doAfter(request, result);

            //4. 构造响应对象返回
            return result;

        } catch (Exception e) {
            log.error("[处理器]-未知异常,exceptiion={},req={}", e, request);
            return null;

        }

    }


    /**
     * 前处理方法,比如校验参数等
     *
     * @param request 请求对象
     */
    protected void doBefore(Request request) {

        //业务校验
        before(request);
    }

    /**
     * execute 的包装方法.
     */
    protected Response doExecute(Request model) {
        return execute(model);
    }


    /**
     * 后处理,比如清理资源,记录日志等.
     *
     * @param request 请求对象
     */
    protected void doAfter(Request request, Response result) {
        //do nothing default
    }


}
