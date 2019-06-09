package com.sunyard.op.controller;


import com.sunyard.op.mybatis.dao.BusinessInstTbMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;



@RestController
@RequestMapping(value = "/api")
public class OperaAPIController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    BusinessInstTbMapper businessInstTbMapper;

    //查询Eureka中心下所有注册的应用实例状态
    @RequestMapping(value = "/selectInsts")
    public String queryInstsInfo() {
        int seq = businessInstTbMapper.getSeq();
        System.out.print("---------------" + seq);
        return "FAILED";
    }

}
