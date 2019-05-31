package com.wjf;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wjf.entity.Content;
import com.wjf.service.IContentService;
import com.wjf.service.impl.ContentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisplusApplicationTests {
    @Autowired
    private IContentService contentService;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testMybatisPlus() {
        LambdaQueryWrapper<Content> cond=new LambdaQueryWrapper<>();
        cond.gt(Content::getId,14);
        List<Content> list = contentService.list(cond);
        list.stream().forEach(item->{
            System.out.println(item.getContent());
        });

    }


}
