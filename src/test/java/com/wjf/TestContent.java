package com.wjf;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wjf.entity.Content;
import com.wjf.service.IContentService;
import com.wjf.service.impl.ContentServiceImpl;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 内容单元测试
 * @author weijunfeng
 * @Date 2019-05-20 20:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class TestContent {
    @Autowired
    private IContentService contentService;
    @Test
    public void testOk() {
        QueryWrapper<Content> cond=new QueryWrapper<>();
        cond.eq("id",1);
        final List<Content> list = contentService.list(cond);
        System.out.println(1);
    }

}
