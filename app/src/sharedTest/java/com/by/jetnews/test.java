package com.by.jetnews;


import androidx.annotation.NonNull;

import com.by.jetnews.data.request.APIRequest;
import com.by.jetnews.data.request.impl.APIRequestImpl;


import org.junit.Test;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

public class test {

    @Test
    public void test() {
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
