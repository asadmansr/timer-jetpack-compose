/*
 * Copyright 2021 The Android Open Source Project
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
package com.example.androiddevchallenge.ui.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {
    private lateinit var timer: CountDownTimer
    private val _time = MutableLiveData("")
    val time: LiveData<String> = _time

    fun onTimeChange(newTime: String) {
        _time.value = newTime
    }

    fun onTimerStart(time: Long) {
        timer = object : CountDownTimer(time, 500) {
            override fun onTick(millisUntilFinished: Long) {
                var minutes = (millisUntilFinished / 1000 / 60).toString()
                var seconds = (millisUntilFinished / 1000 % 60).toString()
                if (minutes.length == 1) minutes = "0$minutes"
                if (seconds.length == 1) seconds = "0$seconds"
                onTimeChange("$minutes:$seconds")
            }

            override fun onFinish() {
                onTimeChange("")
            }
        }
        timer.start()
    }

    fun onTimerFinish() {
        timer.cancel()
        onTimeChange("")
    }
}
