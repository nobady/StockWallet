package com.mac.ui_library.titlebar.style;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.mac.ui_library.R;
import com.mac.ui_library.titlebar.SelectorDrawable;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/TitleBar
 *    time   : 2018/08/20
 *    desc   : 默认日间主题样式实现（布局属性：app:barStyle="light"）
 */
public class TitleBarLightStyle extends BaseTitleBarStyle {

    public TitleBarLightStyle(Context context) {
        super(context);
    }

    @Override
    public Drawable getBackground() {
        return new ColorDrawable(0xFFFFFFFF);
    }

    @Override
    public Drawable getBackIcon() {
        return getDrawable(R.mipmap.bar_icon_back_black);
    }

    @Override
    public int getLeftColor() {
        return 0xFF666666;
    }

    @Override
    public int getTitleColor() {
        return 0xFF222222;
    }

    @Override
    public int getFirstRightColor() {
        return 0xFFA4A4A4;
    }

    @Override
    public int getSecondRightColor() {
        return 0xFFA4A4A4;
    }

    @Override
    public boolean isLineVisible() {
        return true;
    }

    @Override
    public Drawable getLineDrawable() {
        return new ColorDrawable(0xFFECECEC);
    }

    @Override
    public Drawable getLeftBackground() {

        return new SelectorDrawable.Builder()
                .setDefault(new ColorDrawable(0x00000000))
                .setFocused(new ColorDrawable(0x0C000000))
                .setPressed(new ColorDrawable(0x0C000000))
                .builder();
    }

    @Override
    public float getFirstRightSize() {
        return 0;
    }

    @Override
    public float getSecondRightSize() {
        return 0;
    }

    @Override
    public Drawable getFirstRightBackground() {
        return getLeftBackground();
    }

    @Override
    public Drawable getSecondRightBackground() {
        return getLeftBackground();
    }
}