package com.geekbrains.tests

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until

internal const val TEST_NUMBER = 42
internal const val TEST_NUMBER_OF_RESULTS_ZERO = "Number of results: 0"
internal const val TEST_NUMBER_OF_RESULTS_PLUS_1 = "Number of results: 1"
internal const val TEST_NUMBER_OF_RESULTS_MINUS_1 = "Number of results: -1"
internal const val TIMEOUT = 5000L

internal val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
internal val context = ApplicationProvider.getApplicationContext<Context>()
internal val packageName = context.packageName

internal fun startTestActivity() {
    val intent = context.packageManager.getLaunchIntentForPackage(packageName)
    intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    context.startActivity(intent)
}

internal fun UiDevice.fromRes(resId: String): UiObject2 =
    uiDevice.findObject(By.res(packageName, resId))

internal fun UiDevice.waitFromRes(resId: String): UiObject2 =
    uiDevice.wait(
        Until.findObject(By.res(packageName, resId)),
        TIMEOUT
    )
