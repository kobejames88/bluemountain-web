package com.bluemoutain.plugins.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class);
    private LinkedBlockingQueue<TrackerServer> idleConnectionPool = null;
    private long minPoolSize = 100L;
    private long maxPoolSize = 200L;
    private volatile long nowPoolSize = 100L;
    private long waitTimes = 200L;
    private static final int COUNT = 1;

    public ConnectionPool(String url) {
        this.setUrl(url);
        String logId = UUID.randomUUID().toString();
        poolInit(logId);
        HeartBeat beat = new HeartBeat(this);
        beat.beat();
    }

    public long getNowPoolSize() {
        return nowPoolSize;
    }

    public void setNowPoolSize(long nowPoolSize) {
        this.nowPoolSize = nowPoolSize;
    }

    private void poolInit(String logId) {
        try {
            initClientGlobal();
            // LOGGER.info("[线程池构造方法(ConnectionPool)][" + logId + "][默认参数：minPoolSize=" + this.minPoolSize + ",maxPoolSize=" + this.maxPoolSize + ",waitTimes=" + this.waitTimes + "]");

            this.idleConnectionPool = new LinkedBlockingQueue();
            for (int i = 0; i < this.minPoolSize; i++) {
                createTrackerServer(logId, 1);
            }
        } catch (Exception e) {
            LOGGER.error("[FASTDFS初始化(init)--异常][" + logId + "][异常：{}]", e);
        }
    }

    public void createTrackerServer(String logId, int flag) {
        //  LOGGER.info("[创建TrackerServer(createTrackerServer)][" + logId + "]");
        TrackerServer trackerServer = null;
        try {
            TrackerClient trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            while ((trackerServer == null) && (flag < 5)) {
                //   LOGGER.info("[创建TrackerServer(createTrackerServer)][" + logId + "][第" + flag + "次重建]");
                flag++;
                initClientGlobal();
                trackerServer = trackerClient.getConnection();
            }
            ProtoCommon.activeTest(trackerServer.getSocket());

            this.idleConnectionPool.add(trackerServer);
            synchronized (this) {
                this.nowPoolSize += 1L;
            }
            return;
        } catch (Exception e) {
            LOGGER.error("[创建TrackerServer(createTrackerServer)][" + logId + "][异常：{}]", e);
        } finally {
            if (trackerServer != null) {
                try {
                    trackerServer.close();
                } catch (Exception e) {
                    LOGGER.error("[创建TrackerServer(createTrackerServer)--关闭trackerServer异常][" + logId + "][异常：{}]", e);
                }
            }
        }
    }

    public TrackerServer checkout(String logId) throws RuntimeException {
        //  LOGGER.info("[获取空闲连接(checkout)][" + logId + "]");
        TrackerServer trackerServer = this.idleConnectionPool.poll();
        if (trackerServer == null) {
            if (this.nowPoolSize < this.maxPoolSize) {
                createTrackerServer(logId, 1);
                try {
                    trackerServer = this.idleConnectionPool.poll(this.waitTimes, TimeUnit.SECONDS);
                } catch (Exception e) {
                    LOGGER.error("[获取空闲连接(checkout)-error][" + logId + "][error:获取连接超时:{}]", e);

                    throw new RuntimeException("获取连接超时");
                }
            }
            if (trackerServer == null) {
                LOGGER.error("[获取空闲连接(checkout)-error][" + logId + "][error:获取连接超时（" + this.waitTimes + "s）]");

                throw new RuntimeException("获取连接超时");
            }
        }
        //  LOGGER.info("[获取空闲连接(checkout)][" + logId + "][获取空闲连接成功]");
        return trackerServer;
    }

    public void checkin(TrackerServer trackerServer, String logId) {
        //  LOGGER.info("[释放当前连接(checkin)][" + logId + "][prams:" + trackerServer + "] ");
        if (trackerServer != null) {
            if (this.idleConnectionPool.size() < this.minPoolSize) {
                this.idleConnectionPool.add(trackerServer);
            } else {
                synchronized (this) {
                    if (this.nowPoolSize != 0L) {
                        this.nowPoolSize -= 1L;
                    }
                }
            }
        }
    }

    public void drop(TrackerServer trackerServer, String logId) {
        LOGGER.info("[删除不可用连接方法(drop)][" + logId + "][parms:" + trackerServer + "] ");
        if (trackerServer != null) {
            try {
                synchronized (this) {
                    if (this.nowPoolSize != 0L) {
                        this.nowPoolSize -= 1L;
                    }
                }
                trackerServer.close();
            } catch (IOException e) {
                LOGGER.info("[删除不可用连接方法(drop)--关闭trackerServer异常][" + logId + "][异常：{}]", e);
            }
        }
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * fastdfs 初始化
     *
     * @throws Exception
     */
    private void initClientGlobal() throws Exception {
//        ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
//        InputStream res1 = this.getClass().getResourceAsStream(url);
        Properties properties = new Properties();
        properties.setProperty("fastdfs.tracker_servers", url);
        ClientGlobal.initByProperties(properties);
    }


    public LinkedBlockingQueue<TrackerServer> getIdleConnectionPool() {
        return this.idleConnectionPool;
    }

    public long getMinPoolSize() {
        return this.minPoolSize;
    }

    public void setMinPoolSize(long minPoolSize) {
        if (minPoolSize != 0L) {
            this.minPoolSize = minPoolSize;
        }
    }

    public long getMaxPoolSize() {
        return this.maxPoolSize;
    }

    public void setMaxPoolSize(long maxPoolSize) {
        if (maxPoolSize != 0L) {
            this.maxPoolSize = maxPoolSize;
        }
    }

    public long getWaitTimes() {
        return this.waitTimes;
    }

    public void setWaitTimes(int waitTimes) {
        if (waitTimes != 0) {
            this.waitTimes = waitTimes;
        }
    }

}
