package com.bluemoutain.plugins.fastdfs;


import com.sun.xml.internal.ws.api.server.BoundEndpoint;

import java.util.List;

/**
 * Created by sxyqj on 2017/5/4.
 */
public class Module extends com.sun.xml.internal.ws.api.server.Module {
    @Override
    public List<BoundEndpoint> getBoundEndpoints() {
        return null;
    }

    public static com.sun.xml.internal.ws.api.server.Module FASTDFS = null;
}
