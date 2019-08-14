package com.mac.stockwallet.common.net;

import com.xuexiang.xhttp2.model.ApiResult;
import com.xuexiang.xhttp2.request.CustomRequest;
import com.xuexiang.xhttp2.transform.HttpResultTransformer;
import com.xuexiang.xhttp2.transform.HttpSchedulersTransformer;
import com.xuexiang.xhttp2.transform.func.RetryExceptionFunc;

import io.reactivex.Observable;

/**
 * Created by kingdee on 2019-08-09.
 */
public class CommonRequest extends CustomRequest {

    public <T> Observable<T> apiCall2(Observable<ResultApi<T>> observable){
        return observable
            .compose(new HttpResultTransformer())
            .compose(new HttpSchedulersTransformer(mIsSyncRequest, mIsOnMainThread))
            .retryWhen(new RetryExceptionFunc(mRetryCount, mRetryDelay, mRetryIncreaseDelay));
    }
    public <T> Observable<T> apiCall2List(Observable<ResultApi4List<T>> observable){
        return observable
            .compose(new HttpResultTransformer())
            .compose(new HttpSchedulersTransformer(mIsSyncRequest, mIsOnMainThread))
            .retryWhen(new RetryExceptionFunc(mRetryCount, mRetryDelay, mRetryIncreaseDelay));
    }
}
