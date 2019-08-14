package com.mac.stockwallet.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.mac.stockwallet.SwApplication;

/**
 * Toast工具, 解决Toast延迟弹出问题.
 *
 * @author
 * @since 2013-10-25
 */
public class ToastUtils {

    private static Handler handler = new Handler(Looper.getMainLooper());

    private static Toast toast = null;

    public static void cancelMessage() {
        if (toast != null) {
            toast.cancel();
        }
    }

    public static void showMessage(final Context context, final CharSequence msg) {
        showMessage(context, msg, Toast.LENGTH_SHORT);
    }

    public static void showMessageLong(final Context context, final CharSequence msg) {
        showMessage(context, msg, Toast.LENGTH_LONG);
    }

    public static void showMessage(final Context context, final CharSequence msg,
                                   final int len) {


        handler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        if (toast == null) {
                            toast = Toast.makeText(SwApplication.getContext(), msg, len);
                        }
                        toast.setText(msg);
                        toast.setDuration(len);
                        toast.show();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        });

    }

    public static void showMessage(final Context context, final int msg) {
        showMessage(context, msg, Toast.LENGTH_SHORT);
    }

    public static void showMessageLong(final Context context, final int msg) {
        showMessage(context, msg, Toast.LENGTH_SHORT);
    }

    public static void showMessage(final Context context, final int msg,
                                   final int len) {
        if (context == null) {
            return;
        }
        showMessage(context, context.getString(msg), len);
    }

    public static void show_net_prompt(Context activity, String content) {
        showMessage(activity, content);
    }

    public static void showScreenCenterMessage(int msgRes){
        Toast toast = Toast.makeText(SwApplication.getContext(),msgRes, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

}
