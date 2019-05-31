package com.wjf.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author weijunfeng
 * @Date 2019-05-31 11:01
 */
@Controller
@RequestMapping(value = "/checkcenter")
public class CheckCenterController {
    //页面请求
    @GetMapping(value = "/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("cid",cid);
        return mav;
    }

    //推送数据接口
    @ResponseBody
    @RequestMapping(value = "/socket/push/{cid}")
    public String pushToWeb(@PathVariable String cid,String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }


}
