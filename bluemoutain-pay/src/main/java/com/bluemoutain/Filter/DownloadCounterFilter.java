package com.bluemoutain.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@WebFilter(urlPatterns = {"/*"})
public class DownloadCounterFilter implements Filter {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Properties downloadLog;
    private File logFile;


    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        final String uri = request.getRequestURI();
        executorService.execute(new Runnable() {

            @Override
            public void run() {
                String value = downloadLog.getProperty(uri);
                if(value == null) {
                    downloadLog.setProperty(uri, "1");
                }
                else {
                    int count = Integer.parseInt(value);
                    downloadLog.setProperty(uri, String.valueOf(++count));
                }
                try {
                    downloadLog.store(new FileWriter(logFile), "");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        chain.doFilter(req, resp);
    }


    public void init(FilterConfig config) throws ServletException {
        String appPath = config.getServletContext().getRealPath("/");
        logFile = new File(appPath, "downloadLog.txt");
        if(!logFile.exists()) {
            try {
                logFile.createNewFile();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        downloadLog = new Properties();
        try {
            downloadLog.load(new FileReader(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void destroy() {
        executorService.shutdown();
    }
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
