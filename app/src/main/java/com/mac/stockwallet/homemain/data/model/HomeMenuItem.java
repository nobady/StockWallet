package com.mac.stockwallet.homemain.data.model;

import android.text.TextUtils;

/**
 * Created by kingdee on 2019-08-02.
 */
public class HomeMenuItem {

    private String key;
    private String type;
    private String name;
    private String nameEn;
    private int iconStyle;
    private String iconNormal;
    private String iconFocus;
    public boolean selected;
    public MenuType mMenuType;

    public void initMenuType(){
        if (TextUtils.equals(key,MenuType.PROFIT.getKey())){
            mMenuType = MenuType.PROFIT;
        }else if (TextUtils.equals(key,MenuType.BUSINESS.getKey())){
            mMenuType = MenuType.BUSINESS;
        }else if (TextUtils.equals(key,MenuType.ME.getKey())){
            mMenuType = MenuType.ME;
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int getIconStyle() {
        return iconStyle;
    }

    public void setIconStyle(int iconStyle) {
        this.iconStyle = iconStyle;
    }

    public String getIconNormal() {
        return iconNormal;
    }

    public void setIconNormal(String iconNormal) {
        this.iconNormal = iconNormal;
    }

    public String getIconFocus() {
        return iconFocus;
    }

    public void setIconFocus(String iconFocus) {
        this.iconFocus = iconFocus;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
