package com.bluemoutain.plugins.fastdfs;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.util.UUID;

/**
 * FastDFS 工具类
 * <p>
 * 派生模式
 */
@Component
@ConfigurationProperties(prefix = "fdfs")
public class FastDfsUtil {

    private String fdfsserver = "localhost:22122";

    private Integer enable = 0;

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getFdfsserver() {
        return fdfsserver;
    }

    public void setFdfsserver(String fdfsserver) {
        this.fdfsserver = fdfsserver;
        if (enable == 0) {
            LOGGER.info("不使用FastDFS 文件服务器,跳过初始化...");
            return;
        }
        LOGGER.info("FastDfsUtil初始化URL:" + this.getFdfsserver());
        String logId = UUID.randomUUID().toString();
        LOGGER.info("[初始化线程池(Init)][" + logId + "][默认参数：minPoolSize=" + this.minPoolSize + ",maxPoolSize=" + this.maxPoolSize + ",waitTimes=" + this.waitTimes + "]");
        this.connectionPool = new ConnectionPool(fdfsserver);
        this.connectionPool.setMaxPoolSize(this.maxPoolSize);
        this.connectionPool.setMinPoolSize(this.minPoolSize);
        this.connectionPool.setWaitTimes(this.waitTimes.intValue());
        this.connectionPool.setNowPoolSize(this.nowPoolSize);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FastDfsUtil.class);
    private ConnectionPool connectionPool = null;
    private long minPoolSize = 100L;
    private long maxPoolSize = 300L;
    private volatile long nowPoolSize = 0L;
    private Long waitTimes = 200L;

    public FastDfsUtil() {
        LOGGER.info("FastDfsUtil初始化...");
    }

    public FastDfsUtil(long minPoolSize, long maxPoolSize, long nowPoolSize, Long waitTimes) {
        this.minPoolSize = minPoolSize;
        this.maxPoolSize = maxPoolSize;
        this.nowPoolSize = nowPoolSize;
        this.waitTimes = waitTimes;
        String logId = UUID.randomUUID().toString();
        LOGGER.info("[初始化线程池(Init)][" + logId + "][默认参数：minPoolSize=" + this.minPoolSize + ",maxPoolSize=" + this.maxPoolSize + ",waitTimes=" + this.waitTimes + "]");
        this.connectionPool = new ConnectionPool(fdfsserver);
        this.connectionPool.setMaxPoolSize(this.maxPoolSize);
        this.connectionPool.setMinPoolSize(this.minPoolSize);
        this.connectionPool.setWaitTimes(this.waitTimes.intValue());
        this.connectionPool.setNowPoolSize(this.nowPoolSize);
    }

