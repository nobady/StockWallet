package com.mac.stockwallet.profit.data;

import com.mac.stockwallet.profit.data.model.ExchangeModel;

import java.util.List;

/**
 * Created by kingdee on 2019-08-08.
 */
public interface IExchangeCallback<T> {
    void onLoadSuccess(T exchangeModelList);
    void onLoadFail(String errorMsg);
}
