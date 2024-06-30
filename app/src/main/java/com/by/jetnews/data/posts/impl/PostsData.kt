/*
 * Copyright 2022 The Android Open Source Project
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

@file:Suppress("ktlint:max-line-length") // String constants read better
package com.by.jetnews.data.posts.impl

import com.by.jetnews.R
import com.by.jetnews.model.Markup
import com.by.jetnews.model.MarkupType
import com.by.jetnews.model.Metadata
import com.by.jetnews.model.Paragraph
import com.by.jetnews.model.ParagraphType
import com.by.jetnews.model.Post
import com.by.jetnews.model.PostAuthor
import com.by.jetnews.model.PostsFeed
import com.by.jetnews.model.Publication

/**
 * Define hardcoded posts to avoid handling any non-ui operations.
 */

val pietro = PostAuthor("Pietro Maggi", "https://medium.com/@pmaggi")
val manuel = PostAuthor("Manuel Vivo", "https://medium.com/@manuelvicnt")
val florina = PostAuthor(
    "Florina Muntenescu",
    "https://medium.com/@florina.muntenescu"
)
val jose =
    PostAuthor("Jose Alcérreca", "https://medium.com/@JoseAlcerreca")
val china_culture = PostAuthor("中国文化报", "https://medium.com/@JoseAlcerreca")
val renmin_newspaper = PostAuthor("人民日报", "https://medium.com/@JoseAlcerreca")
val china_wenlv = PostAuthor("中国文旅", "https://medium.com/@JoseAlcerreca")
val xinhuashe = PostAuthor("新华社", "https://medium.com/@JoseAlcerreca")
val publication = Publication(
    "Bian Yu & Ma Chenxi",
    "https://cdn-images-1.medium.com/max/258/1*u7oZc2_5mrkcFaxkXEyfYA@2x.png"
)
val paragraphsPost1 = listOf(
    Paragraph(
        ParagraphType.Text,
        "Working to make our Android application more modular, I ended up with a sample that included a set of on-demand features grouped inside a folder:"
    ),
    Paragraph(
        ParagraphType.Text,
        "Pretty standard setup, all the on-demand modules, inside a “features” folder; clean."
    ),
    Paragraph(
        ParagraphType.Text,
        "These modules are included in the settings.gradle file as:"
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        "include ':app'\n" +
            "include ':features:module1'\n" +
            "include ':features:module2'\n" +
            "include ':features:module3'\n" +
            "include ':features:module4'"
    ),
    Paragraph(
        ParagraphType.Text,
        "These setup works nicely with a single “minor” issue: an empty module named features in the Android view in Android Studio:"
    ),
    Paragraph(
        ParagraphType.Text,
        "I can live with that, but I would much prefer to remove that empty module from my project!"
    ),
    Paragraph(
        ParagraphType.Header,
        "If you cannot remove it, just rename it!"
    ),

    Paragraph(
        ParagraphType.Text,
        "At I/O I was lucky enough to attend the “Android Studio: Tips and Tricks” talk where Ivan Gravilovic, from Google, shared some amazing tips. One of these was a possible solution for my problem: setting a custom path for my modules.",
        listOf(
            Markup(
                MarkupType.Italic,
                41,
                72
            )
        )
    ),

    Paragraph(
        ParagraphType.Text,
        "In this particular case our settings.gradle becomes:",
        listOf(Markup(MarkupType.Code, 28, 43))
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        """
        include ':app'
        include ':module1'
        include ':module1'
        include ':module1'
        include ':module1'
        """.trimIndent()
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        """
        // Set a custom path for the four features modules.
        // This avoid to have an empty "features" module in  Android Studio.
        project(":module1").projectDir=new File(rootDir, "features/module1")
        project(":module2").projectDir=new File(rootDir, "features/module2")
        project(":module3").projectDir=new File(rootDir, "features/module3")
        project(":module4").projectDir=new File(rootDir, "features/module4")
        """.trimIndent()
    ),
    Paragraph(
        ParagraphType.Text,
        "And the layout in Android Studio is now:"
    ),
    Paragraph(
        ParagraphType.Header,
        "Conclusion"
    ),
    Paragraph(
        ParagraphType.Text,
        "As the title says, this is really a small thing, but it helps keep my project in order and it shows how a small Gradle configuration can help keep your project tidy."
    ),
    Paragraph(
        ParagraphType.Quote,
        "You can find this update in the latest version of the on-demand modules codelab.",
        listOf(
            Markup(
                MarkupType.Link,
                54,
                79,
                "https://codelabs.developers.google.com/codelabs/on-demand-dynamic-delivery/index.html"
            )
        )
    ),
    Paragraph(
        ParagraphType.Header,
        "Resources"
    ),
    Paragraph(
        ParagraphType.Bullet,
        "Android Studio: Tips and Tricks (Google I/O’19)",
        listOf(
            Markup(
                MarkupType.Link,
                0,
                47,
                "https://www.youtube.com/watch?v=ihF-PwDfRZ4&list=PLWz5rJ2EKKc9FfSQIRXEWyWpHD6TtwxMM&index=32&t=0s"
            )
        )
    ),

    Paragraph(
        ParagraphType.Bullet,
        "On Demand module codelab",
        listOf(
            Markup(
                MarkupType.Link,
                0,
                24,
                "https://codelabs.developers.google.com/codelabs/on-demand-dynamic-delivery/index.html"
            )
        )
    ),
    Paragraph(
        ParagraphType.Bullet,
        "Patchwork Plaid — A modularization story",
        listOf(
            Markup(
                MarkupType.Link,
                0,
                40,
                "https://medium.com/androiddevelopers/a-patchwork-plaid-monolith-to-modularized-app-60235d9f212e"
            )
        )
    )
)

