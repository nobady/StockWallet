package com.mac.stockwallet;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.mac.stockwallet.utils.Config;
import com.xuexiang.xhttp2.XHttp;

/**
 * Created by kingdee on 2019-08-05.
 */
public class SwApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        GlideBuilder glideBuilder = new GlideBuilder().setDiskCache(
            new DiskLruCacheFactory(Config.IMG_CACHE_DIR, 100 * 1024))
            .setLogLevel(Log.VERBOSE);
        Glide.init(this,glideBuilder);

        XHttp.init(this);
    }

    public static Context getContext(){
        return mContext;
    }
}
