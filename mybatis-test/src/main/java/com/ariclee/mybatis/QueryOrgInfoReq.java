package com.ariclee.mybatis;

import lombok.Builder;
import lombok.Data;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
@Data
@Builder
public class QueryOrgInfoReq {

    private Integer id;
    private String orgCode;
    private String orgName;

    private String orgCodeLike;
    private String orgNameLike;
}
