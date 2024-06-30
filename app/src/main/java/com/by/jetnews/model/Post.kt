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

package com.by.jetnews.model

import androidx.annotation.DrawableRes

/**
 * {@code @description} 存储文章的数据类
 * @param id 文章的唯一标识符
 * @param title 文章的标题
 * @param subtitle 文章的副标题
 * @param url 文章的链接
 * @param publication 文章的发布信息
 * @param metadata 文章的元数据
 * @param paragraphs 文章的段落
 * @param imageId 文章的图片资源 ID
 * @param imageThumbId 文章的缩略图资源 ID
 * @constructor 创建一个文章
 */
data class Post(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val url: String,
    val publication: Publication? = null,
    val metadata: Metadata,
    val paragraphs: List<Paragraph> = emptyList(),
    @DrawableRes val imageId: Int,
    @DrawableRes val imageThumbId: Int
)

/**
 * {@code @description} 存储文章的元数据
 * @param author 文章的作者
 * @param date 文章的发布日期
 * @param readTimeMinutes 阅读文章所需的时间（分钟）
 * @constructor 创建文章的元数据
 */
data class Metadata(
    val author: PostAuthor,
    val date: String,
    val readTimeMinutes: Int
)

/**
 * {@code @description} 存储文章的作者
 * @param name 作者的名字
 * @param url 作者的链接
 * @constructor 创建一个作者
 */
data class PostAuthor(
    val name: String,
    val url: String? = null
)

/**
 * {@code @description} 存储文章的发布信息
 * @param name 发布信息的名字
 * @param logoUrl 发布信息的 logo URL
 * @constructor 创建一个发布信息
 */
data class Publication(
    val name: String,
    val logoUrl: String
)

/**
 * {@code @description} 存储文章的段落
 * @param type 段落的类型
 * @param text 段落的文本
 * @param markups 段落的标记
 * @constructor 创建一个段落
 */
data class Paragraph(
    val type: ParagraphType,
    val text: String,
    val markups: List<Markup> = emptyList()
)

/**
 * {@code @description} 存储文章的标记
 * @param type 标记的类型
 * @param start 标记的开始位置
 * @param end 标记的结束位置
 * @param href 标记的链接
 * @constructor 创建一个标记
 */
data class Markup(
    val type: MarkupType,
    val start: Int,
    val end: Int,
    val href: String? = null
)

/**
 * {@code @description} 标记的类型
 * @property Link 链接
 * @property Code 代码
 * @property Italic 斜体
 * @property Bold 粗体
 */
enum class MarkupType {
    Link,
    Code,
    Italic,
    Bold,
}

/**
 * {@code @description} 段落的类型
 * @property Title 标题
 * @property Caption 标题
 * @property Header 标题
 * @property Subhead 标题
 * @property Text 文本
 * @property CodeBlock 代码块
 * @property Quote 引用
 * @property Bullet 列表
 */
enum class ParagraphType {
    Title,
    Caption,
    Header,
    Subhead,
    Text,
    CodeBlock,
    Quote,
    Bullet,
}
