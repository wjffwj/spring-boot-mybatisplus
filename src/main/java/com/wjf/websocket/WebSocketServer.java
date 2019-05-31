package com.wjf.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author weijunfeng
 * @Date 2019-05-31 10:26
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{sid}")
public class WebSocketServer {


    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //接收sid
    private String sid;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        //将当前连接加入set中
        webSocketSet.add(this);
        //在线数+1
        addOnlineCount();
        log.info("有新窗口开始监听：sid:{}-当前在线人数是：{}", sid, onlineCount);

        this.sid = sid;
        try {
            sendMessage("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1

    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自窗口" + sid + "的信息:" + message);
        //群发消息
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, @PathParam("sid") String sid) throws Exception {
        log.info("推送消息到窗口" + sid + "，推送内容:" + message);
        for (WebSocketServer item : webSocketSet) {
            if(sid == null) {
                item.sendMessage(message);
            }else if(item.sid.equals(sid)) {
                item.sendMessage(message);
            }
        }
    }




    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws Exception {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 减少在线数量
     */
    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    /**
     * 添加在线数量
     */
    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }


}
