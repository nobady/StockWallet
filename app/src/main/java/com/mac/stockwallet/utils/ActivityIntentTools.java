package com.mac.stockwallet.utils;

import android.app.Activity;
import android.content.Intent;

import com.mac.stockwallet.profit.ui.ExchangeInfoActivity;

/**
 * Created by kingdee on 2019-08-12.
 */
public class ActivityIntentTools {

    public static void gotoExchangeInfoActivity(Activity activity,int exchangeId){
        Intent intent = new Intent();
        intent.setClass(activity, ExchangeInfoActivity.class);
        intent.putExtra("exchangeId",exchangeId);
        activity.startActivity(intent);
    }
}
