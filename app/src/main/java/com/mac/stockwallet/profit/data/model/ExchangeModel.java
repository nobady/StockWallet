package com.mac.stockwallet.profit.data.model;

/**
 * Created by kingdee on 2019-08-08.
 * 交易所model
 */
public class ExchangeModel {
    private int exchangeId;
    private String name;
    private String info;
    private String logo;
    private String service;
    private String createTime;
    private String updateTime;
    private String delFlag;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "ExchangeModel{" +
            "exchangeId=" + exchangeId +
            ", name='" + name + '\'' +
            ", info='" + info + '\'' +
            ", logo='" + logo + '\'' +
            '}';
    }
}
