package com.cn.wx.wechat.controller;

import com.cn.wx.wechat.constants.WXAppConstants;
import com.cn.wx.wechat.dal.user.entity.UserAddressDO;
import com.cn.wx.wechat.framework.core.ResultUtils;
import com.cn.wx.wechat.framework.utils.HttpUtils;
import com.cn.wx.wechat.handller.UserInfoHandler;
import com.cn.wx.wechat.model.LoginGetOpenIdRequet;
import com.cn.wx.wechat.model.UserAddressAddRequst;
import com.cn.wx.wechat.model.UserAddressRequst;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pet-show
 * @description: ${description}
 * @author: king
 * @create: 2018-07-09 20:16
 **/
@RestController
@RequestMapping("/user/address")
public class UserAdderssManageController {

    @Resource
    UserInfoHandler userInfoHandler;

    /**
     * 根据openid查询收货地址
     * @param userAddressAddRequst
     * @return
     */
    @RequestMapping("/query")
    public ResultUtils<List<UserAddressDO>> addAddress(@RequestBody UserAddressRequst userAddressAddRequst){

        return userInfoHandler.queryUserAddressByOpenId(userAddressAddRequst);
    }

    /**
     * 获取openid
     * @param loginGetOpenIdRequet
     * @return
     */
    @RequestMapping("/getOpenId")
    public String getOpenId(@RequestBody LoginGetOpenIdRequet loginGetOpenIdRequet){

        Map<String, String> params = new HashMap<>();
        params.put(WXAppConstants.APP_ID_STR, WXAppConstants.APP_ID);
        params.put(WXAppConstants.APP_SECRET_STR, WXAppConstants.APP_SECRET);
        params.put(WXAppConstants.APP_JS_CODE_STR, loginGetOpenIdRequet.getCode());
        params.put(WXAppConstants.APP_GRANT_TYPE_STR, WXAppConstants.APP_GRANT_TYPE);

        String response = HttpUtils.URLGet(WXAppConstants.GET_OPEN_ID_URL, params, "UTF-8");
        System.out.println(response);
        return response;
    }

    /**
     * 保存收货地址
     * @param userAddressRequst
     * @return
     */
    @RequestMapping("/add")
    public ResultUtils<String> saveAddress(@RequestBody UserAddressAddRequst userAddressRequst){

       return userInfoHandler.saveUserAddress(userAddressRequst);

    }

    /**
     * 删除收货地址
     * @param userAddressRequst
     * @return
     */
    @RequestMapping("/delete")
    public ResultUtils<String> deleteAddress(@RequestBody UserAddressRequst userAddressRequst){
       return userInfoHandler.deleteUserAddress(userAddressRequst);
    }

}
