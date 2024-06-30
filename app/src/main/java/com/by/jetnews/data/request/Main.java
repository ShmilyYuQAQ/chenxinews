package com.by.jetnews.data.request;

import androidx.annotation.NonNull;

import com.by.jetnews.data.request.impl.APIRequestImpl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

public class Main {
    public static void main(String[] args) {
        APIRequest apiRequest = new APIRequestImpl();
        apiRequest.request("Hello, Vivo", new Continuation<String>() {
            @NonNull
            @Override
            public CoroutineContext getContext() {
                return null;
            }

            @Override
            public void resumeWith(@NonNull Object o) {
                System.out.println("Response: " + o);
            }
        });
    }
}
