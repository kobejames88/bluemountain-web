package com.bluemoutain.Filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent evt) {
        evt.getServletContext().setAttribute("onLineCount", 0);
        evt.getServletContext().setAttribute("maxOnLineCount", 0);
    }
}
