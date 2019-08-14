package com.mac.stockwallet.common.net;

import com.mac.stockwallet.profit.data.model.ExchangeInfoModel;
import com.mac.stockwallet.profit.data.model.ExchangeModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

/**
 * Created by kingdee on 2019-08-09.
 */
public interface NetApiService {

    @GET("/app/public/active")
     Observable<ResultApi> active(@Query("code") String code,@Query("deviceid") String deviceid);

    @GET("/app/business/exchange/page")
    Observable<ResultApi<List<ExchangeModel>>> getExchangeList();

    @GET("/app/business/exchange/{exchangeId}")
    Observable<ResultApi> getExchangeInfo(@Path("exchangeId") String exchangeId);

    @GET("/app/user/property")
    Observable<ResultApi<ExchangeInfoModel>> getExchangeMoney(@Query("exchangeId") String exchangeId, @Query("apiKey") String apiKey,
                                                              @Query("secretKey")String secretKey, @Query("passphrase") String passphrase);


}
