package com.wjf.service.impl;

import com.wjf.entity.Content;
import com.wjf.mapper.ContentMapper;
import com.wjf.service.IContentService;
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
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {
    @Autowired
    private ContentMapper contentMapper;
}
