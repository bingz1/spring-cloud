package me.wantgo.common.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zxb on 7/1/16.
 * 返回统一数据格式.
 */
public class ReturnValue implements Serializable{

    private boolean success;   // 成功 true  失败 false

    private Object data;   //数据

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ReturnValue(boolean success, Object data){
        this.success = success;
        this.data = data;
    }

    public static ReturnValue generateTrueReturnValue(Object data){
        return new ReturnValue(true,data);
    }

    public static ReturnValue generateFalseReturnValue(int code, String error){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("code", code);
        data.put("error", error);
        return new ReturnValue(false,data);
    }

}
