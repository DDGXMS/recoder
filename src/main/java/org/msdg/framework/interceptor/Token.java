package org.msdg.framework.interceptor;

/**
 * Created by mw4157 on 16/9/19.
 */
public class Token {
    private int userId;
    private long time;
    private String token;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
