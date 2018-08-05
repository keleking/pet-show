package com.cn.wx.wechat.model;

import lombok.Data;

/**
 * @program: pet-show
 * @description: ${description}
 * @author: king
 * @create: 2018-07-11 21:05
 **/
@Data
public class UserAddressAddRequst {


    private long  id;
    private String userName;
    private String userTele;
    private String openId;
    private String addressDetail;
    private String region;

}
