package com.mac.stockwallet.homemain.data;

import android.annotation.SuppressLint;

import com.mac.stockwallet.SwApplication;
import com.mac.stockwallet.homemain.data.model.HomeMenuItem;
import com.mac.stockwallet.utils.ConvertUtils;
import com.mac.stockwallet.utils.GsonTools;
import com.mac.stockwallet.utils.ListHelper;
import com.mac.stockwallet.utils.LogUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kingdee on 2019-08-02.
 */
public class HomeMenuDataSource {

    private static String DEFAULT_PATH = "menu/menu_default.json";
    
    @SuppressLint("CheckResult")
    public void loadLocalMenu(final HomeMenuCallback callback){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                InputStream inputStream = SwApplication.getContext().getAssets().open(DEFAULT_PATH);
                String jsonStr = ConvertUtils.inputStream2String(inputStream, "utf-8");
                emitter.onNext(jsonStr);
            }
        }).map(new Function<String, List<HomeMenuItem>>() {
            @Override
            public List<HomeMenuItem> apply(String s) throws Exception {
                return GsonTools.gsonFormatToList(s,HomeMenuItem.class);
            }
        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<List<HomeMenuItem>>() {
                @Override
                public void accept(List<HomeMenuItem> menuItemList) throws Exception {
                    LogUtils.debug("加载本地menu成功");
                    if (ListHelper.isEmpty(menuItemList)) {
                        callback.onLoadMenuFail(new Throwable("the menu list is empty"));
                    } else {
                        for (HomeMenuItem homeMenuItem : menuItemList) {
                            homeMenuItem.initMenuType();
                        }
                        callback.onLoadMenuSuccess(menuItemList);
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    LogUtils.debug("加载本地menu失败");
                    callback.onLoadMenuFail(throwable);
                }
            });
    }
}
