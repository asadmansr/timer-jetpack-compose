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
package com.example.androiddevchallenge.ui.util

object TimeSet {
    val timeSet: List<TimeUtil> = listOf(
        TimeUtil(
            label = "10 seconds",
            amount = 10000,
        ),
        TimeUtil(
            label = "30 seconds",
            amount = 30000,
        ),
        TimeUtil(
            label = "1 minute",
            amount = 60000,
        ),
        TimeUtil(
            label = "3 minutes",
            amount = 180000,
        ),
        TimeUtil(
            label = "5 minutes",
            amount = 300000,
        ),
        TimeUtil(
            label = "10 minutes",
            amount = 600000,
        ),
        TimeUtil(
            label = "15 minutes",
            amount = 900000,
        ),
    )
}
