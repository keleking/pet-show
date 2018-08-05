package com.cn.wx.wechat.framework.transaction;

import lombok.Data;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @program: pet-show
 * @description: ${description}
 * @author: king
 * @create: 2018-07-10 13:04
 **/
@Data
public class TransactionWrapper {

    /**
     * 事务模版
     **/
    @Resource
    protected TransactionTemplate defaultTxTemplate;

    /**
     * 执行事务,无返回值,重新定义TransactionCallbackNoneResult接口，目的是可使用lambda表达式
     **/
    public void executeWithoutResult(final TransactionCallbackNoneResult action) {
        defaultTxTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                action.doInTransaction(status);
            }
        });
    }

    /**
     * {@link org.springframework.transaction.support.TransactionOperations#execute(TransactionCallback)}
     */
    public <T> T execute(TransactionCallback<T> action) throws TransactionException {
        return defaultTxTemplate.execute(action);
    }
}
