package com.cn.wx.wechat.framework.transaction;


import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

/**
 * 无返回值的事务回调接口，目的是为了使用 lambda 表达式
 *
 * @author king
 */
public interface TransactionCallbackNoneResult {

    /**
     * {@link org.springframework.transaction.support.TransactionOperations#execute(TransactionCallback)}
     * @param status 事务处理状态
     */
    void doInTransaction(TransactionStatus status);
}