    public String uploadFile(byte[] fileBytes, String extName) throws RuntimeException {
        String logId = UUID.randomUUID().toString();

        TrackerServer trackerServer = null;
        try {
            trackerServer = this.connectionPool.checkout(logId);
            StorageServer storageServer = null;
            StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);
            String results;
            results = client1.upload_file1(fileBytes, extName, null);
            this.connectionPool.checkin(trackerServer, logId);
            LOGGER.info("[上传文件（upload）-fastdfs服务器相应结果][" + logId + "][result：results=" + results + "]");
            if (results != null) {
                return results;
            }
            throw new RuntimeException();
        } catch (RuntimeException e) {
            LOGGER.error("[上传文件（upload)][" + logId + "][异常：" + e + "]");
            throw e;
        } catch (SocketTimeoutException e) {
            LOGGER.error("[上传文件（upload)][" + logId + "][异常：" + e + "]");
            throw new RuntimeException();
        } catch (Exception e) {
            LOGGER.error("[上传文件（upload)][" + logId + "][异常：" + e + "]");
            this.connectionPool.drop(trackerServer, logId);
            throw new RuntimeException();
        }
    }

    public String[] upload(String groupName, byte[] fileBytes, String localFileName, String extName, NameValuePair[] metaList) throws RuntimeException {
        String logId = UUID.randomUUID().toString();

        TrackerServer trackerServer = null;
        try {
            trackerServer = this.connectionPool.checkout(logId);
            StorageServer storageServer = null;
            StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);

            String[] results = null;
            if (localFileName != null) {
                results = client1.upload_file(localFileName, extName, metaList);
            } else {
                results = client1.upload_file(groupName, fileBytes, extName, metaList);
            }
            this.connectionPool.checkin(trackerServer, logId);

            LOGGER.info("[上传文件（upload）-fastdfs服务器相应结果][" + logId + "][result：results=" + results + "]");
            if ((results != null) && (results.length == 2)) {
                return results;
            }
            throw new RuntimeException();
        } catch (RuntimeException e) {
            LOGGER.error("[上传文件（upload)][" + logId + "][异常：" + e + "]");
            throw e;
        } catch (SocketTimeoutException e) {
            LOGGER.error("[上传文件（upload)][" + logId + "][异常：" + e + "]");
            throw new RuntimeException();
        } catch (Exception e) {
            LOGGER.error("[上传文件（upload)][" + logId + "][异常：" + e + "]");
            this.connectionPool.drop(trackerServer, logId);
            throw new RuntimeException();
        }
    }

    public NameValuePair[] getFileMetaData(String groupName, String remote_filename) throws RuntimeException {
        String logId = UUID.randomUUID().toString();
        NameValuePair[] nvp = null;
        TrackerServer trackerServer = null;
        try {
            trackerServer = this.connectionPool.checkout(logId);
            StorageServer storageServer = null;
            StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);
            nvp = client1.get_metadata(groupName, remote_filename);
            this.connectionPool.checkin(trackerServer, logId);
        } catch (Exception e) {
            LOGGER.error("[获取文件meta信息][" + logId + "][异常：" + e + "]");
        } finally {
            this.connectionPool.checkin(trackerServer, logId);
        }
        return nvp;
    }

    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte['Ѐ'];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }

    public void downloadFileStream(String groupName, String remoteFileName, OutputStream out) {
        String logId = UUID.randomUUID().toString();
        TrackerServer trackerServer = null;
        try {
            trackerServer = this.connectionPool.checkout(logId);
            StorageClient1 client = new StorageClient1(trackerServer, null);
            client.download_file(groupName, remoteFileName, new DownloadStream(out));
        } catch (IOException e) {
            LOGGER.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            LOGGER.error("Non IO Exception: Get File from Fast DFS failed", e);
        } finally {
            this.connectionPool.checkin(trackerServer, logId);
        }
    }

    public FileInfo getFileInfo(String groupName, String remoteFileName) {
        String logId = UUID.randomUUID().toString();
        TrackerServer trackerServer = null;
        try {
            trackerServer = this.connectionPool.checkout(logId);
            StorageClient1 client = new StorageClient1(trackerServer, null);
            return client.query_file_info(groupName, remoteFileName);
        } catch (IOException e) {
            LOGGER.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            LOGGER.error("Non IO Exception: Get File from Fast DFS failed", e);
        } finally {
            this.connectionPool.checkin(trackerServer, logId);
        }
        return null;
    }

    public void deleteFile(String group_name, String remote_filename) throws RuntimeException {
        String logId = UUID.randomUUID().toString();
        LOGGER.info("[ 删除文件（deleteFile）][" + logId + "][parms：group_name=" + group_name + ",remote_filename=" + remote_filename + "]");

        TrackerServer trackerServer = null;
        try {
            trackerServer = this.connectionPool.checkout(logId);
            StorageServer storageServer = null;
            StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);

            int result = client1.delete_file(group_name, remote_filename);

            this.connectionPool.checkin(trackerServer, logId);

            LOGGER.info("[ 删除文件（deleteFile）--调用fastdfs客户端返回结果][" + logId + "][results：result=" + result + "]");
            if (result == 2) {
                throw new RuntimeException("文件不存在");
            }
            if (result != 0) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            LOGGER.error("[ 删除文件（deleteFile）][" + logId + "][异常：" + e + "]");
            throw e;
        } catch (SocketTimeoutException e) {
            LOGGER.error("[ 删除文件（deleteFile）][" + logId + "][异常：" + e + "]");
            throw new RuntimeException();
        } catch (Exception e) {
            LOGGER.error("[ 删除文件（deleteFile）][" + logId + "][异常：" + e + "]");
            this.connectionPool.drop(trackerServer, logId);
            throw new RuntimeException();
        }
    }

    public ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public void setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public long getMinPoolSize() {
        return this.minPoolSize;
    }

    public void setMinPoolSize(long minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public long getMaxPoolSize() {
        return this.maxPoolSize;
    }

    public void setMaxPoolSize(long maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public long getNowPoolSize() {
        return this.nowPoolSize;
    }

    public void setNowPoolSize(long nowPoolSize) {
        this.nowPoolSize = nowPoolSize;
    }

    public long getWaitTimes() {
        return this.waitTimes;
    }

    public void setWaitTimes(long waitTimes) {
        this.waitTimes = waitTimes;
    }
}
