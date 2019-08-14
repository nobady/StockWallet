package com.mac.stockwallet.homemain.data;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.adapter.holder.BaseViewHolderManager;
import com.mac.stockwallet.R;
import com.mac.stockwallet.homemain.data.model.HomeMenuItem;
import com.mac.stockwallet.utils.ImageUtil;
import com.mac.stockwallet.utils.LogUtils;

import java.io.InputStream;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kingdee on 2019-08-05.
 */
public class HomeMenuHolder extends BaseViewHolderManager<HomeMenuItem> {
    @Override
    public void onBindViewHolder(BaseViewHolder holder, HomeMenuItem homeMenuItem) {
        ImageView iconHomeMenu = getView(holder.itemView, R.id.icon_home_menu);
        TextView textHomeMenu = getView(holder.itemView, R.id.text_home_menu);
        if (homeMenuItem.isSelected()){
            rxLoadAssetsImg(homeMenuItem.getIconNormal(),iconHomeMenu);
        }else {
            rxLoadAssetsImg(homeMenuItem.getIconNormal(),iconHomeMenu);
        }
        textHomeMenu.setText(homeMenuItem.getName());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.menu_item_layout;
    }

    @SuppressLint("CheckResult")
    private void rxLoadAssetsImg(final String fileName, final ImageView imageView){
        Observable.create(new ObservableOnSubscribe<Bitmap>() {
            @Override
            public void subscribe(ObservableEmitter<Bitmap> emitter) throws Exception {
                String filePath = "menu/image/"+fileName+".png";
                InputStream inputStream = imageView.getContext().getAssets().open(filePath);
                Bitmap bitmap = ImageUtil.getBitmap(inputStream);
                emitter.onNext(bitmap);
            }
        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Bitmap>() {
                @Override
                public void accept(Bitmap bitmap) throws Exception {
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    LogUtils.debug("加载menu图标失败"+throwable.getMessage());
                }
            });
    }
}
