package com.wjf.service.impl;

import com.wjf.entity.TUser;
import com.wjf.mapper.TUserMapper;
import com.wjf.service.ITUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    @Autowired
    private TUserMapper tUserMapper;
}
