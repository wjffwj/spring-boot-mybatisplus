package com.wjf.worker;

import com.alibaba.fastjson.JSON;
import com.wjf.model.Message;
import com.wjf.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author weijunfeng
 * @Date 2019-05-31 13:49
 */
@Slf4j
@Service
public class Worker {

    @Scheduled(cron = "0/3 * * * * ?")
    public void buildMessage() {
        Long staffId = 20L;
        Message message = new Message("收款金额趋势", "30%", "30%");
        String jsonData = JSON.toJSONString(message);
        log.info("推送数据开始...");
        try {
            WebSocketServer.sendInfo(jsonData, String.valueOf(staffId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("推送数据完成...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
