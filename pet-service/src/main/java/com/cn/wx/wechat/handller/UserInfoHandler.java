package com.cn.wx.wechat.handller;

import com.alibaba.fastjson.JSON;
import com.cn.wx.wechat.dal.user.UserAddressDOMapper;
import com.cn.wx.wechat.dal.user.entity.UserAddressDO;
import com.cn.wx.wechat.framework.core.ResultUtils;
import com.cn.wx.wechat.model.UserAddressAddRequst;
import com.cn.wx.wechat.model.UserAddressRequst;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: pet-show
 * @description: ${description}
 * @author: king
 * @create: 2018-07-13 14:36
 **/
@Component
public class UserInfoHandler  {

    @Resource
    UserAddressDOMapper userAddressDOMapper;

    public ResultUtils<List<UserAddressDO>> queryUserAddressByOpenId(UserAddressRequst userAddressAddRequst){
        ResultUtils<List<UserAddressDO>> resultUtils = new ResultUtils<>();
        List<UserAddressDO> userAddressDO = userAddressDOMapper.selectByOpenId(userAddressAddRequst.getOpenId());
        resultUtils.setData(userAddressDO);
        System.out.println("查询商户收货地址返回:"+JSON.toJSON(resultUtils));
        return resultUtils;
    }

    /**
     * 保存更新
     * @param userAddressAddRequst
     * @return
     */
    public ResultUtils<String> saveUserAddress(UserAddressAddRequst userAddressAddRequst){
        List<UserAddressDO> temp = userAddressDOMapper.selectByOpenId(userAddressAddRequst.getOpenId());
        ResultUtils<String> resultUtils = new ResultUtils<>();
        UserAddressDO userAddressDO = new UserAddressDO();
        userAddressDO.setUserName(userAddressAddRequst.getUserName());
        userAddressDO.setDetail(userAddressAddRequst.getAddressDetail());
        userAddressDO.setOpenId(userAddressAddRequst.getOpenId());
        userAddressDO.setUserTele(userAddressAddRequst.getUserTele());
        userAddressDO.setCreateGmt(new Date());
        userAddressDO.setUpdateGmt(new Date());
        String[] region = userAddressAddRequst.getRegion().split(",");
        userAddressDO.setProvince(region[0]);
        userAddressDO.setCity(region[1]);
        userAddressDO.setDistrict(region[2]);
        if(temp.size() == 0){
            userAddressDOMapper.insert(userAddressDO);
        }else {
            userAddressDO.setId(temp.get(0).getId());
            userAddressDOMapper.updateByPrimaryKey(userAddressDO);
        }
        resultUtils.setErrorMsg("保存成功");
        return  resultUtils;
    }


    public  ResultUtils<String> deleteUserAddress(UserAddressRequst userAddressRequst){
        ResultUtils<String> resultUtils = new ResultUtils<>();
        int count = userAddressDOMapper.deleteByPrimaryKey(userAddressRequst.getId());
        if(count != 1){
            resultUtils.setErrorMsg("删除失败");
            return resultUtils;
        }

        return resultUtils;

    }
}
