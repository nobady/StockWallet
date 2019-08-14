package com.mac.stockwallet.profit;

import android.os.Bundle;

import com.mac.stockwallet.common.SharedPrefsHelper;

/**
 * Created by kingdee on 2019-08-13.
 */
public class ExchangeSharePrefs {

    private static String APP_NAME="Exchange";
    private static String APIKEY="apiKey";
    private static String SECRETKEY="secretKey";
    private static String PASSPHRASE="passphrase";

    private static SharedPrefsHelper newInstance() {
        return INSTANCE.instance;
    }

    private static class INSTANCE{
        private static SharedPrefsHelper instance = new SharedPrefsHelper(APP_NAME);
    }

    public static void setApiKey(String apiKey){
       newInstance().putStringValue(APIKEY,apiKey);
    }
    public static String getApiKey(){
        return newInstance().getStringValue(APIKEY);
    }

    public static void setSecretKey(String secretKey){
        newInstance().putStringValue(SECRETKEY,secretKey);
    }
    public static String getSecretKey(){
        return newInstance().getStringValue(SECRETKEY);
    }
    public static void setPassphrase(String passphrase){
        newInstance().putStringValue(PASSPHRASE,passphrase);
    }
    public static String getPassphrase(){
        return newInstance().getStringValue(PASSPHRASE);
    }

}
