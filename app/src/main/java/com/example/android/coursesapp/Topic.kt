package com.example.android.coursesapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
   @StringRes val stringResourceId: Int,
    val associatedNumberOfCourses: Int,
   @DrawableRes val imageResourceId: Int)
