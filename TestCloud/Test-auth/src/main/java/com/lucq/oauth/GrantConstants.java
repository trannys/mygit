package com.lucq.oauth;

public class GrantConstants {
    /**
     * 认证类型: password
     */
    public static final String AUTHORIZED_GRANT_TYPE_PASSWORD = "password";

    /**
     * 认证类型: authorization_code
     */
    public static final String AUTHORIZED_GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";

    /**
     * 认证类型: client_credentials
     */
    public static final String AUTHORIZED_GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";

    /**
     * 认证类型: implicit
     */
    public static final String AUTHORIZED_GRANT_TYPE_IMPLICIT = "implicit";

    /**
     * 认证类型: refresh_token
     */
    public static final String AUTHORIZED_GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    /**
     * 授权范围: read
     */
    public static final String AUTHORIZED_GRANT_SCOPE_READ = "read";

    /**
     * 授权范围: write
     */
    public static final String AUTHORIZED_GRANT_SCOPE_WRITE = "write";

    /**
     * 网站站点授权Token默认有效期 2小时, 单位：秒
     */
    public static final int ACCESS_TOKEN_WEBSITE_DEFAULT_EXPIRE = 7200;

    /**
     * 网站站点授权Token默认有效期 2小时, 单位：秒
     */
    public static final int ACCESS_TOKEN_GATEWAY_DEFAULT_EXPIRE = 7200;

    /**
     * 系统超级管理员
     */
    public static final String AUTHENTICATED_ROOT_ACCOUNT = "lucqroot";

    /**
     * 系统超级管理员KEY
     */
    public static final String AUTHENTICATED_ROOT = "root";

    /**
     * 系统默认角色名
     */
    public static final String AUTHENTICATED_DEFAULT_ROLE = "user";

    /**
     * 系统角色字典-前缀
     */
    public static final String AUTHENTICATED_DICT_ROLE_PREFIX = "role_";

    /**
     * 系统菜单字典-前缀
     */
    public static final String AUTHENTICATED_DICT_RESOURCES_PREFIX = "res_";
}