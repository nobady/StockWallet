package com.mac.stockwallet.profit.data;

import android.annotation.SuppressLint;

import com.mac.stockwallet.common.net.CommonRequest;
import com.mac.stockwallet.common.net.CommonResultSubscribe;
import com.mac.stockwallet.common.net.NetApiService;
import com.mac.stockwallet.profit.ExchangeSharePrefs;
import com.mac.stockwallet.profit.data.model.ExchangeInfoModel;
import com.mac.stockwallet.profit.data.model.ExchangeModel;
import com.xuexiang.xhttp2.XHttp;
import com.xuexiang.xhttp2.request.CustomRequest;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kingdee on 2019-08-08.
 */
public class ExchangeDataSource {

    @SuppressLint("CheckResult")
    /**
     * 获取交易所列表
     */
    public void loadExchangeList(final IExchangeCallback<List<ExchangeModel>> callback){
        CommonRequest request = (CommonRequest) XHttp.custom();
        request.apiCall2(request.create(NetApiService.class).getExchangeList()).subscribeWith(
            new CommonResultSubscribe<List<ExchangeModel>>(){
                @Override
                public void onNext(List<ExchangeModel> exchangeModelList) {
                    callback.onLoadSuccess(exchangeModelList);
                }
            });

        //请求实际接口，目前先以测试数据为准
        List<ExchangeModel> modelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExchangeModel model = new ExchangeModel();
            model.setExchangeId(i);
            model.setName("Binance"+i);
            model.setInfo("支持导入资产和交易"+i);
            modelList.add(model);
        }
        callback.onLoadSuccess(modelList);
    }

    @SuppressLint("CheckResult")
    /**
     * 获取交易所信息
     */
    public void loadExchangeInfoData(final String exchangeID, final IExchangeCallback<ExchangeInfoModel> callback){
        CommonRequest request = (CommonRequest) XHttp.custom();
        request.apiCall2(request.create(NetApiService.class).getExchangeMoney(
            exchangeID, ExchangeSharePrefs.getApiKey(),ExchangeSharePrefs.getSecretKey(),ExchangeSharePrefs.getPassphrase()))
            .subscribeWith(
            new CommonResultSubscribe<ExchangeInfoModel>(){
                @Override
                public void onNext(ExchangeInfoModel exchangeInfoModel) {
                    callback.onLoadSuccess(exchangeInfoModel);
                }
            });
    }
}
