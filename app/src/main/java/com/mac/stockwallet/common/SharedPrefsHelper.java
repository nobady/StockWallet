package com.mac.stockwallet.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mac.stockwallet.SwApplication;

import java.util.Map;
import java.util.Set;

/**
 * SharedPreferences工具类
 *
 * @author
 */
public class SharedPrefsHelper {
    private static final String TAG = "SharedPrefsHelper";

    private Context mContext;
    private static String COMMON_NAME = "wallet_common";
    private SharedPreferences sp;
    private Editor mEditor;

    public SharedPrefsHelper() {
        this(COMMON_NAME, Context.MODE_PRIVATE);
    }

    public SharedPrefsHelper(String name) {
        this(name, Context.MODE_PRIVATE);
    }

    /**
     * 创建一个工具类，默认打开名字为name的SharedPreferences实例
     *
     * @param name 唯一标识
     * @param mode 权限标识
     */
    private SharedPrefsHelper(String name, int mode) {
        mContext = SwApplication.getContext();
        sp = mContext.getSharedPreferences(name, mode);
    }

    public SharedPreferences getSp() {
        return sp;
    }

    /**
     * 添加信息到SharedPreferences
     */
    public void add(Map<String, String> values) {
        mEditor = sp.edit();
        for (Map.Entry<String, String> value : values.entrySet()) {
            mEditor.putString(value.getKey(), value.getValue());
        }
        mEditor.commit();
    }

    /**
     * 删除信息
     */
    public void deleteAll() {
        mEditor = sp.edit();
        mEditor.clear();
        mEditor.commit();
    }

    /**
     * 删除一条信息
     */
    public void delete(String key) {
        mEditor = sp.edit();
        mEditor.remove(key);
        mEditor.commit();
    }

    public boolean putStringValue(String key, String value) {
        mEditor = sp.edit();
        mEditor.putString(key, value);
        return mEditor.commit();
    }

    /**
     * 获取信息
     */
    public String getStringValue(String key, String defaultStr) {
        if (sp != null) {
            return sp.getString(key, defaultStr);
        }
        return "";
    }

    public String getStringValue(String key) {
        return sp.getString(key, null);
    }

    public void putLongValue(String key, long value) {
        mEditor = sp.edit();
        mEditor.putLong(key, value);
        mEditor.commit();
    }

    public long getLongValue(String key) {
        return sp.getLong(key, 0);
    }

    public long getLongValue(String key, long defValue) {
        return sp.getLong(key, defValue);
    }

    public void putIntValue(String key, int value) {
        mEditor = sp.edit();
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public int getIntValue(String key) {
        return sp.getInt(key, 0);
    }

    public int getIntValue(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public void putBooleanValue(String key, boolean flag) {
        mEditor = sp.edit();
        mEditor.putBoolean(key, flag);
        mEditor.commit();
    }

    public boolean getBooleanValue(String key) {
        return sp.getBoolean(key, false);
    }

    public boolean getBooleanValue(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    public void putStringSet(String key, Set<String> values) {
        mEditor = sp.edit();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mEditor.putStringSet(key, values);
            mEditor.commit();
        } else {
            try {
                mEditor.putString(key, new Gson().toJson(values));
                mEditor.commit();
            } catch (Exception e) {
            }
        }
    }

    public Set<String> getStringSet(String key, Set<String> defValues) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return sp.getStringSet(key, defValues);
        }

        String jsonStr = sp.getString(key, null);
        if (jsonStr == null) {
            return defValues;
        }

        try {
            return new Gson().fromJson(jsonStr, new TypeToken<Set<String>>() {
            }.getType());
        } catch (Exception e) {
            return defValues;
        }
    }

    public boolean contains(String key) {
        return sp.contains(key);
    }

    /**
     * 获取此SharedPreferences的Editor实例
     */
    public Editor getEditor() {
        return sp.edit();
    }
}
