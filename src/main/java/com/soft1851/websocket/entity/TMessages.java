package com.soft1851.websocket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import lombok.Data;

/**
 * @author 12559
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TMessages {

    private String mContent;

    private String mFromUserid;

    private String mToUserid;

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmFromUserid() {
        return mFromUserid;
    }

    public void setmFromUserid(String mFromUserid) {
        this.mFromUserid = mFromUserid;
    }

    public String getmToUserid() {
        return mToUserid;
    }

    public void setmToUserid(String mToUserid) {
        this.mToUserid = mToUserid;
    }
}
