package com.bluemoutain.crond;

import com.alibaba.fastjson.JSON;

import com.bluemoutain.po.SystemDomain;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.ext.QueryDomainRet;
import com.bluemoutain.service.SystemDomainService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 查询备案信息
 */
@Component
public class DomainCheckTask {

    private static Logger logger = LoggerFactory.getLogger(DomainCheckTask.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SystemDomainService domainService;

    public DomainCheckTask() {
        logger.info("DomainCheckTask Init...");
    }

    /**
     * 每分钟查询ICP备案信息
     */
    @Async
    @Scheduled(cron = "0 */1 *  * * * ")
    public void timerToNow() {
        logger.info("当前时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("开始查询ICP备案信息...");
        List<SystemUser> list = userService.find_user_list();
        if (list != null && list.size() > 0) {
            for (SystemUser user : list) {
                String url = user.getUrl();
                if (url != null && url.length() > 3) {
                    SystemDomain domain = domainService.findByDomain(url);
                    if (domain == null) {
                        try {
                            String ret = HttpClientUtils.get("https://www.sojson.com/api/beian/" + url);
                            QueryDomainRet object = JSON.parseObject(ret, QueryDomainRet.class);
                            if (object != null && object.getType() == 200) {
                                SystemDomain tmp = new SystemDomain();
                                tmp.setDomain(object.getDomain());
                                tmp.setNature(object.getNature());
                                tmp.setIcp(object.getIcp());
                                tmp.setIndexUrl(object.getIndexUrl());
                                tmp.setNowIcp(object.getNowIcp());
                                tmp.setSitename(object.getSitename());
                                tmp.setName1(object.getName());
                                tmp.setSerach(url);
                                tmp.setStatus(2);
                                tmp.setPayShowInfo(1);
                                tmp.setUid(user.getId());
                                domainService.saveDomain(tmp);
                                logger.info("域名:" + url + " 备案号: " + object.getIcp() + " 网站备案号:" + object.getNowIcp());
                            } else {
                                SystemDomain tmp = new SystemDomain();
                                tmp.setDomain("暂无");
                                tmp.setNature("个人");
                                tmp.setIcp("暂无");
                                tmp.setIndexUrl("暂无");
                                tmp.setNowIcp("暂无");
                                tmp.setSitename("暂无");
                                tmp.setName1("暂无");
                                tmp.setSerach(url);
                                tmp.setStatus(1);
                                tmp.setPayShowInfo(1);
                                tmp.setUid(user.getId());
                                domainService.saveDomain(tmp);
                                logger.info("域名:" + url + " 备案号:暂无  网站备案号:暂无");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        logger.info("查询ICP备案信息完毕...");
    }


}
