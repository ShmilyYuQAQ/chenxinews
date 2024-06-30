/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.by.jetnews.data.interests.impl

import com.by.jetnews.data.Result
import com.by.jetnews.data.interests.InterestSection
import com.by.jetnews.data.interests.InterestsRepository
import com.by.jetnews.data.interests.TopicSelection
import com.by.jetnews.data.request.APIConfig
import com.by.jetnews.data.request.APIRequest
import com.by.jetnews.data.request.domain.Body
import com.by.jetnews.data.request.domain.Data
import com.by.jetnews.data.request.impl.APIRequestImpl
import com.by.jetnews.utils.addOrRemove
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CompletableFuture

/**
 * Implementation of InterestRepository that returns a hardcoded list of
 * topics, people and publications synchronously.
 */
@OptIn(ExperimentalCoroutinesApi::class)
class FakeInterestsRepository : InterestsRepository {

    /**
     * {@code @description} 话题
     */
    private val topics by lazy {
        listOf(
            InterestSection("请你依次为“\"赛龙舟\", \"剪纸\", \"皮影戏\",\"剪纸\",\"川剧\"写一段简短介绍词。每段介绍词之间不要分段，用分号隔开。并在最后加上说明，说明以上介绍由Vivo蓝心千询生成，最后再加一段说明，您可以选择您感兴趣的非遗文化加入收藏“", listOf("赛龙舟", "剪纸", "皮影戏","剪纸","川剧")),
            InterestSection(
                "请你依次为非遗城市\"北京\", \"西安\", \"南京\", \"景德镇\",\"江西\"写一段简短介绍词，每段介绍词之间不要分段，用分号隔开。并在最后加上说明，说明以上介绍由Vivo蓝心千询生成，最后再加一段说明，您可以选择您感兴趣的非遗文化城市加入收藏",
                listOf("北京", "西安", "南京", "景德镇","江西")
            ),
        )
    }

    /**
     * {@code @description} 人物
     */
    private val people by lazy {
        listOf(
            "中华人民共和国文化和旅游部",
            "中国非物质文化遗产保护中心",
            "中国非物质文化遗产保护协会",
            "联合国教科文组织",
            "联合国教科文组织活态遗产处",
        )
    }

    /**
     * {@code @description} 出版物
     */
    private val publications by lazy {
        listOf(
            "人民日报",
            "新华网",
            "光明日报",
            "文旅中国",
            "中国文化报"
        )
    }

    // for now, keep the selections in memory
    private val selectedTopics = MutableStateFlow(setOf<TopicSelection>())
    private val selectedPeople = MutableStateFlow(setOf<String>())
    private val selectedPublications = MutableStateFlow(setOf<String>())

    /**
     * {@code @description} 获取话题
     */
    override suspend fun getTopics(): Result<List<InterestSection>> {
        val apiRequest : APIRequest = APIRequestImpl()
        topics.forEach {

//            apiRequest.getResponse(it.title
//            ) { body ->
//                run {
//                    body as Body
//                    val data: Data = body.data as Data
//                    it.title = data.content
//                }
//            }
            fun main() = runBlocking {
                val res = apiRequest.requestP(it.title)
                val deferred = res.toDeferred()
                try {
                    val result = deferred.await()
                    println("Result from network request: $result")
                    val body = APIConfig.parseBody(result) as Body
                    val data = body.data as Data
                    data.content
                } catch (e: Exception) {
                    e.printStackTrace()
                    "null"
                }
            }

            it.title = main()

//            it.title = runBlocking {

//                                         val res = apiRequest.requestP(it.title) ?: return@runBlocking it.title
//                res
//                val body = APIConfig.parseBody(res)
//                val data = body.data
//                if (body.code == 0) {
//                    data as Data
//                    data.content
//                } else {
//                    it.title
//                }
//            }
        }
        return Result.Success(topics)
    }

    fun <T> CompletableFuture<T>.toDeferred(): CompletableDeferred<T> {
        val deferred = CompletableDeferred<T>()
        whenComplete { result, throwable ->
            if (throwable == null) {
                deferred.complete(result)
            } else {
                deferred.completeExceptionally(throwable)
            }
        }.exceptionally {
            deferred.completeExceptionally(it)
            null
        }
        return deferred
    }

    override suspend fun getPeople(): Result<List<String>> {
        return Result.Success(people)
    }

    override suspend fun getPublications(): Result<List<String>> {
        return Result.Success(publications)
    }

    override suspend fun toggleTopicSelection(topic: TopicSelection) {
        selectedTopics.update {
            it.addOrRemove(topic)
        }
    }

    override suspend fun togglePersonSelected(person: String) {
        selectedPeople.update {
            it.addOrRemove(person)
        }
    }

    override suspend fun togglePublicationSelected(publication: String) {
        selectedPublications.update {
            it.addOrRemove(publication)
        }
    }

    override fun observeTopicsSelected(): Flow<Set<TopicSelection>> = selectedTopics

    override fun observePeopleSelected(): Flow<Set<String>> = selectedPeople

    override fun observePublicationSelected(): Flow<Set<String>> = selectedPublications
}