val paragraphsPost2 = listOf(
    Paragraph(
        ParagraphType.Text,
        "Dagger is a popular Dependency Injection framework commonly used in Android. It provides fully static and compile-time dependencies addressing many of the development and performance issues that have reflection-based solutions.",
        listOf(
            Markup(
                MarkupType.Link,
                0,
                6,
                "https://dagger.dev/"
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "This month, a new tutorial was released to help you better understand how it works. This article focuses on using Dagger with Kotlin, including best practices to optimize your build time and gotchas you might encounter.",
        listOf(
            Markup(
                MarkupType.Link,
                14,
                26,
                "https://dagger.dev/tutorial/"
            ),
            Markup(MarkupType.Bold, 114, 132),
            Markup(MarkupType.Bold, 144, 159),
            Markup(MarkupType.Bold, 191, 198)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Dagger is implemented using Java’s annotations model and annotations in Kotlin are not always directly parallel with how equivalent Java code would be written. This post will highlight areas where they differ and how you can use Dagger with Kotlin without having a headache."
    ),
    Paragraph(
        ParagraphType.Text,
        "This post was inspired by some of the suggestions in this Dagger issue that goes through best practices and pain points of Dagger in Kotlin. Thanks to all of the contributors that commented there!",
        listOf(
            Markup(
                MarkupType.Link,
                58,
                70,
                "https://github.com/google/dagger/issues/900"
            )
        )
    ),
    Paragraph(
        ParagraphType.Header,
        "kapt build improvements"
    ),
    Paragraph(
        ParagraphType.Text,
        "To improve your build time, Dagger added support for gradle’s incremental annotation processing in v2.18! This is enabled by default in Dagger v2.24. In case you’re using a lower version, you need to add a few lines of code (as shown below) if you want to benefit from it.",
        listOf(
            Markup(
                MarkupType.Link,
                99,
                104,
                "https://github.com/google/dagger/releases/tag/dagger-2.18"
            ),
            Markup(
                MarkupType.Link,
                143,
                148,
                "https://github.com/google/dagger/releases/tag/dagger-2.24"
            ),
            Markup(MarkupType.Bold, 53, 95)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Also, you can tell Dagger not to format the generated code. This option was added in Dagger v2.18 and it’s the default behavior (doesn’t generate formatted code) in v2.23. If you’re using a lower version, disable code formatting to improve your build time (see code below).",
        listOf(
            Markup(
                MarkupType.Link,
                92,
                97,
                "https://github.com/google/dagger/releases/tag/dagger-2.18"
            ),
            Markup(
                MarkupType.Link,
                165,
                170,
                "https://github.com/google/dagger/releases/tag/dagger-2.23"
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Include these compiler arguments in your build.gradle file to make Dagger more performant at build time:",
        listOf(Markup(MarkupType.Code, 41, 53))
    ),
    Paragraph(
        ParagraphType.Text,
        "Alternatively, if you use Kotlin DSL script files, include them like this in the build.gradle.kts file of the modules that use Dagger:",
        listOf(Markup(MarkupType.Code, 81, 97))
    ),
    Paragraph(
        ParagraphType.Text,
        "Qualifiers for field attributes"
    ),
    Paragraph(
        ParagraphType.Text,
        "",
        listOf(Markup(MarkupType.Link, 0, 0))
    ),
    Paragraph(
        ParagraphType.Text,
        "When an annotation is placed on a property in Kotlin, it’s not clear whether Java will see that annotation on the field of the property or the method for that property. Setting the field: prefix on the annotation ensures that the qualifier ends up in the right place (See documentation for more details).",
        listOf(
            Markup(MarkupType.Code, 181, 187),
            Markup(
                MarkupType.Link,
                268,
                285,
                "http://frogermcs.github.io/dependency-injection-with-dagger-2-custom-scopes/"
            ),
            Markup(MarkupType.Italic, 114, 119),
            Markup(MarkupType.Italic, 143, 149)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "✅ The way to apply qualifiers on an injected field is:"
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        "@Inject @field:MinimumBalance lateinit var minimumBalance: BigDecimal",
        listOf(Markup(MarkupType.Bold, 8, 29))
    ),
    Paragraph(
        ParagraphType.Text,
        "❌ As opposed to:"
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        """
        @Inject @MinimumBalance lateinit var minimumBalance: BigDecimal 
        // @MinimumBalance is ignored!
        """.trimIndent(),
        listOf(Markup(MarkupType.Bold, 65, 95))
    ),
    Paragraph(
        ParagraphType.Text,
        "Forgetting to add field: could lead to injecting the wrong object if there’s an unqualified instance of that type available in the Dagger graph.",
        listOf(Markup(MarkupType.Code, 18, 24))
    ),
    Paragraph(
        ParagraphType.Header,
        "Static @Provides functions optimization"
    ),
    Paragraph(
        ParagraphType.Text,
        "Dagger’s generated code will be more performant if @Provides methods are static. To achieve this in Kotlin, use a Kotlin object instead of a class and annotate your methods with @JvmStatic. This is a best practice that you should follow as much as possible.",
        listOf(
            Markup(MarkupType.Code, 51, 60),
            Markup(MarkupType.Code, 73, 79),
            Markup(MarkupType.Code, 121, 127),
            Markup(MarkupType.Code, 141, 146),
            Markup(MarkupType.Code, 178, 188),
            Markup(MarkupType.Bold, 200, 213),
            Markup(MarkupType.Italic, 200, 213)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "In case you need an abstract method, you’ll need to add the @JvmStatic method to a companion object and annotate it with @Module too.",
        listOf(
            Markup(MarkupType.Code, 60, 70),
            Markup(MarkupType.Code, 121, 128)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Alternatively, you can extract the object module out and include it in the abstract one:"
    ),
    Paragraph(
        ParagraphType.Header,
        "Injecting Generics"
    ),
    Paragraph(
        ParagraphType.Text,
        "Kotlin compiles generics with wildcards to make Kotlin APIs work with Java. These are generated when a type appears as a parameter (more info here) or as fields. For example, a Kotlin List<Foo> parameter shows up as List<? super Foo> in Java.",
        listOf(
            Markup(MarkupType.Code, 184, 193),
            Markup(MarkupType.Code, 216, 233),
            Markup(
                MarkupType.Link,
                132,
                146,
                "https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html#variant-generics"
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "This causes problems with Dagger because it expects an exact (aka invariant) type match. Using @JvmSuppressWildcards will ensure that Dagger sees the type without wildcards.",
        listOf(
            Markup(MarkupType.Code, 95, 116),
            Markup(
                MarkupType.Link,
                66,
                75,
                "https://en.wikipedia.org/wiki/Class_invariant"
            ),
            Markup(
                MarkupType.Link,
                96,
                116,
                "https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html"
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "This is a common issue when you inject collections using Dagger’s multibinding feature, for example:",
        listOf(
            Markup(
                MarkupType.Link,
                57,
                86,
                "https://dagger.dev/multibindings.html"
            )
        )
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        """
        class MyVMFactory @Inject constructor(
          private val vmMap: Map<String, @JvmSuppressWildcards Provider<ViewModel>>
        ) { 
            ... 
        }
        """.trimIndent(),
        listOf(Markup(MarkupType.Bold, 72, 93))
    ),
    Paragraph(
        ParagraphType.Header,
        "Inline method bodies"
    ),
    Paragraph(
        ParagraphType.Text,
        "Dagger determines the types that are configured by @Provides methods by inspecting the return type. Specifying the return type in Kotlin functions is optional and even the IDE sometimes encourages you to refactor your code to have inline method bodies that hide the return type declaration.",
        listOf(Markup(MarkupType.Code, 51, 60))
    ),
    Paragraph(
        ParagraphType.Text,
        "This can lead to bugs if the inferred type is different from the one you meant. Let’s see some examples:"
    ),
    Paragraph(
        ParagraphType.Text,
        "If you want to add a specific type to the graph, inlining works as expected. See the different ways to do the same in Kotlin:"
    ),
    Paragraph(
        ParagraphType.Text,
        "If you want to provide an implementation of an interface, then you must explicitly specify the return type. Not doing it can lead to problems and bugs:"
    ),
    Paragraph(
        ParagraphType.Text,
        "Dagger mostly works with Kotlin out of the box. However, you have to watch out for a few things just to make sure you’re doing what you really mean to do: @field: for qualifiers on field attributes, inline method bodies, and @JvmSuppressWildcards when injecting collections.",
        listOf(
            Markup(MarkupType.Code, 155, 162),
            Markup(MarkupType.Code, 225, 246)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Dagger optimizations come with no cost, add them and follow best practices to improve your build time: enabling incremental annotation processing, disabling formatting and using static @Provides methods in your Dagger modules.",
        listOf(
            Markup(
                MarkupType.Code,
                185,
                194
            )
        )
    )
)

val paragraphsPost3 = listOf(
    Paragraph(
        ParagraphType.Text,
        "Learn how to get started converting Java Programming Language code to Kotlin, making it more idiomatic and avoid common pitfalls, by following our new Refactoring to Kotlin codelab, available in English \uD83C\uDDEC\uD83C\uDDE7, Chinese \uD83C\uDDE8\uD83C\uDDF3 and Brazilian Portuguese \uD83C\uDDE7\uD83C\uDDF7.",
        listOf(
            Markup(
                MarkupType.Link,
                151,
                172,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin/#0"
            ),
            Markup(
                MarkupType.Link,
                209,
                216,
                "https://clmirror.storage.googleapis.com/codelabs/java-to-kotlin-zh/index.html#0"
            ),
            Markup(
                MarkupType.Link,
                226,
                246,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin-pt-br/#0"
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "When you first get started writing Kotlin code, you tend to follow Java Programming Language idioms. The automatic converter, part of both Android Studio and Intellij IDEA, can do a pretty good job of automatically refactoring your code, but sometimes, it needs a little help. This is where our new Refactoring to Kotlin codelab comes in.",
        listOf(
            Markup(
                MarkupType.Link,
                105,
                124,
                "https://www.jetbrains.com/help/idea/converting-a-java-file-to-kotlin-file.html"
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "We’ll take two classes (a User and a Repository) in Java Programming Language and convert them to Kotlin, check out what the automatic converter did and why. Then we go to the next level — make it idiomatic, teaching best practices and useful tips along the way.",
        listOf(
            Markup(MarkupType.Code, 26, 30),
            Markup(MarkupType.Code, 37, 47)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "The Refactoring to Kotlin codelab starts with basic topics — understand how nullability is declared in Kotlin, what types of equality are defined or how to best handle classes whose role is just to hold data. We then continue with how to handle static fields and functions in Kotlin and how to apply the Singleton pattern, with the help of one handy keyword: object. We’ll see how Kotlin helps us model our classes better, how it differentiates between a property of a class and an action the class can do. Finally, we’ll learn how to execute code only in the context of a specific object with the scope functions.",
        listOf(
            Markup(MarkupType.Code, 245, 251),
            Markup(MarkupType.Code, 359, 365),
            Markup(
                MarkupType.Link,
                4,
                25,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin/#0"
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Thanks to Walmyr Carvalho and Nelson Glauber for translating the codelab in Brazilian Portuguese!",
        listOf(
            Markup(
                MarkupType.Link,
                21,
                42,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin/#0"
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "",
        listOf(
            Markup(
                MarkupType.Link,
                76,
                96,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin-pt-br/#0"
            )
        )
    )
)

val paragraphsPost4 = listOf(
    Paragraph(
        ParagraphType.Text,
        "TL;DR: Expose resource IDs from ViewModels to avoid showing obsolete data."
    ),
    Paragraph(
        ParagraphType.Text,
        "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
        listOf(
            Markup(
                MarkupType.Bold,
                183,
                197
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "AndroidViewModel is a subclass of ViewModel that is aware of the Application context. However, having access to a context can be dangerous if you’re not observing or reacting to the lifecycle of that context. The recommended practice is to avoid dealing with objects that have a lifecycle in ViewModels.",
        listOf(
            Markup(MarkupType.Code, 0, 16),
            Markup(MarkupType.Code, 34, 43),
            Markup(MarkupType.Bold, 209, 303)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Let’s look at an example based on this issue in the tracker: Updating ViewModel on system locale change.",
        listOf(
            Markup(
                MarkupType.Link,
                61,
                103,
                "https://issuetracker.google.com/issues/111961971"
            ),
            Markup(MarkupType.Italic, 61, 104)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "The problem is that the string is resolved in the constructor only once. If there’s a locale change, the ViewModel won’t be recreated. This will result in our app showing obsolete data and therefore being only partially localized.",
        listOf(Markup(MarkupType.Bold, 73, 133))
    ),
    Paragraph(
        ParagraphType.Text,
        "As Sergey points out in the comments to the issue, the recommended approach is to expose the ID of the resource you want to load and do so in the view. As the view (activity, fragment, etc.) is lifecycle-aware it will be recreated after a configuration change so the resource will be reloaded correctly.",
        listOf(
            Markup(
                MarkupType.Link,
                3,
                9,
                "https://twitter.com/ZelenetS"
            ),
            Markup(
                MarkupType.Link,
                28,
                36,
                "https://issuetracker.google.com/issues/111961971#comment2"
            ),
            Markup(MarkupType.Bold, 82, 150)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Even if you don’t plan to localize your app, it makes testing much easier and cleans up your ViewModel objects so there’s no reason not to future-proof."
    ),
    Paragraph(
        ParagraphType.Text,
        "We fixed this issue in the android-architecture repository in the Java and Kotlin branches and we offloaded resource loading to the Data Binding layout.",
        listOf(
            Markup(
                MarkupType.Link,
                66,
                70,
                "https://github.com/googlesamples/android-architecture/pull/631"
            ),
            Markup(
                MarkupType.Link,
                75,
                81,
                "https://github.com/googlesamples/android-architecture/pull/635"
            ),
            Markup(
                MarkupType.Link,
                128,
                151,
                "https://github.com/googlesamples/android-architecture/pull/635/files#diff-7eb5d85ec3ea4e05ecddb7dc8ae20aa1R62"
            )
        )
    )
)

val paragraphsPost5 = listOf(
    Paragraph(
        ParagraphType.Text,
        "Working with collections is a common task and the Kotlin Standard Library offers many great utility functions. It also offers two ways of working with collections based on how they’re evaluated: eagerly — with Collections, and lazily — with Sequences. Continue reading to find out what’s the difference between the two, which one you should use and when, and what the performance implications of each are.",
        listOf(
            Markup(MarkupType.Code, 210, 220),
            Markup(MarkupType.Code, 241, 249),
            Markup(
                MarkupType.Link,
                210,
                221,
                "https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html"
            ),
            Markup(
                MarkupType.Link,
                241,
                250,
                "https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/index.html"
            ),
            Markup(MarkupType.Bold, 130, 134),
            Markup(MarkupType.Bold, 195, 202),
            Markup(MarkupType.Bold, 227, 233),
            Markup(MarkupType.Italic, 130, 134)
        )
    ),
    Paragraph(
        ParagraphType.Header,
        "Collections vs sequences"
    ),
    Paragraph(
        ParagraphType.Text,
        "The difference between eager and lazy evaluation lies in when each transformation on the collection is performed.",
        listOf(
            Markup(
                MarkupType.Italic,
                57,
                61
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Collections are eagerly evaluated — each operation is performed when it’s called and the result of the operation is stored in a new collection. The transformations on collections are inline functions. For example, looking at how map is implemented, we can see that it’s an inline function, that creates a new ArrayList:",
        listOf(
            Markup(MarkupType.Code, 229, 232),
            Markup(MarkupType.Code, 273, 279),
            Markup(MarkupType.Code, 309, 318),
            Markup(
                MarkupType.Link,
                183,
                199,
                "https://kotlinlang.org/docs/reference/inline-functions.html"
            ),
            Markup(
                MarkupType.Link,
                229,
                232,
                "https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/common/src/generated/_Collections.kt#L1312"
            ),
            Markup(MarkupType.Bold, 0, 12),
            Markup(MarkupType.Italic, 16, 23)
        )
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        "public inline fun <T, R> Iterable<T>.map(transform: (T) -> R): List<R> {\n" +
            "  return mapTo(ArrayList<R>(collectionSizeOrDefault(10)), transform)\n" +
            "}",
        listOf(
            Markup(MarkupType.Bold, 7, 13),
            Markup(MarkupType.Bold, 88, 97)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Sequences are lazily evaluated. They have two types of operations: intermediate and terminal. Intermediate operations are not performed on the spot; they’re just stored. Only when a terminal operation is called, the intermediate operations are triggered on each element in a row and finally, the terminal operation is applied. Intermediate operations (like map, distinct, groupBy etc) return another sequence whereas terminal operations (like first, toList, count etc) don’t.",
        listOf(
            Markup(MarkupType.Code, 357, 360),
            Markup(MarkupType.Code, 362, 370),
            Markup(MarkupType.Code, 372, 379),
            Markup(MarkupType.Code, 443, 448),
            Markup(MarkupType.Code, 450, 456),
            Markup(MarkupType.Code, 458, 463),
            Markup(MarkupType.Bold, 0, 9),
            Markup(MarkupType.Bold, 67, 79),
            Markup(MarkupType.Bold, 84, 92),
            Markup(MarkupType.Bold, 254, 269),
            Markup(MarkupType.Italic, 14, 20)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Sequences don’t hold a reference to the items of the collection. They’re created based on the iterator of the original collection and keep a reference to all the intermediate operations that need to be performed."
    ),
    Paragraph(
        ParagraphType.Text,
        "Unlike transformations on collections, intermediate transformations on sequences are not inline functions — inline functions cannot be stored and sequences need to store them. Looking at how an intermediate operation like map is implemented, we can see that the transform function is kept in a new instance of a Sequence:",
        listOf(
            Markup(MarkupType.Code, 222, 225),
            Markup(MarkupType.Code, 312, 320),
            Markup(
                MarkupType.Link,
                222,
                225,
                "https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/common/src/generated/_Sequences.kt#L860"
            )
        )
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        "public fun <T, R> Sequence<T>.map(transform: (T) -> R): Sequence<R>{      \n" +
            "   return TransformingSequence(this, transform)\n" +
            "}",
        listOf(Markup(MarkupType.Bold, 85, 105))
    ),
    Paragraph(
        ParagraphType.Text,
        "A terminal operation, like first, iterates through the elements of the sequence until the predicate condition is matched.",
        listOf(
            Markup(MarkupType.Code, 27, 32),
            Markup(
                MarkupType.Link,
                27,
                32,
                "https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/common/src/generated/_Sequences.kt#L117"
            )
        )
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        "public inline fun <T> Sequence<T>.first(predicate: (T) -> Boolean): T {\n" +
            "   for (element in this) if (predicate(element)) return element\n" +
            "   throw NoSuchElementException(“Sequence contains no element matching the predicate.”)\n" +
            "}"
    ),
    Paragraph(
        ParagraphType.Text,
        "If we look at how a sequence like TransformingSequence (used in the map above) is implemented, we’ll see that when next is called on the sequence iterator, the transformation stored is also applied.",
        listOf(
            Markup(MarkupType.Code, 34, 54),
            Markup(MarkupType.Code, 68, 71)
        )
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        "internal class TransformingIndexedSequence<T, R> \n" +
            "constructor(private val sequence: Sequence<T>, private val transformer: (Int, T) -> R) : Sequence<R> {",
        listOf(
            Markup(
                MarkupType.Bold,
                109,
                120
            )
        )
    ),
    Paragraph(
        ParagraphType.CodeBlock,
        "override fun iterator(): Iterator<R> = object : Iterator<R> {\n" +
            "   …\n" +
            "   override fun next(): R {\n" +
            "     return transformer(checkIndexOverflow(index++), iterator.next())\n" +
            "   }\n" +
            "   …\n" +
            "}",
        listOf(
            Markup(MarkupType.Bold, 83, 89),
            Markup(MarkupType.Bold, 107, 118)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Independent on whether you’re using collections or sequences, the Kotlin Standard Library offers quite a wide range of operations for both, like find, filter, groupBy and others. Make sure you check them out, before implementing your own version of these.",
        listOf(
            Markup(MarkupType.Code, 145, 149),
            Markup(MarkupType.Code, 151, 157),
            Markup(MarkupType.Code, 159, 166),
            Markup(
                MarkupType.Link,
                193,
                207,
                "https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/#functions"
            )
        )
    ),
    Paragraph(
        ParagraphType.Header,
        "Collections and sequences"
    ),
    Paragraph(
        ParagraphType.Text,
        "Let’s say that we have a list of objects of different shapes. We want to make the shapes yellow and then take the first square shape."
    ),
    Paragraph(
        ParagraphType.Text,
        "Let’s see how and when each operation is applied for collections and when for sequences"
    ),
    Paragraph(
        ParagraphType.Subhead,
        "Collections"
    ),
    Paragraph(
        ParagraphType.Text,
        "map is called — a new ArrayList is created. We iterate through all items of the initial collection, transform it by copying the original object and changing the color, then add it to the new list.",
        listOf(Markup(MarkupType.Code, 0, 3))
    ),
    Paragraph(
        ParagraphType.Text,
        "first is called — we iterate through each item until the first square is found",
        listOf(Markup(MarkupType.Code, 0, 5))
    ),
    Paragraph(
        ParagraphType.Subhead,
        "Sequences"
    ),
    Paragraph(
        ParagraphType.Bullet,
        "asSequence — a sequence is created based on the Iterator of the original collection",
        listOf(Markup(MarkupType.Code, 0, 10))
    ),
    Paragraph(
        ParagraphType.Bullet,
        "map is called — the transformation is added to the list of operations needed to be performed by the sequence but the operation is NOT performed",
        listOf(
            Markup(MarkupType.Code, 0, 3),
            Markup(MarkupType.Bold, 130, 133)
        )
    ),
    Paragraph(
        ParagraphType.Bullet,
        "first is called — this is a terminal operation, so, all the intermediate operations are triggered, on each element of the collection. We iterate through the initial collection applying map and then first on each of them. Since the condition from first is satisfied by the 2nd element, then we no longer apply the map on the rest of the collection.",
        listOf(Markup(MarkupType.Code, 0, 5))
    ),

    Paragraph(
        ParagraphType.Text,
        "When working with sequences no intermediate collection is created and since items are evaluated one by one, map is only performed on some of the inputs."
    ),
    Paragraph(
        ParagraphType.Header,
        "Performance"
    ),
    Paragraph(
        ParagraphType.Subhead,
        "Order of transformations"
    ),
    Paragraph(
        ParagraphType.Text,
        "Independent of whether you’re using collections or sequences, the order of transformations matters. In the example above, first doesn’t need to happen after map since it’s not a consequence of the map transformation. If we reverse the order of our business logic and call first on the collection and then transform the result, then we only create one new object — the yellow square. When using sequences — we avoid creating 2 new objects, when using collections, we avoid creating an entire new list.",
        listOf(
            Markup(MarkupType.Code, 122, 127),
            Markup(MarkupType.Code, 157, 160),
            Markup(MarkupType.Code, 197, 200)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Because terminal operations can finish processing early, and intermediate operations are evaluated lazily, sequences can, in some cases, help you avoid doing unnecessary work compared to collections. Make sure you always check the order of the transformations and the dependencies between them!"
    ),
    Paragraph(
        ParagraphType.Subhead,
        "Inlining and large data sets consequences"
    ),
    Paragraph(
        ParagraphType.Text,
        "Collection operations use inline functions, so the bytecode of the operation, together with the bytecode of the lambda passed to it will be inlined. Sequences don’t use inline functions, therefore, new Function objects are created for each operation.",
        listOf(
            Markup(
                MarkupType.Code,
                202,
                210
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "On the other hand, collections create a new list for every transformation while sequences just keep a reference to the transformation function."
    ),
    Paragraph(
        ParagraphType.Text,
        "When working with small collections, with 1–2 operators, these differences don’t have big implications so working with collections should be ok. But, when working with large lists the intermediate collection creation can become expensive; in such cases, use sequences.",
        listOf(
            Markup(MarkupType.Bold, 18, 35),
            Markup(MarkupType.Bold, 119, 130),
            Markup(MarkupType.Bold, 168, 179),
            Markup(MarkupType.Bold, 258, 267)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Unfortunately, I’m not aware of any benchmarking study done that would help us get a better understanding on how the performance of collections vs sequences is affected with different sizes of collections or operation chains."
    ),
    Paragraph(
        ParagraphType.Text,
        "Collections eagerly evaluate your data while sequences do so lazily. Depending on the size of your data, pick the one that fits best: collections — for small lists or sequences — for larger ones, and pay attention to the order of the transformations."
    )
)
val paragraphsPost6 = listOf(
    Paragraph(
        ParagraphType.Text,
        "汨罗江上，4条龙舟赛道鼓声此起彼伏，桨板整齐划一，龙舟逐浪竞渡。汨罗江两岸，人声鼎沸，热闹非凡，人们欢呼雀跃地为自己心仪的队伍加油鼓劲。今岁端阳，记者在有着“端午源头、龙舟故里、诗歌原乡”之称的湖南省汨罗市，置身于汨罗江畔这一延续了两千多年的文化场景中，感受“端午源头过端午，龙舟故里赛龙舟”的浓厚节日氛围。",
        listOf(
            Markup(
                MarkupType.Bold,
                7,
                9
            )
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "汨罗市因汨罗江而得名。两千余年前，伟大的爱国诗人屈原在汨罗江怀沙自沉，此后每年端午前后，汨罗江沿岸的居民都会自发地组织龙舟竞渡纪念屈原，这一习俗一直延续至今。同时，汨罗还是屈原晚年行吟求索之地、浪漫主义文学发源之地、屈原文化传承之地，铸就了华夏文明的精神高地、文学高地、情感高地。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        "汨罗江行至国际龙舟竞渡中心前，江宽水阔、流缓波平。连日来，中国汨罗江龙舟超级联赛在这里火热开展。比赛分为省内组和本地组，借鉴“村BA”模式，改以往的定向邀请为各村镇、单位自主报名，逐轮比拼，共吸引湖南省内38支队伍参赛。参赛队员有的是从工作岗位请假回家乡参赛，有的放下生意来参赛。为了在龙舟赛中取得好成绩，各支参赛队伍加紧训练，平均每天训练八九个小时。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        "在众多参赛队伍中，来自汨罗市屈子祠镇屈原村的女子龙舟队格外引人注目。这是一支曾创下辉煌战绩的龙舟队，她们于1988年组队，经过专业训练，曾代表岳阳参加国内外多项龙舟赛事，捧回众多荣誉。1995年后，队员们相继成家，做了妈妈，队伍也解散了，但她们心中的龙舟梦始终不曾熄灭，直到18年后的2013年，她们再次组队训练参赛。如今，屈原村女子龙舟队参赛者年龄最大的57岁，最小的44岁，尽管队伍中很多人已经当上了奶奶、外婆，辈分长了，体重也长了，但她们拼搏奋斗的精气神始终还在。队长翁艳平说：“我们这个队伍会继续存在下去，龙舟精神也要一直传下去。” ",
    ),
    Paragraph(
        ParagraphType.Text,
        "随着鼓声由远及近，汨罗江岸边群众的热情瞬间被点燃。“2道是我们村的龙舟队，加油！加油！”人群中，有人因自己村的龙舟领先而激动得跳起来。大家纷纷举起手机，记录这一激动人心的时刻。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        "“每年都会来看龙舟赛，从女儿很小的时候扛在大人肩上看，到如今，她都读初一了。”当地居民仇明英指着身旁的女儿说，“这是汨罗市每年的盛事，气氛不输春节，很多外地的亲戚都会赶来凑个热闹。” ",
    ),
    Paragraph(
        ParagraphType.Text,
        "如今，全国各地龙舟赛事越来越多，汨罗市的龙舟也随之迎来了销售热潮。全市20多家龙舟制造企业连日赶工，每年生产各类龙舟约5000条，除销往全国各地，还远销东南亚和欧美等地。全市龙舟制造产业年产值约两亿元。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        " 如今，全国各地龙舟赛事越来越多，汨罗市的龙舟也随之迎来了销售热潮。全市20多家龙舟制造企业连日赶工，每年生产各类龙舟约5000条，除销往全国各地，还远销东南亚和欧美等地。全市龙舟制造产业年产值约两亿元。",
    ),
    Paragraph(
        ParagraphType.Text,
        "年过花甲的湖南汨罗龙舟制造技艺传承人许桂生介绍，汨罗的龙舟制造有一个特别的习俗，讲究“龙头凤尾”，凤尾由多根长竹片上色而成，划动之时可见凤尾闪亮摇曳。“传统龙舟在材料和工艺上有着严格的要求。我们通常选用上好的杉木做龙舟，它重量轻、韧性好，是做龙舟的最佳选择。”许桂生说。",
    ),
    Paragraph(
        ParagraphType.Text,
        "“传统的木质龙舟制造要经过选材、伐木、放样、捻缝、上漆、绘鳞等11道工序，6名经验丰富的师傅共同制造一条龙舟大约需要6天至8天时间。”许桂生说，“我们从今年正月初九就开始接订单，一直做到现在。” ",
    ),
    Paragraph(
        ParagraphType.Text,
        "在激烈的龙舟赛事以外，今年的端午节，汨罗市还举办了非遗技艺展示和一系列丰富的民俗体验活动。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        "走进汨罗屈子文化园，一入园就能看到包粽子、做香囊等多个民俗体验点。来自长沙的六年级小学生高从云和弟弟认真地学习包粽子。“米和红枣装得太多了，这样会包不上。”在老师的指挥下，兄弟俩用几分钟时间包好了自己的第一个粽子作品，虽不是很规整，倒也有模有样，父母举着相机忙着为兄弟俩拍照留念。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        "随后，记者与中外游客一道乘坐观光小火车前往园区深处，车上《我爱你中国》的歌声引起了游客的共鸣，大家一边跟着音乐哼唱，一边欣赏屈子文化园内的碧水、垂柳和夏荷。待行至屈子祠前，“路漫漫其修远兮，吾将上下而求索……” 游客齐声诵读《离骚》的声音从远处香草湖中的水祭船上传来。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        "在九歌广场上，投壶、射五毒、拓印、漆扇等多个民俗体验项目排起了长队。“五毒是指蛇、蟾蜍、蜈蚣、壁虎和蝎子。”8岁的彭梓谦说起传统的端午文化知识如数家珍，“以前听老师讲过一些端午节的知识，这次来到汨罗，我知道的更多了，还看了赛龙舟，真是来值了。”彭梓谦的爷爷告诉记者：“我们是一家八口人一起来的，带孩子到端午文化的发源地来体验传统文化的魅力，感受伟大诗人屈原的爱国情怀，很有意义。” ",
    ),
    Paragraph(
        ParagraphType.Text,
        "“我们共准备了水祭大典、龙舟拔河等20多个端午民俗体验项目，让游客在这里深度体验和感受端午文化。三天来，累计接待游客上万人。”屈子文化园市场部总监田巍说。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        "两千多年来，汨罗江上弦歌不绝，桨声不断，端午文化在汨罗这方热土代代相传，历久弥新，它将随着汩汩流淌的汨罗江水继续传承下去，生生不息。 ",
    ),
)

val paragraphsPost7 = listOf(
    Paragraph(
        ParagraphType.Text,
        "不仅能欣赏展览，还能体验互动、与非遗传承人面对面交流、参加非遗研学……走进中国工艺美术馆·中国非物质文化遗产馆，立体多样的展览形式让观众充分感受非遗的魅力。自建成并对外开放以来，中国非物质文化遗产馆注重非遗项目的活态展示，营造接地气、有活力、生活化的文化空间，让更多人认识非遗、了解非遗、爱上非遗。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        "“色彩明丽”“构图高级”“工艺精湛”……“花开敦煌——常沙娜从艺八十年艺术与设计展”正在中国工艺美术馆·中国非物质文化遗产馆（以下简称“中国非遗馆”）举办，现场参观者众多，一条依据敦煌藻井图案设计的丝巾展品前，观众连连赞叹。 ",
    ),
    Paragraph(
        ParagraphType.Text,
        "借鉴了故宫太和殿的尺度比例，立面呈三段式，外立面造型提炼自传统建筑中花窗纹样和博古架元素……在北京中轴线北延长线上，坐落于湖景东路16号的中国非遗馆造型庄重典雅，别具一格。走进其中，门类多样、特色鲜明的非遗展品令人目不暇接，丰富多彩的活动受到观众欢迎。 ",
    ),Paragraph(
        ParagraphType.Subhead,
        "非遗不仅能看能听，还能体验互动",
    ),Paragraph(
        ParagraphType.Text,
        " 上午10点，市民宋文嘉来到中国非遗馆，“听说有个特别不一样的陕北民歌展，今天过来看看。”\n" +
                "\n" +
                "在讲解员带领下，宋文嘉对陕北民歌的历史和特色有了大致了解。之后，在精心布置的展厅内，她进入陕北高原的“崖洼洼”。黄土地、山崖、沟壑造型的展台间，陕北民歌手边走边唱。沉浸其中还没回过神，锣鼓一响、扇子打开，陕北秧歌又跳起来。 ",
    ),Paragraph(
        ParagraphType.Text,
        " “在这里，非遗不仅能看能听，还能体验互动，怪不得展览这么火。”宋文嘉说。\n" +
                "\n" +
                "不只陕北民歌，在昆曲、古琴、皮影戏等展览中，中国非遗馆都将讲解、展示、互动体验融为一体，让观众认识非遗、了解非遗、爱上非遗。\n" +
                "\n" +
                "独特的音乐和唱腔、典雅的造型、细腻传神的展示……在遇见非遗：“京”彩皮影——北京皮影戏社教活动现场，国家级非遗北京皮影戏代表性传承人的表演让观众看得入神，引来阵阵掌声。\n" +
                "\n" +
                "不仅有实物展览、文献资料、多媒体动画、装置艺术，还能动手体验传统印染工艺中的“漏浆刷印”环节——走进“青出于蓝”蓝印花布主题展览，丰富多样的展览方式让观众与中国传统染织“零距离”。\n" +
                "\n" +
                "中国非遗馆党委书记王晨阳认为，非遗“活”在当下，与每个人的衣食住行密切相关， “非遗项目的展示，是将无形的、长期的文化传统、认知方式等，以可理解、可感知的方式呈现出来。”\n" +
                "\n" +
                "“与博物馆不同，非遗馆不仅要展示非遗的历史和发展历程，还要展示非遗的存续状态。展览要充分体现‘以人为本’的理念，在内容和形式上注重活态呈现，体现非遗传承人的重要性。”王晨阳说。 ",
    ),
    Paragraph(
        ParagraphType.Subhead,
        "搭建平台，提升非遗的可见度和影响力",
    ),Paragraph(
        ParagraphType.Text,
        " 2024年文化和自然遗产日即将到来，中国非遗馆举办的“气象万千——中国非遗保护实践主题展”也将于6月7日与观众见面。展览涵盖十大门类，共计100余项非遗项目、600多件/套展品，通过“文字+图片+实物实景+多媒体互动”的展示形式，呈现非遗的时代风貌。展览期间，将有100名国家级非遗传承人带徒现场展演，观众可参与体验互动，感受非遗之美。\n" +
                "\n" +
                "说起中国非遗馆的建设初衷，王晨阳说，“非遗项目门类多、项目多、地域广，建立常态化的展示展陈空间和平台，将有利于提升非遗的可见度和影响力。”中国非遗馆对国家级、省级、市级、县级4级非遗项目敞开大门，搭建传承、展示、传播的平台。\n" +
                "\n" +
                "《“十四五”非物质文化遗产保护规划》提出，要建设20个国家级非遗馆。2021年8月，《关于进一步加强非物质文化遗产保护工作的意见》明确，在现有基础上，统筹建设利用好国家非物质文化遗产馆，鼓励有条件的地方建设非物质文化遗产馆、推动国家级非物质文化遗产代表性项目配套改建新建传承体验中心。在此背景下，中国非遗馆于2022年2月5日建成并对外开放。\n" +
                "\n" +
                "目前，中国非遗馆正在研究非遗馆的建设和服务标准，并加强与其他非遗馆的合作。王晨阳说：“我们要把非遗人的智慧凝聚起来，让非遗与人们产生更密切的互动，推动非遗项目融入当代生活，激发非遗保护传承的活力。” ",
    ),Paragraph(
        ParagraphType.Subhead,
        "营造接地气、有活力、生活化的文化空间",
    ),
    Paragraph(
        ParagraphType.Text,
        " 从上海到北京出差的李少丽，特意利用空闲时间参观了中国非遗馆。“种类繁多的非遗作品让我大开眼界，太惊艳了。”在非遗馆内，李少丽觉得时间过得很快，“有机会我还要带孩子来瞧瞧。”\n" +
                "\n" +
                "为了让更多青少年了解非遗、接触非遗，中国非遗馆面向青少年群体开展“中国巧手”美育系列社会教育活动，让青少年体验工艺之美。截至目前，“中国巧手”美育系列社教活动已举办20期，线上线下观众达40余万人。\n" +
                "\n" +
                "非遗馆的研学活动很受欢迎。为了让观众更全面、充分地了解非遗，中国非遗馆与传承人一起研发“教学包”。“传承谱系是怎样的，历史上的代表性传承人有哪些，项目有什么特色……在中国非遗馆，传承人会手把手、面对面教学，将地地道道的非遗知识普及给广大参与者。”王晨阳说。\n" +
                "\n" +
                "“希望未来能够与全国的非遗馆合作，让传承人的‘教学包’、研学课程形成体系，在各大非遗馆交流，让各地观众都能受益。”王晨阳说。\n" +
                "\n" +
                "王晨阳表示，中国非遗馆力图营造接地气、有活力、生活化的文化空间，让走进中国非遗馆的观众，都能够充分体验、参与、交流，领略非遗的魅力。 ",
    ),
)
val paragraphsPost8 = listOf(
    Paragraph(
        ParagraphType.Text,
        " 大年初二晚，中央广播电视总台2024年春节戏曲晚会如约而至。晚会在四川省德阳市完成前期录制，四川戏曲元素贯穿整场演出，展现了充满人间烟火气的巴蜀地域特色。\n" +
                "\n" +
                "近年来，以川剧为代表的四川戏曲艺术通过与文物活化、地域文化、民俗风情融合创新，正不断“破圈”，吸引众多年轻群体，焕发新时代的青春活力。 "
    ),
    Paragraph(
        ParagraphType.Subhead,
        "戏曲春晚蜀味浓"
    ),
    Paragraph(
        ParagraphType.Text,
        " “江山如画就，稻禾变田畴，站在了船头观锦绣，千红万紫满神州，侍儿轻摇船儿慢慢走，好让流水送行舟”……首次在中西部地区录制的春节戏曲晚会响起了川剧经典剧目《别洞观景》的唱段。来自四川省川剧院的梅花奖得主张燕携青年川剧演员尹莲莲、李雨洁，通过精湛的表演和清亮的唱腔，展现了川剧旦角的独特魅力。\n" +
                "\n" +
                "“这部作品描绘了在洞中修炼的白鳝仙姑来到人间，感受着人间的繁华与美景，最终流连忘返。这不仅是一个神话故事，更是对我们时代步伐的生动展现，凸显了生活日益美好的面貌。”张燕说。\n" +
                "\n" +
                "以“龙兴九州 福聚四海”为主题的2024年春节戏曲晚会，在戏曲本体基础上，突出时尚化、年轻态，以国风、国潮的全新演绎，唱响青春旋律，打造戏曲表达新样态。在四川德阳因地制宜，晚会还将戏曲艺术与三星堆文化、三国文化、四川非遗等川蜀特色充分融合，充分展现四川深厚的文化底蕴。\n" +
                "\n" +
                "在情景诗词演绎《翰墨千秋》中，梅花奖获得者李政成、陈智林、刘露、魏春荣登台，通过扬剧、川剧、京剧、昆曲与四川历史文化名人李白、苏轼、薛涛、花蕊夫人隔空对话；王祖蓝和李斯丹妮的方言说唱《巴适得板》，在展现川剧小生和小旦身韵之美的同时，融入四川清音、扬琴、金钱板等四川曲艺元素；此外还有川剧《报灯名》《三顾茅庐》，影视戏中戏《武林风云会》等节目处处蕴藏巧思，传递出四川丰富多元的传统文化。\n" +
                "\n" +
                "作为四川文化重要名片的三星堆文化在本次晚会中格外吸睛。“在设计整体晚会节目之前，节目组曾进行了一个前期的调研考察，其实三星堆新馆里面有很多不为人知的文物。”2024年春节戏曲晚会总导演董艺介绍，如何运用戏曲的元素来展现三星堆文化，团队做了大量的调研工作。其中，创意戏曲舞蹈《梦回三星堆》作为此次晚会的特色亮点节目，将戏曲融合舞蹈并结合三星堆文物元素和《山海经》，展现三星堆文化的瑰丽奇崛。 "
    ),
    Paragraph(
        ParagraphType.Subhead,
        "“让老一辈看得懂，让新生代愿意看”"
    ),
    Paragraph(
        ParagraphType.Text,
        " 戏曲晚会的大放异彩，是以川剧为代表的四川戏曲艺术在面对互联网时代的变革和挑战的成果体现。近年来，凭借“让老一辈看得懂，让新生代愿意看”的传承发展理念，川剧艺术也在深厚的历史积淀中寻找到前行的动力。\n" +
                "\n" +
                "“好雨知时节，当春乃发生。随风潜入夜，润物细无声……”由四川省文联主席、四川省川剧院院长陈智林演唱的新春戏歌《春夜喜雨》用悠扬浑厚的川剧声腔表现诗词经典，配上杜甫草堂的优美画面，令观众耳目一新。整首戏歌被做成了短视频在网上传播，视频穿插成都春雨敲打绿叶、粉色的花卉初开、杜甫草堂绿树掩映等片段，赋予古诗川腔川调，也让川剧有了新的表达方式。\n" +
                "\n" +
                "去年，大型新编历史川剧《梦回东坡》首演便大获群众青睐。作品采取以梦中追溯过往的形式，融入了散文的叙事手法，展现了苏东坡人生中的重要事件，让观众切实感受到一个乐观、豁达、幽默，有血有肉、有烟火气的苏东坡形象。作品不仅不少重要角色均由“00后”演员担任，语言方面还融入了烟火味儿十足的四川方言，拉近了川剧和观众的距离。\n" +
                "\n" +
                "今年1月下旬，成都市川剧研究院在智利圣地亚哥东方剧场上演经典川剧《白蛇传》，连演3场座无虚席，受到当地观众热情响应和高度赞誉。演出前半段，演员通过大量高腔唱词，用优美动听的唱腔为观众讲述了许仙和白娘子的爱情故事。后半段的大量武戏中，滚禅杖、托举等技巧功夫轮番上演。剧中“牵眼线”“提耙人”“踢慧眼”“变脸”“吐火”等川剧绝技表演，更令在场观众赞叹连连。在智利演出后，院团还参与了“欢乐春节”花车巡游活动，演员身着《白蛇传》戏服在花车上挥手致意，成为现场最耀眼的“明星”。\n" +
                "\n" +
                "值得关注的是，在成渝地区双城经济圈建设背景下，两地川剧人近年来围绕川剧这条巴蜀文化同气连枝的纽带，抢抓时代机遇，不断推陈出新，屡屡“出圈”。\n" +
                "\n" +
                "在第五届川剧节上大放异彩的川剧《李亚仙》，以爱为主题，将现代人审美融入古典戏曲，既体现出川剧清新高雅、幽默诙谐的特色，也将川剧“悲剧喜演、喜剧悲演”的表现手法展示得淋漓尽致，是重庆市川剧院“创造性转化、创新性发展”的生动体现。为发掘优秀青年川剧人才，由四川省委宣传部、省文化和旅游厅推出的川剧文化创演推广节目《中国有川剧》，立足川剧的艺术特色，结合电视综艺形式，创新性提出“创演”这一概念，为川剧艺术的传播普及打造了全新优质平台。 "
    ),
)
val paragraphsPost9 = listOf(
    Paragraph(
        ParagraphType.Text,
        " 剪纸艺术蕴藏了我国劳动人民深厚的情感，积淀了华夏几千年的文明，是我国传统哲学、美学、民俗学等多方面智慧的结晶，郭沫若曾以“一剪之趣夺神功，美在民间永不朽”来赞叹中国民间剪纸艺术。近日开展的“中国美术馆‘典藏活化’系列展：纸上天裁——中国美术馆藏剪纸艺术展”，从丰富的馆藏中精选出260余件（套）作品系统呈现民间剪纸艺术之美。\n" +
                "\n" +
                "中国美术馆馆长吴为山介绍表示，中国美术馆从建馆伊始，就十分注重民间剪纸的收藏、展示与研究。早在延安时期，米谷、江丰等延安文艺工作者就开始注重收集和研究陕北地区的民间剪纸，他们向民间学习，利用民间剪纸形式表现革命文艺的新样式，在文艺战线中起到了宣传革命、鼓舞人心的重要作用。中国美术馆建馆初期的收藏队伍主要来自延安，他们将人民群众创造的民间美术列为中国美术馆收藏和展览的重要部分。建馆六十年来经过几代人不懈地努力，目前，中国美术馆共收藏了来自于全国各地包含多民族的剪纸作品共计16000余件。这些精美的剪纸作品汇为国家艺术宝库中民间艺术精神之海洋，它们凝聚了广大人民群众的智慧与巧思，共同构筑了扎根于民间的中华优秀传统文化的资源库。\n" +
                "\n" +
                "在本次展览中，“天才巧手”单元展出了王老赏、苏兰花、王继汝、库淑兰、祁秀梅、曹佃祥、高金爱和高凤莲8位民间剪纸艺术家的作品。“别出心裁”“剪花迎祥”两个主题单元则根据剪纸的地域分布和功能角度发生地区和实用功能不同展出了不同风格的剪纸作品。\n" +
                "\n" +
                "我国古老的农耕社会从根本上决定了民间剪纸的内容和形式，稚拙古朴、粗犷浑厚，简洁灵活、自然风趣，充分展现着自身特殊的艺术魅力。这种处于农业社会的古老艺术，经过广大人民世世代代的传承和发展，演化成为中国乡土文化的一种重要表现形式。在二十世纪八十年代抢救民间美术工作推进的热潮中，以库淑兰、高凤莲等为代表的那些默默无名却又天才般的民间剪纸大师被相继挖掘和发现，她们的剪纸作品在国家殿堂惊艳亮相，引发中国艺术界的巨大反响，人们赞叹那种相对封闭生活状态之下所创生出来的中国民间乡土美学体系，及其所带来的视觉层面和精神层面的震撼。本次展览展出的库淑兰的《我把三水表一番》、高凤莲的《黄河人家》以及祁秀美的《龙凤》等作品可以让观众一饱眼福。一片薄薄的纸张，经她们的裁剪，呈现出万千气象，表达了她们对生活的无尽热爱，以及丰富的想象力。\n" +
                "\n" +
                "“她们几乎没有文化，却在极其艰苦的生活条件下，利用农闲之余创作出一幅幅令世人叹为观止的剪纸作品。她们用最朴实的情感传达着这片土地之上世代相传的朴素信仰和生命价值观，在剪纸世界中表达着对于这个世界的热爱和内心的美好。”吴为山表示，这些民间剪纸大师没有任何来自艺术技法层面的束缚，内心之中对于这个世界的认知和想象都能转化为刀下精美的花样。她们的刀法就像山间烂漫的山花自由生长，所有的表现物像从心而发，刀随心走，由一而三，三生万物，直至一个鲜活而生动的世界被构建出来，这是一种带有泥土芬芳的中国艺术写意精神在民间的呈现。\n" +
                "\n" +
                "二十一世纪以来，全国各地具有特色的民间剪纸逐渐成为非物质文化遗产。2006年5月20日剪纸经国务院批准被列入《第一批国家级非物质文化遗产名录》。2009年9月30日中国剪纸经联合国教科文组织保护非物质文化遗产政府间委员会审批，列入了第四批《人类非物质文化遗产代表作名录》。中国的民间剪纸艺术在新的时代背景下迎来了新的发展机遇。如今剪纸已由过去一般的窗花装饰，发展到今天的刊头尾花、连环画、插画、邮票、动画、印染、舞美、商标、藏书票等许多方面。此外，剪纸已走进学校，成为艺术启蒙的一种方式；还化身文化产品，成为文旅发展的新生力量；甚至还走上国际交流的舞台，成为文化传播的使者。在新视角、新理念、新技术、新方法的推动下，剪纸已经成为蕴含中国精神和理念的艺术代表，得到中国社会乃至国际的广泛认可。 "
    )
)
val paragraphsPost10 = listOf(
    Paragraph(
        ParagraphType.Text,
        " 弋阳腔、万载夏布织造技艺、南丰傩舞、景德镇手工制瓷技艺名扬天下，赣南客家文化、湖口青阳腔、文港毛笔、瓷板画绚烂多彩……江西非遗根植于人民群众的日常生产生活和赣鄱悠久历史。\n" +
                "\n" +
                "古老的文化，鲜活的传承。\n" +
                "\n" +
                "近年来，江西省文化和旅游系统聚焦“走在前、勇争先、善作为”的目标要求，扎实推进非遗系统性保护，推动优秀传统文化创造性转化、创新性发展，非遗传播渠道不断拓展、展示场景不断丰富，产生了“非遗+”的N种打开方式，传统文化与现代生活在双向奔赴中出圈出彩。 "
    ),
    Paragraph(
        ParagraphType.Subhead,
        "非遗进景区 让旅游“热”起来"
    ),
    Paragraph(
        ParagraphType.Text,
        " 非物质文化遗产是中华优秀传统文化的重要组成部分，是中华文明绵延传承的生动见证。旅游是一种现代生活方式，为非遗提供了更多应用场景。\n" +
                "\n" +
                "当旅游邂逅“非遗”，能玩出怎样的“文化味儿”？在婺源县江湾景区，当地民众表演传统民间艺术“豆腐架”，吸引大批游客驻足观赏拍照；篁岭古村，村民激情四射地舞动长龙，浩浩荡荡游街而行；西冲村，游客们饶有兴趣地欣赏传承人现场制作花灯，有的游客还拿起画笔，体验一把非遗项目的文化内涵和独特魅力。\n" +
                "\n" +
                "近年来，江西积极探索非遗保护和旅游发展的共赢之路，将丰富的文化资源转化为产业发展资源，走出了一条独具特色的优秀传统文化与乡村旅游有机融合的发展之路。\n" +
                "\n" +
                "武宁县西海湾景区设置水上舞台，演出剧目以国家级非遗“武宁打鼓歌”、省级非遗“武宁采茶戏”等为主，配以声、光、电等现代科技手段，“非遗+旅游+演艺”的新业态广受游客欢迎，年接待观众10万余人次。新余仙女湖景区举办中国（仙女湖）非遗旅游欢乐周，涵盖非遗市集、非遗展演、非遗音乐大集等活动……一个个非遗与旅游融合发展的生动实践，不仅激发了非遗传承活力，也提升了旅游目的地吸引力。\n" +
                "\n" +
                "此外，江西通过举办“非遗购物节”，整合全省11个设区市180个非遗项目、500多位非遗传承人，集中宣传展示江西非遗保护传承的成果，让游客在畅享非遗购、探访非遗味、共赴非遗游中，感悟优秀传统文化的博大精深；举办非遗和旅游融合发展周，发布3条跨区域非遗旅游线路和11条设区市线路；策划推出戏曲驻场演出、非遗雅集、非遗读书沙龙、技艺体验等活动……\n" +
                "\n" +
                "不断释放的非遗魅力，助力江西旅游“热”起来。 "
    ),
    Paragraph(
        ParagraphType.Subhead,
        "非遗进社区 让城乡“火”起来"
    ),
    Paragraph(
        ParagraphType.Text,
        " 去年7月，客家文化（赣南）生态保护实验区顺利通过文旅部验收，正式确定为国家级文化生态保护区。\n" +
                "\n" +
                "为让非遗更好地融入现代生活，江西大力推进文化生态保护（实验）区建设，先后获批3个国家级文化生态保护（实验）区、设立3个省级文化生态保护实验区，举办2023中国原生民歌节、第六届湘赣鄂皖非物质文化遗产联展。传统非遗“见人见物见生活”，实现静态展示与活态演绎相互补充、良性互动，探索出了一条具有江西特色的非遗传承发展之路。\n" +
                "\n" +
                "入夜后，江西万载古城景区人潮涌动，一场“焰火之恋”烟花秀，吸引众多市民和游客前来观赏。当地依托万载花炮制作技艺，不断打造夜间消费新场景，形成“逛古城、喝大碗茶、赏花灯戏”的特色文旅品牌。在万安县高陂镇田北农民画村，打造了集创作、展示、培训、写生、休闲旅游“五位一体”的传统美术类产业基地。在贵溪市樟坪畲族乡，可观赏畲族马灯舞、畲族竹杆舞灯等非遗表演。在萍乡南正街历史文化街区，非遗项目湘东皮影戏成为游客必“打卡”项目……\n" +
                "\n" +
                "非遗，连接百姓生活，融入人间烟火。\n" +
                "\n" +
                "此外，江西还鼓励有条件的地方建设非物质文化遗产馆。截至目前，江西省共建成非遗展示馆154个。\n" +
                "\n" +
                "2023年5月，由乐平市文化馆自主筹建的乐平市非物质文化遗产馆·赣剧楼正式对外开放。开馆以来，共举办近百场赣剧专场演出，吸引来自全国各地超10万游客前来参观打卡。11月，投资2亿元、建筑面积1万平方米的世界客家非遗馆建成并投用……\n" +
                "\n" +
                "一个个非遗馆的揭牌启用，进一步拓宽了传统文化传承发展路径，也为文旅融合加入非遗元素、注入崭新动能。非遗馆，已成为非遗传承、传播推广的重要阵地，链接传统文化与市民游客的“城市会客厅”。 "
    ),
    Paragraph(
        ParagraphType.Subhead,
        "非遗进校园 让文化“传”下去"
    ),
    Paragraph(
        ParagraphType.Text,
        " 校园唱响“哎呀嘞”，兴国山歌进校园。\n" +
                "\n" +
                "兴国，不仅是有名的“将军县”，更是“山歌之乡”。为了传承红色基因，弘扬中华文化，兴国县持续推动“山歌进校园”，将兴国山歌引入课堂。同时，当地不断创新形式，开展“校园十佳歌手评选”“校园山歌艺术节”等活动。通过讲唱结合，兴国山歌“声”入人心。\n" +
                "\n" +
                "山歌进校园，是江西探索传统文化与现代教育相互结合、相互交融的一种新尝试。\n" +
                "\n" +
                "为弘扬与传承中华优秀传统文化，赣州市章贡区也积极开展非遗进校园活动，并将采茶戏列入音乐课、改编采茶韵律操在全区推广。南昌市在市属高校创新开展2023年南昌市“非遗青年说”系列活动。抚州职业技术学院邀请抚州采茶戏、临川篾编技艺、临川白浒窑陶瓷工艺、抚州神佛木雕和宜黄戏等非遗项目代表性传承人授课。吉安井冈山市东上学校每周开展一次井冈山全堂狮灯进校园活动，并挂牌成立井冈山全堂狮灯传承教学基地……\n" +
                "\n" +
                "非遗进校园，在丰富校园生活的同时，也增强了学生们的文化素养和文化自信，展现了非遗的青春风采，让中华传统文化之花在校园绽放，代代传承。\n" +
                "\n" +
                "“前不久，江西4家单位入选国家级非物质文化遗产生产性保护示范基地，这生动展现了江西非遗保护传承工作新成果。”江西省非物质文化遗产研究保护中心相关负责人表示。下一步，江西将围绕打造“三大高地”、实施“五大战略”，深入实施非遗保护传承工程，大力创建一批文化生态保护区，着力培养一批非遗后继人才，全力推动非遗创造性转化、创新性发展，努力让非遗在新时代绽放更加迷人的光彩，助力文化强省、旅游强省建设。 "
    ),
)
val post1 = Post(
    id = "dc523f0ed25c",
    title = "A Little Thing about Android Module Paths",
    subtitle = "How to configure your module paths, instead of using Gradle’s default.",
    url = "https://medium.com/androiddevelopers/gradle-path-configuration-dc523f0ed25c",
    publication = publication,
    metadata = Metadata(
        author = pietro,
        date = "August 02",
        readTimeMinutes = 1
    ),
    paragraphs = paragraphsPost1,
    imageId = R.drawable.post_1,
    imageThumbId = R.drawable.post_1_thumb
)

val post2 = Post(
    id = "7446d8dfd7dc",
    title = "Dagger in Kotlin: Gotchas and Optimizations",
    subtitle = "Use Dagger in Kotlin! This article includes best practices to optimize your build time and gotchas you might encounter.",
    url = "https://medium.com/androiddevelopers/dagger-in-kotlin-gotchas-and-optimizations-7446d8dfd7dc",
    publication = publication,
    metadata = Metadata(
        author = manuel,
        date = "July 30",
        readTimeMinutes = 3
    ),
    paragraphs = paragraphsPost2,
    imageId = R.drawable.post_2,
    imageThumbId = R.drawable.post_2_thumb
)

val post3 = Post(
    id = "ac552dcc1741",
    title = "From Java Programming Language to Kotlin — the idiomatic way",
    subtitle = "Learn how to get started converting Java Programming Language code to Kotlin, making it more idiomatic and avoid common pitfalls, by…",
    url = "https://medium.com/androiddevelopers/from-java-programming-language-to-kotlin-the-idiomatic-way-ac552dcc1741",
    publication = publication,
    metadata = Metadata(
        author = florina,
        date = "July 09",
        readTimeMinutes = 1
    ),
    paragraphs = paragraphsPost3,
    imageId = R.drawable.post_3,
    imageThumbId = R.drawable.post_3_thumb
)

val post4 = Post(
    id = "84eb677660d9",
    title = "Locale changes and the AndroidViewModel antipattern",
    subtitle = "TL;DR: Expose resource IDs from ViewModels to avoid showing obsolete data.",
    url = "https://medium.com/androiddevelopers/locale-changes-and-the-androidviewmodel-antipattern-84eb677660d9",
    publication = publication,
    metadata = Metadata(
        author = jose,
        date = "April 02",
        readTimeMinutes = 1
    ),
    paragraphs = paragraphsPost4,
    imageId = R.drawable.post_4,
    imageThumbId = R.drawable.post_4_thumb
)

val post5 = Post(
    id = "55db18283aca",
    title = "Collections and sequences in Kotlin",
    subtitle = "Working with collections is a common task and the Kotlin Standard Library offers many great utility functions. It also offers two ways of…",
    url = "https://medium.com/androiddevelopers/collections-and-sequences-in-kotlin-55db18283aca",
    publication = publication,
    metadata = Metadata(
        author = florina,
        date = "July 24",
        readTimeMinutes = 4
    ),
    paragraphs = paragraphsPost5,
    imageId = R.drawable.post_5,
    imageThumbId = R.drawable.post_5_thumb
)
val post6 = Post(
    id = "by6",
    title = "汨罗江上桨声不断 端午民俗历久弥新",
    subtitle = "记中国汨罗江龙舟超级联赛现场",
    url = "https://www.ihchina.cn/news_1_details/29280.html",
    publication = publication,
    metadata = Metadata(
        author = china_culture,
        date = "April 13",
        readTimeMinutes = 1
    ),
    paragraphs = paragraphsPost6,
    imageId = R.drawable.post_6,
    imageThumbId = R.drawable.post_6_thumb
)
val post7= Post(
    id = "by7",
    title = "听民歌、看皮影、做印染，走进中国非物质文化遗产馆 ",
    subtitle = "展陈接地气 非遗聚人气（辽阔的大地 多彩的非遗）",
    url = "https://www.ihchina.cn/news_1_details/29273.html",
    publication = publication,
    metadata = Metadata(
        author = renmin_newspaper,
        date = "April 06",
        readTimeMinutes = 10
    ),
    paragraphs = paragraphsPost7,
    imageId = R.drawable.post_7,
    imageThumbId = R.drawable.post_7_thumb
)
val post8 = Post(
    id = "by8",
    title = "川剧守正创新焕发活力 ",
    subtitle = "成都市川剧研究院在智利圣地亚哥东方剧场上演川剧《白蛇传》",
    url = "https://www.ihchina.cn/news_1_details/29022.html",
    publication = publication,
    metadata = Metadata(
        author = china_culture,
        date = "March 01",
        readTimeMinutes = 3
    ),
    paragraphs = paragraphsPost8,
    imageId = R.drawable.post_8,
    imageThumbId = R.drawable.post_8_thumb
)
val post9 = Post(
    id = "by9",
    title = "窗上花 纸上情",
    subtitle = "纸上天裁——中国美术馆藏剪纸艺术展",
    url = "https://www.ihchina.cn/news_1_details/28950.html",
    publication = publication,
    metadata = Metadata(
        author = china_wenlv,
        date = "May 16",
        readTimeMinutes = 10
    ),
    paragraphs = paragraphsPost9,
    imageId = R.drawable.post_9,
    imageThumbId = R.drawable.post_9_thumb
)
val post10 = Post(
    id = "by10",
    title = "江西“非遗+”让现代生活更美好",
    subtitle = "古老的文化，鲜活的传承",
    url = "https://www.ihchina.cn/news_1_details/28847.html",
    publication = publication,
    metadata = Metadata(
        author = xinhuashe,
        date = "April 21",
        readTimeMinutes = 6
    ),
    paragraphs = paragraphsPost10,
    imageId = R.drawable.post_10,
    imageThumbId = R.drawable.post_10_thumb
)

val posts: PostsFeed =
    PostsFeed(
        highlightedPost = post6,
        recommendedPosts = listOf(post7, post8, post9 ,post10),
        popularPosts = listOf(
            post6.copy(id = "6"),
            post8.copy(id = "7"),
            post9.copy(id = "9")
        ),
        recentPosts = listOf(
            post8.copy(id = "post8"),
            post7.copy(id = "post10")
        )
    )
