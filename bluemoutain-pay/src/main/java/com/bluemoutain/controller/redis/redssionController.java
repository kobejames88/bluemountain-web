package com.bluemoutain.controller.redis;

import com.bluemoutain.redisson.DistributedRedisLock;
import com.bluemoutain.redisson.RedissonManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

public class redssionController {
    @RequestMapping("/redder")
    @ResponseBody
    public String redder() throws IOException {
        String key = "test123";

        DistributedRedisLock.acquire(key);


        Long result =  RedissonManager.nextID();

        DistributedRedisLock.release(key);
        return ""+result;
    }
}
