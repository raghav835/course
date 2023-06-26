package com.cms.proxy;

public interface AuthenticationAuthorizationProxy {
    boolean authenticateUser(String username, String password);
    boolean authorizeUser(String username, String permission);
}
