package com.mac.stockwallet.profit.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.mac.stockwallet.profit.data.ExchangeDataSource;
import com.mac.stockwallet.profit.data.ExchangeRepository;
import com.mac.stockwallet.profit.data.IExchangeCallback;
import com.mac.stockwallet.profit.data.model.ExchangeInfoModel;

public class ExchangeInfoViewModel extends AndroidViewModel {
    private MutableLiveData<ExchangeInfoModel> mMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<ExchangeInfoModel> getMutableLiveData() {
        return mMutableLiveData;
    }

    public ExchangeInfoViewModel(@NonNull Application application) {
        super(application);
    }

    public void getExchangeInfoData(String exchangeId){
        ExchangeRepository.getInstance(new ExchangeDataSource()).loadExchangeInfo(exchangeId, new IExchangeCallback<ExchangeInfoModel>() {
            @Override
            public void onLoadSuccess(ExchangeInfoModel exchangeModelList) {
                mMutableLiveData.setValue(exchangeModelList);
            }

            @Override
            public void onLoadFail(String errorMsg) {

            }
        });
    }
}
