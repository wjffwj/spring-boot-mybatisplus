package com.wjf.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wjf.entity.Content;
import com.wjf.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author weijunfeng
 * @since 2019-05-20
 */
@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private IContentService  contentService;

    @RequestMapping(value = "/ok")
    public String getOk() {
        QueryWrapper<Content> cond=new QueryWrapper<>();
        cond.eq("id",1);
        final List<Content> list = contentService.list(cond);
        System.out.println(1);
        return null;
    }

}

