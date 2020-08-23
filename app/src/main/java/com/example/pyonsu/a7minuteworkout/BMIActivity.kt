package com.example.pyonsu.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_b_m_i.*
import kotlinx.android.synthetic.main.activity_b_m_i.btnCalculateUnits
import kotlinx.android.synthetic.main.activity_b_m_i.etMetricUnitHeight
import kotlinx.android.synthetic.main.activity_b_m_i.etMetricUnitWeight
import kotlinx.android.synthetic.main.activity_b_m_i.etUsUnitWeight
import kotlinx.android.synthetic.main.activity_b_m_i.llDiplayBMIResult
import kotlinx.android.synthetic.main.activity_b_m_i.toolbar_bmi_activity
import kotlinx.android.synthetic.main.activity_b_m_i.tvBMIDescription
import kotlinx.android.synthetic.main.activity_b_m_i.tvBMIType
import kotlinx.android.synthetic.main.activity_b_m_i.tvBMIValue
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"
    val US_UNITS_VIEW = "US_UNIT_VIEW"

    var currentVisileView: String = METRIC_UNITS_VIEW

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        setSupportActionBar(toolbar_bmi_activity)

        val actionbar = supportActionBar
        if(actionbar != null){
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title = "CALCULATE BMI"
        }
        toolbar_bmi_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        btnCalculateUnits.setOnClickListener{
            if(currentVisileView.equals(METRIC_UNITS_VIEW)){
                if(validateMetricUnits()) {
                    val heightValue: Float = etMetricUnitHeight.text.toString().toFloat() / 100
                    val weightValue: Float = etMetricUnitWeight.text.toString().toFloat()

                    val bmi = weightValue / (heightValue * heightValue)
                    diaplayBMIResult(bmi)
                }else{
                    Toast.makeText(this@BMIActivity, "値入れてくれよ", Toast.LENGTH_SHORT)
                        .show()
                }
            }else{
                if(validateUSUnits()) {
                    val usUnitHeightValueFeet: String = etUsUnitHeightFeet.text.toString()
                    val usUnitHeightValueInch: String = etUsUnitHeightInch.text.toString()
                    val usUnitWeightValue: Float = etUsUnitWeight.text.toString().toFloat()

                    val heightValue = usUnitHeightValueInch.toFloat() + usUnitHeightValueFeet.toFloat() * 12

                    val bmi = 703 * (usUnitWeightValue / (heightValue * heightValue))
                    diaplayBMIResult(bmi)
                }else{
                    Toast.makeText(this@BMIActivity, "値入れてくれよ", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        makeVisibleMetricUnitsView()
        rgUnits.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.rbMetricUnits){
                makeVisibleMetricUnitsView()
            }else{
                makeVisibleUSUnitsView()
            }
        }
    }

    private fun makeVisibleUSUnitsView(){
        currentVisileView = US_UNITS_VIEW
        llMetricUnitsView.visibility = View.GONE

        etUsUnitWeight.text!!.clear()
        etUsUnitHeightFeet.text!!.clear()
        etUsUnitHeightInch.text!!.clear()

        llUsUnitsView.visibility = View.VISIBLE

        llDiplayBMIResult.visibility = View.INVISIBLE
    }

    private fun makeVisibleMetricUnitsView(){
        currentVisileView = METRIC_UNITS_VIEW
        llMetricUnitsView.visibility = View.VISIBLE

        etMetricUnitWeight.text!!.clear()
        etMetricUnitHeight.text!!.clear()

        llUsUnitsView.visibility = View.GONE


        llDiplayBMIResult.visibility = View.INVISIBLE
    }

    private fun diaplayBMIResult(bmi: Float){
        val bmiLabel: String
        val bmiDescription: String

        if (bmi.compareTo(15f) <= 0) {
            bmiLabel = "痩せすぎ"
            bmiDescription = "もっと食えよ"
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0
        ) {
            bmiLabel = "ちょい痩せすぎ"
            bmiDescription = "食べたほうがいいぞ"
        } else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0
        ) {
            bmiLabel = "痩せ気味"
            bmiDescription = "もう少し食べな"
        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0
        ) {
            bmiLabel = "普通"
            bmiDescription = "まあいいんじゃないか"
        } else if(bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0
        ) {
            bmiLabel = "太りすぎ"
            bmiDescription = "食べすぎや"
        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0
        ) {
            bmiLabel = "ちょいやば"
            bmiDescription = "気をつけろ"
        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0
        ) {
            bmiLabel = "危険"
            bmiDescription = "ほんまやばい"
        } else {
            bmiLabel = "．．．"
            bmiDescription = "ライザップへ行きな"
        }

        llDiplayBMIResult.visibility = View.VISIBLE
//        tvYourBMI.visibility = View.VISIBLE
//        tvBMIValue.visibility = View.VISIBLE
//        tvBMIType.visibility = View.VISIBLE
//        tvBMIDescription.visibility = View.VISIBLE

        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        tvBMIValue.text = bmiValue // Value is set to TextView
        tvBMIType.text = bmiLabel // Label is set to TextView
        tvBMIDescription.text = bmiDescription // Description is set to TextView
    }

    private fun validateMetricUnits():Boolean{
        var isValid = true

        if(etMetricUnitHeight.text.toString().isEmpty())
            isValid = false
        else if(etMetricUnitWeight.text.toString().isEmpty())
            isValid = false

        return isValid
    }

    private fun validateUSUnits():Boolean{
        var isValid = true

        when {
            etUsUnitHeightFeet.text.toString().isEmpty() -> isValid = false
            etUsUnitHeightInch.text.toString().isEmpty() -> isValid = false
            etUsUnitWeight.text.toString().isEmpty() -> isValid = false
        }

        return isValid
    }
}