package com.mac.stockwallet.profit.data;

import com.mac.stockwallet.homemain.data.HomeMenuDataSource;
import com.mac.stockwallet.homemain.data.HomeMenuRepository;
import com.mac.stockwallet.profit.data.model.ExchangeInfoModel;
import com.mac.stockwallet.profit.data.model.ExchangeModel;

import java.util.List;

/**
 * Created by kingdee on 2019-08-08.
 */
public class ExchangeRepository {

    public static ExchangeRepository getInstance(ExchangeDataSource mDataSource){
        return ExchangeRepository.INSTANCE.getInstance(mDataSource);
    }

    private static class INSTANCE{
        private static ExchangeRepository getInstance(ExchangeDataSource mDataSource){
            return new ExchangeRepository(mDataSource);
        }
    }

    private ExchangeDataSource mDataSource;

    private ExchangeRepository(ExchangeDataSource dataSource) {
        mDataSource = dataSource;
    }

    public void loadExchangeList(IExchangeCallback<List<ExchangeModel>> callback){
        mDataSource.loadExchangeList(callback);
    }

    public void loadExchangeInfo(String exchangeId, IExchangeCallback<ExchangeInfoModel> callback){
        mDataSource.loadExchangeInfoData(exchangeId,callback);
    }
}
