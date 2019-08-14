package com.mac.stockwallet.homemain.data;

import com.mac.stockwallet.homemain.data.model.HomeMenuItem;

import java.util.List;

/**
 * Created by kingdee on 2019-08-05.
 */
public interface HomeMenuCallback {
    void onLoadMenuSuccess(List<HomeMenuItem> menuItemList);
    void onLoadMenuFail(Throwable throwable);
}
