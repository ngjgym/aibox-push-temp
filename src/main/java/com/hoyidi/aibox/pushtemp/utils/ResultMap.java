package com.hoyidi.aibox.pushtemp.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author Boom
 */
@Component
@Data
public class ResultMap {

    // 响应业务状态
    private String code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;


    /**
     * 成功
     *
     * @return
     */
    public static ResultMap success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultMap success(Object data) {
        ResultMap rb = new ResultMap();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMsg(CommonEnum.SUCCESS.getResultMsg());
        rb.setData(data);
        return rb;
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultMap success(Object data,String msg) {
        ResultMap rb = new ResultMap();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMsg(msg);
        rb.setData(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultMap error(BaseResultInfoInterface errorInfo) {
        ResultMap rb = new ResultMap();
        rb.setCode(errorInfo.getResultCode());
        rb.setMsg(errorInfo.getResultMsg());
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultMap error(String code, String msg) {
        ResultMap rb = new ResultMap();
        rb.setCode(code);
        rb.setMsg(msg);
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultMap error(String msg) {
        ResultMap rb = new ResultMap();
        rb.setCode("500");
        rb.setMsg(msg);
        rb.setData(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}