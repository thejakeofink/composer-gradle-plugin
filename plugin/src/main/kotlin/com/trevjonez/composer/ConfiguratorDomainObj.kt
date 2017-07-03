/*
 *    Copyright 2017 Trevor Jones
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.trevjonez.composer

import org.gradle.api.Action
import java.io.File

open class ConfiguratorDomainObj: ComposerConfigurator {
    override var apk: File? = null
    override var testApk: File? = null
    override var testPackage: String? = null
    override var testRunner: String? = null
    override var shard: Boolean? = null
    override var outputDirectory: File = ComposerTask.DEFAULT_OUTPUT_DIR
    override var instrumentationArguments: MutableMap<String, String> = mutableMapOf()
    override var verboseOutput: Boolean? = null

    var configureTask: Action<ComposerTask>? = null

    override fun apk(value: File) {
        apk = value
    }

    override fun apk(value: String) {
        apk(File(value))
    }

    override fun testApk(value: File) {
        testApk = value
    }

    override fun testApk(value: String) {
        testApk(File(value))
    }

    override fun testPackage(value: String) {
        testPackage = value
    }

    override fun testRunner(value: String) {
        testRunner = value
    }

    override fun shard(value: Boolean) {
        shard = value
    }

    override fun outputDirectory(value: File) {
        outputDirectory = value
    }

    override fun outputDirectory(value: String) {
        outputDirectory(File(value))
    }

    override fun instrumentationArguments(value: MutableMap<String, String>) {
        instrumentationArguments = value
    }

    override fun instrumentationArguments(vararg values: Pair<String, String>) {
        instrumentationArguments(mutableMapOf(*values))
    }

    override fun addInstrumentationArgument(key: String, value: String) {
        instrumentationArguments.put(key, value)
    }

    override fun addInstrumentationArgument(value: Pair<String, String>) {
        instrumentationArguments.put(value.first, value.second)
    }

    override fun verboseOutput(value: Boolean) {
        verboseOutput = value
    }

    fun configureTask(action: Action<ComposerTask>) {
        configureTask = action
    }
}