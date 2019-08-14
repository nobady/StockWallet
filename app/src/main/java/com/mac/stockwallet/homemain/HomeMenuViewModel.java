package com.mac.stockwallet.homemain;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.mac.stockwallet.homemain.data.HomeMenuCallback;
import com.mac.stockwallet.homemain.data.HomeMenuDataSource;
import com.mac.stockwallet.homemain.data.HomeMenuRepository;
import com.mac.stockwallet.homemain.data.model.HomeMenuItem;
import com.mac.stockwallet.utils.LogUtils;

import java.util.List;

/**
 * Created by kingdee on 2019-08-05.
 */
public class HomeMenuViewModel extends AndroidViewModel {

    private MutableLiveData<List<HomeMenuItem>> mMenusLiveData = new MutableLiveData<>();

    public MutableLiveData<List<HomeMenuItem>> getMenusLiveData() {
        return mMenusLiveData;
    }

    public HomeMenuViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadMenu(){
        HomeMenuRepository.getInstance(new HomeMenuDataSource()).loadMenu(new HomeMenuCallback() {
            @Override
            public void onLoadMenuSuccess(List<HomeMenuItem> menuItemList) {
                mMenusLiveData.setValue(menuItemList);
            }

            @Override
            public void onLoadMenuFail(Throwable throwable) {

            }
        });
    }

}
