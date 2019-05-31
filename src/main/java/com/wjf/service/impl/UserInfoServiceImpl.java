package com.wjf.service.impl;

import com.wjf.entity.UserInfo;
import com.wjf.mapper.UserInfoMapper;
import com.wjf.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weijunfeng
 * @since 2019-05-20
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
}
