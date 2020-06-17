package com.soft1851.websocket.utils;

import com.soft1851.websocket.entity.TMessages;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12559
 * 使用单例模型管理通信（聊天）
 */
public class ChatUtils {

    // 创建 聊天消息存储容器
    private List<TMessages> messagesList;

    // 创建 聊天消息管理类
    private static ChatUtils chatUtils;

    /**
     * 判断该类对象 chatUtils 是否为空，如果为空则创建对象
     * 否则返回该类对象的值
     * @return
     */
    public static synchronized ChatUtils getChatUtils() {
        if ( chatUtils!=null ) {
            chatUtils = new ChatUtils();
        }
        return chatUtils;
    }

    /**
     * 提供创建该类对象方法
     */
    private ChatUtils() {
        this.messagesList = new ArrayList<>();
    }

    /**
     * 添加聊天消息
     * @param tMessages
     */
    public synchronized void addMessages(TMessages tMessages) {
        this.messagesList.add(tMessages);
    }

    /**
     * 移除容器中所有聊天记录
     */
    public synchronized void delete() {
        this.messagesList.clear();
    }

}
