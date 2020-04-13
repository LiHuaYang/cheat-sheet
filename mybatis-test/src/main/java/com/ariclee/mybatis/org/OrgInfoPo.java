package com.ariclee.mybatis.org;

import com.ariclee.mybatis.mch.MchInfoPO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
@Data
@ToString
public class OrgInfoPo implements Serializable {
    private Integer id;
    private String orgCode;
    private String orgName;
    private Date createTime;

    private SceneEnum scene;

    public OrgInfoPo(){}

    public OrgInfoPo(String orgCode, String orgName, Date createTime) {
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.createTime = createTime;
    }

    public OrgInfoPo(String orgCode, String orgName, Date createTime, SceneEnum scene) {
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.createTime = createTime;
        this.scene = scene;
    }

    public OrgInfoPo(Integer id, String orgCode, String orgName, Date createTime) {
        this.id = id;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.createTime = createTime;
    }
}
