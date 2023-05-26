package com.rodev.idealweight

import com.rodev.idealweight.databinding.ActivityMainBinding

abstract class CalcMode(
    protected val binding: ActivityMainBinding
) {

    abstract fun onModeChanged()

    abstract fun calculate(): String

}