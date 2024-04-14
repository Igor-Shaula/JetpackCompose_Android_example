package com.igor_shaula.complex_api_client_sample.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class VMTestWatcher(
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher() // exactly this for VM
) : TestWatcher() {

    override fun starting(description: Description?) {
        super.starting(description)
//        println("starting: description = $description")
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
//        println("finished: description = $description")
        Dispatchers.resetMain()
    }
}