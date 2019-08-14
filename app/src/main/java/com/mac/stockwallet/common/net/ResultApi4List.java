package com.mac.stockwallet.common.net;

import com.mac.stockwallet.utils.GsonTools;
import com.xuexiang.xhttp2.model.ApiResult;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * 返回结果是list时使用
 * Created by kingdee on 2019-08-09.
 */
public class ResultApi4List<T> extends ApiResult<T> {

    private int code;
    private String msg;
    private BaseModel<T> data;

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
       return data.getRecords();
    }

    @Override
    public ApiResult setData(T data) {
        if (this.data == null){
            this.data = new BaseModel<T>();
        }
        this.data.setRecords(data);
        return this;
    }
}
