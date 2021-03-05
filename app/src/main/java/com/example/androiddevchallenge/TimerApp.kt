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
package com.example.androiddevchallenge

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.ui.util.TimeSet
import com.example.androiddevchallenge.ui.util.TimerState
import com.example.androiddevchallenge.ui.view.CountDownScreen
import com.example.androiddevchallenge.ui.view.SetTimeScreen
import com.example.androiddevchallenge.ui.viewmodel.TimerViewModel

@Composable
fun TimerApp(timerViewModel: TimerViewModel) {
    var currentState by remember { mutableStateOf(TimerState.SET_TIME) }

    Surface(color = Color(0xFF040DFD)) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            val time by timerViewModel.time.observeAsState("")
            currentState = if (time.isEmpty()) TimerState.SET_TIME else TimerState.COUNTDOWN

            Crossfade(targetState = currentState) { state ->
                when (state) {
                    TimerState.SET_TIME -> {
                        SetTimeScreen(
                            timeset = TimeSet.timeSet,
                            timerViewModel = timerViewModel
                        )
                    }
                    TimerState.COUNTDOWN -> {
                        CountDownScreen(
                            time = time,
                            timerViewModel = timerViewModel
                        )
                    }
                }
            }
        }
    }
}
