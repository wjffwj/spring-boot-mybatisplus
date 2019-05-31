package com.wjf.service.impl;

import com.wjf.entity.Mail;
import com.wjf.mapper.MailMapper;
import com.wjf.service.IMailService;
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
public class MailServiceImpl extends ServiceImpl<MailMapper, Mail> implements IMailService {
    @Autowired
    private MailMapper mailMapper;
}
