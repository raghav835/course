package com.cms.proxy;

public interface AuthenticationAuthorizationProxy {

    boolean authenticate(String username, String password);

    boolean isAuthorized(String username, String permission);

}
