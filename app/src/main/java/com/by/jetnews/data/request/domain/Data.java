package com.by.jetnews.data.request.domain;

public class Data {
    // 请求返回结果的内容
    private String content;
    // 会话 ID
    private String sessionId;
    // 请求 ID
    private String requestId;
    // 请求的提供者
    private String provider;
    // 请求的模型
    private String model;

    public Data() {
    }

    public Data(String content, String sessionId, String requestId, String provider, String model) {
        this.content = content;
        this.sessionId = sessionId;
        this.requestId = requestId;
        this.provider = provider;
        this.model = model;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
