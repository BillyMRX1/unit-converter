package com.mrx.unitconverter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrx.unitconverter.data.repository.ConversionRepository
import com.mrx.unitconverter.helper.CommonUtil.formatNumber

class ConversionViewModel : ViewModel() {
    private val _inputValue = MutableLiveData("0")
    val inputValue: LiveData<String> = _inputValue

    private val _outputValue = MutableLiveData("0")
    val outputValue: LiveData<String> = _outputValue

    private val _inputUnit = MutableLiveData("Centimeters")
    val inputUnit: LiveData<String> = _inputUnit

    private val _outputUnit = MutableLiveData("Meters")
    val outputUnit: LiveData<String> = _outputUnit

    private val _inputExpanded = MutableLiveData(false)
    val inputExpanded: LiveData<Boolean> = _inputExpanded

    private val _outputExpanded = MutableLiveData(false)
    val outputExpanded: LiveData<Boolean> = _outputExpanded

    private val conversionFactors =
        ConversionRepository.conversionFactors.associate { it.unit to it.factor }

    fun setInputValue(value: String) {
        _inputValue.value = value
        convertUnits()
    }

    fun setInputUnit(unit: String) {
        _inputUnit.value = unit
        convertUnits()
    }

    fun setOutputUnit(unit: String) {
        _outputUnit.value = unit
        convertUnits()
    }

    fun setOutputExpanded(isExpanded: Boolean) {
        _outputExpanded.value = isExpanded
    }

    fun setInputExpanded(isExpanded: Boolean) {
        _inputExpanded.value = isExpanded
    }

    private fun convertUnits() {
        val inputValueDouble = _inputValue.value?.toDoubleOrNull() ?: 0.0
        val inputFactor = conversionFactors[_inputUnit.value] ?: 1.0
        val outputFactor = conversionFactors[_outputUnit.value] ?: 1.0
        val convertedValue = inputValueDouble * inputFactor / outputFactor
        _outputValue.value = formatNumber(convertedValue)
    }
}
