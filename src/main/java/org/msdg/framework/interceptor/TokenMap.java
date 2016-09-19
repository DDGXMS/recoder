package org.msdg.framework.interceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mw4157 on 16/9/19.
 */
public class TokenMap {

    private Map<String, Token> tokenMap = new HashMap<>();

    private TokenMap() {}
    private static class TokenMapHandler {
        private static final TokenMap instance = new TokenMap();
    }
    public static TokenMap me() {
        return TokenMapHandler.instance;
    }

    public Token getToken(String tokenId) {
        return tokenMap.get(tokenId);
    }

    public void putToken(Token token) {
        tokenMap.put(token.getToken(), token);
    }

    public Token setToken(int userId) {
        Token token = new Token();
        token.setUserId(userId);
        token.setTime(System.currentTimeMillis());
        token.setToken(UUID.randomUUID().toString());
        tokenMap.put(token.getToken(), token);
        return token;
    }
}
