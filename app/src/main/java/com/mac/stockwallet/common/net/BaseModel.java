package com.mac.stockwallet.common.net;

/**
 * Created by kingdee on 2019-08-13.
 */
public class BaseModel<T> {
    private T records;

    public T getRecords() {
        return records;
    }

    public void setRecords(T records) {
        this.records = records;
    }
}
