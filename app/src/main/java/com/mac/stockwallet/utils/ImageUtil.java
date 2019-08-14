package com.mac.stockwallet.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.InputStream;

/**
 * Created by kingdee on 2019-08-05.
 */
public class ImageUtil {

    public static Bitmap getBitmap(InputStream inputStream){
        if(inputStream==null){
            return null;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    public static void displayImg(Context context, String imgUrl, ImageView imageView,int placeResId){
        Glide.with(context).load(imgUrl).placeholder(placeResId).into(imageView);
    }

}
