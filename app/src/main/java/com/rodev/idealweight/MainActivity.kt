package com.rodev.idealweight

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.rodev.idealweight.databinding.ActivityMainBinding
import com.rodev.idealweight.mode.BMICalcMode
import com.rodev.idealweight.mode.HeightCalcMode

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var calcMode: CalcMode

    private lateinit var heightCalcMode: HeightCalcMode
    private lateinit var bmiCalcMode: BMICalcMode

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        heightCalcMode = HeightCalcMode(binding)
        bmiCalcMode = BMICalcMode(binding)

        // Изначальный режим - по росту
        onModeChanged(binding.calculateModeGroup, R.id.height_mode)

        binding.calculateButton.setOnClickListener { onCalculateButtonClicked() }
        binding.calculateModeGroup.setOnCheckedChangeListener(::onModeChanged)
    }

    private fun onModeChanged(group: RadioGroup, id: Int) {
        binding.resultText.text = null
        calcMode = when (id) {
            R.id.height_mode -> heightCalcMode
            R.id.BMI_mode -> bmiCalcMode
            else -> null!!
        }
        calcMode.onModeChanged()
    }

    private fun onCalculateButtonClicked() {
        binding.resultText.text = calcMode.calculate()
    }
}