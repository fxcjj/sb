package com.vic.sb06.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 测试容器启动和销毁时的反应
 * @author Victor
 * date: 2019/5/6 17:14
 */
public class AmplyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("AmplyListener initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("AmplyListener destroyed");
    }
}
