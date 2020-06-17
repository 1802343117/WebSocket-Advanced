package com.soft1851.websocket.utils;

import com.soft1851.websocket.entity.TMessages;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 12559
 * 使用单例模型管理通信用户
 */
public class UserUtils {

    // 静态的 UserUtils 表明该对象只有一个
    private static UserUtils userUtils;

    // 用户通信容器
    private List<Session> list;

    /**
     * 仅允许创建一次该类对象
     * @return
     */
    public static synchronized UserUtils getUserUtils() {
        if ( userUtils == null ) {
            userUtils = new  UserUtils();
        }
        return userUtils;
    }

    /**
     * 无参构造器，提供参加该类对象
     * 在创建对象的同时 创建存储空间
     */
    private UserUtils() {
        this.list = new ArrayList<>();
    }

    /**
     * 添加通信用户
     * @param session
     */
    public synchronized void addMap(Session session) {
        this.list.add(session);
    }

    public synchronized void sending(TMessages tMessages) {
        int i = Integer.parseInt(tMessages.getmToUserid());
        String message = tMessages.getmContent();
        try {
            this.list.get(i).getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void delete(Session session) {
        Iterator<Session> it = this.list.iterator();
        while(it.hasNext()){
            Session sess = (Session)it.next();
            if(session.equals(sess)){
                it.remove();
            }
        }
        System.out.println(this.list.toString());
    }

}
