/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/** 镜像源
 *
 * repositories {
 * 	mavenLocal()
 * 	maven { url "https://maven.aliyun.com/nexus/content/groups/public/"}
 * 	mavenCentral()
 * 	jcenter()
 * 	maven { url "https://repo.spring.io/snapshot" }
 * 	maven { url "https://repo.spring.io/milestone" }
 * 	maven { url 'https://oss.jfrog.org/artifactory/oss-snapshot-local/' }
 * }
 *  */


plugins {
    alias(libs.plugins.gradle.versions)
    alias(libs.plugins.version.catalog.update)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.compose) apply false
}

apply("${project.rootDir}/buildscripts/toml-updater-config.gradle")
