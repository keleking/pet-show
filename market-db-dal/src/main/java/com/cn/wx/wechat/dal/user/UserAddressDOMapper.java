package com.cn.wx.wechat.dal.user;


import com.cn.wx.wechat.dal.user.entity.UserAddressDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author king
 */
@Mapper
public interface UserAddressDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserAddressDO record);

    int insertSelective(UserAddressDO record);

    UserAddressDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAddressDO record);

    int updateByPrimaryKey(UserAddressDO record);

    List<UserAddressDO> selectByOpenId(String openId);
}