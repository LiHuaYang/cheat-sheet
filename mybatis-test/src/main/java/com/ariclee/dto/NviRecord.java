package com.ariclee.dto;


import java.io.Serializable;
import java.util.Date;

public class NviRecord implements Serializable {

    private static final long serialVersionUID = -4728307291038772038L;

    private String id;
    /** 订单创建时间 */
    private Date createdOn;
    /** 订单号 */
    private String orderNo;

    /** 投保人名称 */
    private String appliName;
    /** 证件类型 */
    private String identifyType;
    /** 证件号码 */
    private String identifyNumber;
    /** 性别 */
    private String appliSex;
    /** 出生日期 */
    private String appliBirthDate;
    /** 手机号码 */
    private String appliMobilephone;

    /** 方案代码 */
    private String projectCode;
    /** 方案名称 */
    private String projectName;
    /** 投保时间 */
    private String operateDate;
    /** 起保日期 */
    private String startDate;
    /** 终保日期 */
    private String endDate;
    /** 承保地区 */
    private String geographicalArea;
    /** 总保费 */
    private String sumPremium;
    /** 总保额 */
    private String sumInsured;
    /** 投保份数 */
    private String uwCount;

    /** 车牌号码 */
    private String licenseNo;
    /** 核定座位数 */
    private String seatCount;
    /** 车架号 */
    private String frameNo;
    /** 发动机号 */
    private String certificateNo;

    /** 第三方支付流水号 */
    private String bankTradeNo;
    /** 投保单号 */
    private String proposalNo;
    /** 保单号 */
    private String policyNo;
    /** 电子保单URL */
    private String policyUrl;
    /** 电子发票URL */
    private String eInvoiceUrl;

    /** 返回信息 */
    private String info;
    /** 返回信息码 */
    private String infoCode;

    /** StateEnum */
    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getAppliSex() {
        return appliSex;
    }

    public void setAppliSex(String appliSex) {
        this.appliSex = appliSex;
    }

    public String getAppliBirthDate() {
        return appliBirthDate;
    }

    public void setAppliBirthDate(String appliBirthDate) {
        this.appliBirthDate = appliBirthDate;
    }

    public String getAppliMobilephone() {
        return appliMobilephone;
    }

    public void setAppliMobilephone(String appliMobilephone) {
        this.appliMobilephone = appliMobilephone;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getGeographicalArea() {
        return geographicalArea;
    }

    public void setGeographicalArea(String geographicalArea) {
        this.geographicalArea = geographicalArea;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(String sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getUwCount() {
        return uwCount;
    }

    public void setUwCount(String uwCount) {
        this.uwCount = uwCount;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getBankTradeNo() {
        return bankTradeNo;
    }

    public void setBankTradeNo(String bankTradeNo) {
        this.bankTradeNo = bankTradeNo;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyUrl() {
        return policyUrl;
    }

    public void setPolicyUrl(String policyUrl) {
        this.policyUrl = policyUrl;
    }

    public String geteInvoiceUrl() {
        return eInvoiceUrl;
    }

    public void seteInvoiceUrl(String eInvoiceUrl) {
        this.eInvoiceUrl = eInvoiceUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(String infoCode) {
        this.infoCode = infoCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
