package com.iquantex.otc.response;

import java.util.Map;

public class ResultObj {

    private final static String SUCC_CODE = "200";
    private final static String FAIL_CODE = "500";
    private String code;
    private Object obj;

    public static ResultObj successReturn() {
        ResultObj resultObj = new ResultObj();
        resultObj.setCode(SUCC_CODE);
        return resultObj;
    }

    public static ResultObj failReturn() {
        ResultObj resultObj = new ResultObj();
        resultObj.setCode(FAIL_CODE);
        return resultObj;
    }

    public static ResultObj failReturn(Map<String, Object> obj) {
        ResultObj resultObj = new ResultObj();
        resultObj.setCode(FAIL_CODE);
        resultObj.setObj(obj);
        return resultObj;
    }

    public static ResultObj successReturn(Map<String, Object> obj) {
        ResultObj resultObj = new ResultObj();
        resultObj.setCode(SUCC_CODE);
        resultObj.setObj(obj);
        return resultObj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
