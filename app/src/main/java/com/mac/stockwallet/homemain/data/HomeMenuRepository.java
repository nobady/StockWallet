package com.mac.stockwallet.homemain.data;

import com.mac.stockwallet.utils.LogUtils;

/**
 * Created by kingdee on 2019-08-05.
 */
public class HomeMenuRepository {

    private HomeMenuRepository(HomeMenuDataSource mDataSource){
        this.mDataSource  = mDataSource;
    }

    public static HomeMenuRepository getInstance(HomeMenuDataSource mDataSource){
        return INSTANCE.getInstance(mDataSource);
    }

    private static class INSTANCE{
        private static HomeMenuRepository getInstance(HomeMenuDataSource mDataSource){
            return new HomeMenuRepository(mDataSource);
        }
    }

    private HomeMenuDataSource mDataSource;

    public void loadMenu(HomeMenuCallback callback){
        mDataSource.loadLocalMenu(callback);
    }

}
