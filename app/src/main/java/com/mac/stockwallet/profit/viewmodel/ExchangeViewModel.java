package com.mac.stockwallet.profit.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.mac.stockwallet.profit.data.ExchangeDataSource;
import com.mac.stockwallet.profit.data.ExchangeRepository;
import com.mac.stockwallet.profit.data.IExchangeCallback;
import com.mac.stockwallet.profit.data.model.ExchangeModel;

import java.util.List;

public class ExchangeViewModel extends AndroidViewModel {

    private MutableLiveData<List<ExchangeModel>> mExchangeLiveData = new MutableLiveData<>();

    public MutableLiveData<List<ExchangeModel>> getExchangeLiveData() {
        return mExchangeLiveData;
    }

    public ExchangeViewModel(@NonNull Application application) {
        super(application);
    }

    public void getExchangeDatas(){
        ExchangeRepository.getInstance(new ExchangeDataSource()).loadExchangeList(new IExchangeCallback<List<ExchangeModel>>() {
            @Override
            public void onLoadSuccess(List<ExchangeModel> exchangeModelList) {
                mExchangeLiveData.setValue(exchangeModelList);
            }

            @Override
            public void onLoadFail(String errorMsg) {

            }
        });
    }

}
