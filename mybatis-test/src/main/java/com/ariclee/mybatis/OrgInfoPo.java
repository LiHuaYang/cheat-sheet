package com.ariclee.mybatis;

import lombok.Data;

import java.util.Date;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
@Data
public class OrgInfoPo {
    private Integer id;
    private String orgCode;
    private String orgName;
    private Date createTime;

    private SceneEnum scene;
}
