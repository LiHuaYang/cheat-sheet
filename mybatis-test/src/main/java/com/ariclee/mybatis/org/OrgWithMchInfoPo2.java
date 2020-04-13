package com.ariclee.mybatis.org;

import com.ariclee.mybatis.mch.MchInfoPO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
@Data
@ToString
public class OrgWithMchInfoPo2 {
    private Integer id;
    private String orgCode;
    private String orgName;
    private Date createTime;

    private SceneEnum scene;

    private List<MchInfoPO> mchs;

    public OrgWithMchInfoPo2(){}

    public OrgWithMchInfoPo2(String orgCode, String orgName, Date createTime) {
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.createTime = createTime;
    }

    public OrgWithMchInfoPo2(Integer id, String orgCode, String orgName, Date createTime) {
        this.id = id;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.createTime = createTime;
    }
}
