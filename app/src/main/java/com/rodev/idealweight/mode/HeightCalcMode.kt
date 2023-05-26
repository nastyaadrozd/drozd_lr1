package com.rodev.idealweight.mode

import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import com.rodev.idealweight.CalcMode
import com.rodev.idealweight.databinding.ActivityMainBinding
import kotlin.math.roundToInt


class HeightCalcMode(binding: ActivityMainBinding) : CalcMode(binding), OnItemSelectedListener {

    private var isGenderMale = true

    init {
        binding.gendersSpinner.onItemSelectedListener = this
    }

    override fun onModeChanged() {
        binding.gendersSpinner.isEnabled = true
        binding.weightInputLayout.isEnabled = false
    }

    override fun calculate(): String {
        val height = binding.heightTextField.text?.toString()?.toDoubleOrNull() ?: return ""

        val coef = if (isGenderMale) 100 else 110

        val weight = ( height - coef ) * 1.15

        return "Идеальный вес: ${weight.roundToInt()} кг."
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        isGenderMale = position == 0
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

}