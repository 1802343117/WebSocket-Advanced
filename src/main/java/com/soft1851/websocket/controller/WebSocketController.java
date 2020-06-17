package com.soft1851.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.websocket.entity.TMessages;
import com.soft1851.websocket.utils.UserUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author 12559
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocketController {

    @OnOpen
    public void abcd1(Session session) {
        System.out.println("连接成功");
        // 创建连接对象，并存储
        UserUtils userUtils = UserUtils.getUserUtils();
        userUtils.addMap(session);

        // 查看 Session 属性
//        System.out.println("ID" + "\t" + session.getId());
//        System.out.println("异步远程" + "\t" + session.getAsyncRemote());
//        System.out.println("基本远程" + "\t" + session.getBasicRemote());
//        System.out.println("类" + "\t" + session.getClass());
//        System.out.println("容器" + "\t" + session.getContainer());
//        System.out.println("（最大二进制）消息缓冲区大小" + "\t" + session.getMaxBinaryMessageBufferSize());
//        System.out.println("（最大）闲置超时" + "\t" + session.getMaxIdleTimeout());
//        System.out.println("（最大）文字信息缓冲区大小" + "\t" + session.getMaxTextMessageBufferSize());
//        System.out.println("消息处理程序" + "\t" + session.getMessageHandlers());
//        System.out.println("协议扩展" + "\t" + session.getNegotiatedExtensions());
//        System.out.println("子协议" + "\t" + session.getNegotiatedSubprotocol());
//        System.out.println("公开会议" + "\t" + session.getOpenSessions());
//        System.out.println("路径参数" + "\t" + session.getPathParameters());
//        System.out.println("协议版本" + "\t" + session.getProtocolVersion());
//        System.out.println("请求参数" + "\t" + session.getQueryString());
//        System.out.println("请求参数（Map）" + "\t" + session.getRequestParameterMap());
//        System.out.println("查看Map" + "\t" + session.getRequestParameterMap().toString());
//        System.out.println("尝试取用（Map）中的键" + "\t" + session.getRequestParameterMap().keySet());
//        System.out.println("尝试取用（Map）中的值" + "\t" + session.getRequestParameterMap().values());
//        System.out.println("请求参数URL" + "\t" + session.getRequestURI());
//        System.out.println("用户主体" + "\t" + session.getUserPrincipal());
//        System.out.println("用户属性" + "\t" + session.getUserProperties());
    }

    /**
     * 接收到客户端发送的数据时被调用
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println("我接收到的信息：" + message);
//        session.getAsyncRemote().sendText("接收到了：" + message);
//        SingleRow singleRow = SingleRow.getSingleRow();
//        singleRow.qunfa(message);

        // 将 message 转换成 TMessages 对象
        JSONObject mess = JSONObject.parseObject(message);
        TMessages tMessages = new TMessages();
        tMessages.setmContent(mess.getString("mContent"));
        tMessages.setmFromUserid(mess.getString("mFromUserid"));
        tMessages.setmToUserid(mess.getString("mToUserid"));
        System.out.println(tMessages.getmContent());
        System.out.println(tMessages.getmFromUserid());
        System.out.println(tMessages.getmToUserid());

        // 发送消息给指定用户
        UserUtils userUtils = UserUtils.getUserUtils();
        userUtils.sending(tMessages);
    }

    /**
     * 连接关闭时被调用
     *
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("我关闭了通信连接");
        UserUtils userUtils = UserUtils.getUserUtils();
        userUtils.delete(session);
    }
}
