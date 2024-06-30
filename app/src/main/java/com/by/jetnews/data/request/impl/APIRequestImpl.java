package com.by.jetnews.data.request.impl;

import static com.by.jetnews.data.request.APIConfig.APP_ID;
import static com.by.jetnews.data.request.APIConfig.APP_KEY;
import static com.by.jetnews.data.request.APIConfig.DEFAULT_DOMAIN;
import static com.by.jetnews.data.request.APIConfig.DEFAULT_METHOD;
import static com.by.jetnews.data.request.APIConfig.DEFAULT_URI;
import static com.by.jetnews.data.request.APIConfig.getRequestId;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.by.jetnews.data.request.APIConfig;
import com.by.jetnews.data.request.APIRequest;
import com.by.jetnews.data.request.DataCallBack;
import com.by.jetnews.data.request.VivoAuth;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import kotlin.coroutines.Continuation;

public class APIRequestImpl implements APIRequest {
    @Nullable
    @Override
    public Object request(@NonNull String prompt, @NonNull Continuation<? super String> $completion) {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                String res = request(prompt);
                $completion.resumeWith(res);
                return res;
            } catch (UnsupportedEncodingException | JsonProcessingException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            return "1null";
        });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return "2null";
    }

    public void getResponse(String data, DataCallBack callBack) {
        CompletableFuture.supplyAsync(() -> {
            try {
                String res = request(data);
                Thread.sleep(10000);
                callBack.onSuccess(res);
                return res;
            } catch (UnsupportedEncodingException | JsonProcessingException | InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            return null;
        });
    }

    private String request(String prompt) throws UnsupportedEncodingException, JsonProcessingException {
        String queryStr = getRequestId();
        // 生成认证头
        HttpHeaders headers = VivoAuth.generateAuthHeaders(APP_ID, APP_KEY, DEFAULT_METHOD, DEFAULT_URI, queryStr);
        headers.add("Content-Type", "application/json");
        String url = String.format("https://%s%s?%s", DEFAULT_DOMAIN, DEFAULT_URI, queryStr);
        String requsetBodyString = new ObjectMapper().writeValueAsString(APIConfig.packageRequestBody(prompt));
        RestTemplate restTemplate = new RestTemplate();
        // 发送请求
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        httpHeaders.addAll(headers);
        HttpEntity<String> requestEntity = new HttpEntity<>(requsetBodyString, httpHeaders);
        System.out.println("Request entity: " + requestEntity);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Response body: " + response.getBody());
        } else {
            System.out.println("Error response: " + response.getStatusCode());
        }
        return response.getBody();
    }

    @NonNull
    @Override
    public CompletableFuture<String> requestP(@NonNull String prompt) {
        CompletableFuture<String> future = new CompletableFuture<>();
        // 模拟网络请求，例如使用 HttpClient 发送请求
        new Thread(() -> {
            try {
                // 假设这里是网络请求的代码，并得到了响应字符串
                String response = request(prompt);
                future.complete(response);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }).start();
        return future;
    }
}
