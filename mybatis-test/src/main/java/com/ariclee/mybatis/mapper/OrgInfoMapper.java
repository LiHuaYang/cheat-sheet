package com.ariclee.mybatis.mapper;

import com.ariclee.mybatis.OrgInfoPo;
import com.ariclee.mybatis.QueryOrgInfoReq;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
public interface OrgInfoMapper {

    OrgInfoPo getBy(QueryOrgInfoReq req);
}
