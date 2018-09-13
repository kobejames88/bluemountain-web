package com.bluemoutain.Filter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebListener
public class MaxCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        int count = Integer.parseInt(ctx.getAttribute("onLineCount").toString());
        count++;
        ctx.setAttribute("onLineCount", count);
        int maxOnLineCount = Integer.parseInt(ctx.getAttribute("maxOnLineCount").toString());
        if (count > maxOnLineCount) {
            ctx.setAttribute("maxOnLineCount", count);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ctx.setAttribute("date", df.format(new Date()));
        }
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
            ServletContext app =  httpSessionEvent.getSession().getServletContext();
            int count = Integer.parseInt(app.getAttribute("onLineCount").toString());
            count--;
            app.setAttribute("onLineCount", count);
    }
}
