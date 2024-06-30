package com.by.jetnews.data.request;

import com.alibaba.fastjson.JSON;
import com.by.jetnews.data.request.domain.Body;
import com.by.jetnews.data.request.domain.Data;

import java.util.Map;
import java.util.UUID;

/**
 * {@code @description} API 的配置信息
 */
public class APIConfig {

    public static final String APP_ID = "3038071334";

    public static final String APP_KEY = "iYUrbKQVQALkHlRT";

    public static final String DEFAULT_URI = "/vivogpt/completions";

    public static final String DEFAULT_DOMAIN = "api-ai.vivo.com.cn";

    public static final String DEFAULT_METHOD = "POST";

    public static String DEFAULT_MODEL = "vivo-BlueLM-TB";

    /**
     * {@code @description} 获取会话 ID
     * @return 会话 ID
     */
    public static String getSessionId() {
        return String.valueOf(UUID.randomUUID());
    }

    public static String getRequestId(){
        String requestId = String.valueOf(UUID.randomUUID());
        Map<String, Object> requestBody = Map.of(
                "requestId", requestId
        );
        return mapToQueryString(requestBody);
    }

    public static Map<String, Object> packageRequestBody(String prompt){
        Map<String, Object> requestBody = Map.of(
                "prompt", prompt,
                "model", DEFAULT_MODEL,
                "sessionId", getSessionId()
        );
        return requestBody;
    }

    public static String mapToQueryString(Map<String, Object> map) {
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder queryStringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (queryStringBuilder.length() > 0) {
                queryStringBuilder.append("&");
            }
            queryStringBuilder.append(entry.getKey());
            queryStringBuilder.append("=");
            queryStringBuilder.append(entry.getValue());
        }
        return queryStringBuilder.toString();
    }

    public static Body parseBody(String body){
        Body res = JSON.parseObject(body, Body.class);
        Data data = null;
        if (res.getCode() == 0) {
            data = JSON.parseObject(JSON.toJSONString(res.getData()), Data.class);
            res.setData(data);
        }
        return res;
    }
}
