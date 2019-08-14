package com.mac.stockwallet.homemain.data.model;

/**
 * Created by kingdee on 2019-08-02.
 */
public enum MenuType {
    /**
     * 持仓盈亏
     */
    PROFIT("profit"),
    /**
     * 交易
     */
    BUSINESS("business"),
    /**
     * 我的
     */
    ME("me");

    String key;
    MenuType(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }}
