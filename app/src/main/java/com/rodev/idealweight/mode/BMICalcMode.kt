package com.rodev.idealweight.mode

import com.rodev.idealweight.CalcMode
import com.rodev.idealweight.databinding.ActivityMainBinding

class BMICalcMode(binding: ActivityMainBinding) : CalcMode(binding) {

    override fun onModeChanged() {
        binding.gendersSpinner.isEnabled = false
        binding.weightInputLayout.isEnabled = true
    }

    override fun calculate(): String {
        val heightCM = binding.heightTextField.text?.toString()?.toDoubleOrNull() ?: return ""
        val weight = binding.weightTextField.text?.toString()?.toDoubleOrNull() ?: return ""

        val height = heightCM / 100 // В метрах

        val bmi = weight / (height * height)

        var result = "Результат: "

        if (bmi <= 16) result += "Дефицит массы тела"
        if (bmi > 16 && bmi <= 18.5) result += "Недостаточная масса тела"
        if (bmi > 18.5 && bmi < 25) result += "Норма"
        if (bmi >= 25 && bmi < 30) result += "Избыточная масса тела"
        if (bmi >= 30 && bmi < 35) result += "Ожирение первой степени"
        if (bmi >= 35 && bmi < 40) result += "Ожирение второй степени"
        if (bmi >= 40) result += "Ожирение третьей степени"

        return result
    }

}