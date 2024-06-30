package com.by.jetnews.data.request

import java.util.concurrent.CompletableFuture

interface APIRequest {
    suspend fun request(prompt : String): String
    fun getResponse(prompt : String, callBack: DataCallBack)
    fun requestP(prompt: String) : CompletableFuture<String>
}