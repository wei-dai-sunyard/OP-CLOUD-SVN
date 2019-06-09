package com.sunyard.op.controller;


import com.sunyard.op.bean.EurekaOperBean;
import com.sunyard.op.util.TransUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
@RequestMapping(value = "/eureka")
public class OperaEurekaController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${eureka.client.serviceUrl.defaultZone}")
    String eurekaAddr;

    //查询Eureka中心下所有注册的应用实例状态
    @RequestMapping(value = "/selectInsts")
    public String queryInstsInfo() {
        TransUtil transUtil = new TransUtil();
        String URL = eurekaAddr + "apps";
        Map<String, String> retMap = transUtil.sendJsonCtxWithHttp(URL, "GET", "");
        logger.info("查询EUREKA注册中心下实例情况返回信息:" + "/n" + retMap);
        if ("200".equals(retMap.get(TransUtil.RET_HTTP_CODE))) {
            return retMap.get(TransUtil.RET_HTTP_MESSAGE);
        }
        return "FAILED";
    }

    //根据注册的的应用实例号停用服务
    @RequestMapping(value = "/stopInstByID", method = RequestMethod.POST)
    public String stotInstByID(@RequestBody EurekaOperBean operBean) {
        String appName = operBean.getAppName();
        String instanceID = operBean.getInstanceID();
        //appName = "DEMO-SERVER";
        //instanceID = "AFOIG-812131522:DEMO-SERVER:8001";
        TransUtil transUtil = new TransUtil();
        String URL = eurekaAddr + "apps/"
                + appName + "/" + instanceID
                + "/status?value=OUT_OF_SERVICE";
        Map<String, String> retMap = transUtil.sendJsonCtxWithHttp(URL, "PUT", "");
        if ("200".equals(retMap.get(TransUtil.RET_HTTP_CODE))) {
            logger.info("停用实例" + appName + "成功。");
            return retMap.get(TransUtil.RET_HTTP_MESSAGE);
        } else {
            return "FAILED";
        }
    }

    //根据注册的应用实例号恢复服务
    @RequestMapping(value = "/startInstByID", method = RequestMethod.POST)
    public String startInstByID(@RequestBody EurekaOperBean operBean) {
        String appName = operBean.getAppName();
        String instanceID = operBean.getInstanceID();
        //appName = "DEMO-SERVER";
        //instanceID = "AFOIG-812131522:DEMO-SERVER:8001";
        String URL = eurekaAddr + "apps/"
                + appName + "/" + instanceID
                + "/status?value=UP";
        TransUtil transUtil = new TransUtil();
        Map<String, String> retMap = transUtil.sendJsonCtxWithHttp(URL, "DELETE", "");
        if ("200".equals(retMap.get(TransUtil.RET_HTTP_CODE))) {
            logger.info("恢复实例" + appName + "成功。");
            return retMap.get(TransUtil.RET_HTTP_MESSAGE);
        } else {
            return "FAILED";
        }
    }

    //根据注册的应用实例号撤销服务
    //直接将服务下线。下次心跳又会注册上来
    /*@RequestMapping(value = "/deleteInstByID", method = RequestMethod.POST)
    public String deleteInstByID(@RequestBody EurekaOperBean operBean) {
        String appName = operBean.getAppName();
        String instanceID = operBean.getInstanceID();
        //TODO
        appName = "DEMO-SERVER";
        instanceID = "AFOIG-812131522:DEMO-SERVER:8001";
        TransUtil transUtil = new TransUtil();
        String URL = eurekaAddr + "apps/" + appName + "/" + instanceID;
        Map<String, String> retMap = transUtil.sendJsonCtxWithHttp(URL, "DELETE", " ");
        if ("200".equals(retMap.get(TransUtil.RET_HTTP_CODE))) {
            logger.info("暂停实例" + appName + "成功。");
            return retMap.get(TransUtil.RET_HTTP_MESSAGE);
        } else {
            return "FAILED";
        }
    }*/


}
