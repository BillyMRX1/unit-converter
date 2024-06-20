package com.mrx.unitconverter.helper

import java.text.DecimalFormat

object CommonUtil {
    val conversionFactors = mapOf(
        "Nanometers" to 1e-9,
        "Micrometers" to 1e-6,
        "Millimeters" to 0.001,
        "Centimeters" to 0.01,
        "Decimeters" to 0.1,
        "Meters" to 1.0,
        "Decameters" to 10.0,
        "Hectometers" to 100.0,
        "Kilometers" to 1000.0,
        "Inches" to 0.0254,
        "Feet" to 0.3048,
        "Yards" to 0.9144,
        "Miles" to 1609.34,
        "Nautical Miles" to 1852.0,
        "Astronomical Units" to 1.496e+11,
        "Light Years" to 9.461e+15
    )

    fun formatNumber(convertedValue: Double): String {
        val formatter = if (convertedValue % 1.0 == 0.0) {
            DecimalFormat("#,###")
        } else {
            DecimalFormat("#,###.#####")
        }
        return formatter.format(convertedValue)
    }
}