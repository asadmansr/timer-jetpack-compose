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
package com.example.androiddevchallenge.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.util.TimeUtil
import com.example.androiddevchallenge.ui.viewmodel.TimerViewModel

@Composable
fun SetTimeScreen(timeset: List<TimeUtil>, timerViewModel: TimerViewModel) {
    LazyColumn {
        items(timeset) { timeutil ->
            ClickableText(
                text = AnnotatedString(timeutil.label),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                style = TextStyle(
                    fontSize = 52.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                onClick = {
                    timerViewModel.onTimerStart(timeutil.amount)
                }
            )
            Divider(color = Color.White, thickness = 2.dp)
        }
    }
}
