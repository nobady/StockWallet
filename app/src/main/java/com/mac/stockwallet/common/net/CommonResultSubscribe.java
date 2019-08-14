package com.mac.stockwallet.common.net;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ParseException;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.JsonParseException;
import com.mac.stockwallet.BuildConfig;
import com.mac.stockwallet.R;
import com.mac.stockwallet.SwApplication;
import com.mac.stockwallet.common.dialog.LoadingDialog;
import com.mac.stockwallet.utils.LogUtils;
import com.mac.stockwallet.utils.ToastUtils;
import com.xuexiang.xhttp2.exception.ApiException;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by kingdee on 2019-08-09.
 */
public class CommonResultSubscribe<T> implements Observer<T> {


    private Context mCtx;
    //加载dialog
    private LoadingDialog waitingDialog;
    private boolean isShowWaitDialog;

    public void setShowWaitDialog(boolean showWaitDialog) {
        isShowWaitDialog = showWaitDialog;
    }

    public void setmCtx(Context mCtx) {
        this.mCtx = mCtx;
    }

    /**
     * 对 onError进行处理
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        if(isShowWaitDialog){
            dismissDialog();
        }
        Throwable throwable = e;

        if(BuildConfig.DEBUG){
            LogUtils.debug(throwable.getMessage());
        }
        /**
         * 获取根源 异常
         */
        while (throwable.getCause() != null){
            e = throwable;
            throwable = throwable.getCause();
        }
        //服务器返回的错误
       if(e instanceof ApiException){
            onResultError((ApiException) e);
        }
    }
    /**
     * 服务器返回的错误
     * @param ex
     */
    protected  void onResultError(ApiException ex){
        //服务器返回code默认处理
        switch (ex.getCode()){
            case 401:
                ToastUtils.showMessage(SwApplication.getContext(), R.string.imi_login_input_mail_error);
                break;
            case 503:
                ToastUtils.showMessage(SwApplication.getContext(), R.string.imi_const_tip_charge);
                break;
            case 500:
                ToastUtils.showMessage(SwApplication.getContext(), R.string.imi_server_error);
                break;
            default:
                String msg = ex.getMessage();
                if(TextUtils.isEmpty(msg)){
                    ToastUtils.showMessage(SwApplication.getContext(), R.string.imi_toast_common_net_error);
                }else {
                    ToastUtils.showMessage(SwApplication.getContext(), msg);
                }
        }

    }

    private void dismissDialog(){
        if(waitingDialog!=null) {
            if(waitingDialog.isShowing()) {
                waitingDialog.dissmissDialog();
            }
        }
    }

    private void showWaitDialog(){
        if (waitingDialog == null) {
            waitingDialog = LoadingDialog.getInstance();
        }
        waitingDialog.showDefaultLoading(SwApplication.getContext());
    }



    @Override
    public void onSubscribe(Disposable d) {
        if(isShowWaitDialog){
            showWaitDialog();
        }
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onComplete() {
        if(isShowWaitDialog){
            dismissDialog();
        }
    }
}
