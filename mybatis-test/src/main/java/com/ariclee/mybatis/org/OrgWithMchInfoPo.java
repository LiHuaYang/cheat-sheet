package com.ariclee.mybatis.org;

import com.ariclee.mybatis.mch.MchInfoPO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
@Data
@ToString
public class OrgWithMchInfoPo implements Serializable {
    private Integer id;
    private String orgCode;
    private String orgName;
    private Date createTime;

    private MchInfoPO mch;

    private SceneEnum scene;

    public OrgWithMchInfoPo(){}

    public OrgWithMchInfoPo(String orgCode, String orgName, Date createTime) {
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.createTime = createTime;
    }

    public OrgWithMchInfoPo(Integer id, String orgCode, String orgName, Date createTime) {
        this.id = id;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.createTime = createTime;
    }
}
