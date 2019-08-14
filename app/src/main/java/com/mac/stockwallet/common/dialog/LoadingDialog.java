package com.mac.stockwallet.common.dialog;


import android.content.Context;
import android.content.DialogInterface;

import com.kaopiz.kprogresshud.KProgressHUD;

/**
 * Created by kingdee on 2019-08-10.
 */
public class LoadingDialog {

    private KProgressHUD mProgressHUD;

    public static LoadingDialog getInstance(){
        return INSTANCE.instance;
    }

    private static class INSTANCE{
        private static LoadingDialog instance = new LoadingDialog();
    }

    private LoadingDialog(){}

    public void showDefaultLoading(Context context){
        if (mProgressHUD!=null&&mProgressHUD.isShowing()){
            mProgressHUD.dismiss();
        }
        showLoading(context,"加载中...",false,null);
    }

    private void showLoading(Context context,
                             String title,
                             Boolean isCancelable,
                             DialogInterface.OnCancelListener onCancelListener) {

        initLoadingDialog(context, title);

        if (isCancelable != null) {
            mProgressHUD.setCancellable(isCancelable);
        }

        if (onCancelListener != null) {
            mProgressHUD.setCancellable(onCancelListener);
        }
        try {
            mProgressHUD.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isShowing(){
        return mProgressHUD!=null&&mProgressHUD.isShowing();
    }

    private void initLoadingDialog(Context context,String msg){
        mProgressHUD = KProgressHUD.create(context).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setLabel(msg);

        mProgressHUD.setCancellable(false);
    }

    public void dissmissDialog(){
        if (mProgressHUD!=null&&mProgressHUD.isShowing()){
            mProgressHUD.dismiss();
        }
    }
}
