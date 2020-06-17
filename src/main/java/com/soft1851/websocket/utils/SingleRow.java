package com.soft1851.websocket.utils;

import javax.websocket.Session;
import java.util.Vector;

/**
 * @author 12559
 */
public class SingleRow {

    private SingleRow() {
        this.vector = new Vector<Session>();
    }

    private static SingleRow singleRow;

    public static synchronized SingleRow getSingleRow() {
        if ( singleRow == null ) {
            singleRow = new SingleRow();
        }
        return singleRow;
    }

    private Vector<Session> vector;

    public synchronized void addVector(Session session) {
        this.vector.add(session);
    }

    /**
     * 消息群发
     * @param msg
     */
    public synchronized void qunfa(String msg) {
        for (int i = 0; i < vector.size(); i++) {
            try {
                System.out.println(this.vector.get(i).toString());
                this.vector.get(i).getBasicRemote().sendText(msg);
            } catch (Exception e) {
                e.printStackTrace();
                // 即便出现错误 程序依然继续执行不会被终止
                continue;
            }
        }
    }

}
