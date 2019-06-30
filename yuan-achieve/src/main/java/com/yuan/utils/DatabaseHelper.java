package com.yuan.utils;

import java.sql.Connection;

/**
 * FileName: DatabaseHelper
 * Author:   yhl
 * Date:     2018/11/18 23:39
 * Description: 数据库管理工具
 */
public class DatabaseHelper {
    //todo 为了保证一个线程中只有一个connection，可以将threadlocal理解成为一个隔离线程的容器.
    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL = new ThreadLocal<Connection>();
    /**
     * 获取数据库连接
     */
    private String aa;
    private String bb;
    private String cc;
    private String cc6;
    private String cc5;
    private String cc66;
    private String cc77;


}
