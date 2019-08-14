package com.mac.stockwallet.common.net;

import com.xuexiang.xhttp2.model.ApiResult;


/**
 * Created by kingdee on 2019-08-09.
 */
public class ResultApi<T> extends ApiResult<T> {

    private int code;
    private String msg;
    private T data;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public ApiResult setCode(int code) {
        this.code = code;
        return this;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public ApiResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public ApiResult setData(T data) {
        this.data = data;
        return this;
    }
}
