package com.sunyard.op.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BusinessInstTbMapper {

    //从数据库获取sequence
    int getSeq();
}