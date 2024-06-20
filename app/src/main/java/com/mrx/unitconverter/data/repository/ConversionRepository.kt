package com.mrx.unitconverter.data.repository

import com.mrx.unitconverter.data.model.ConversionFactor

object ConversionRepository {
    val conversionFactors = listOf(
        ConversionFactor("Nanometers", 1e-9),
        ConversionFactor("Micrometers", 1e-6),
        ConversionFactor("Millimeters", 0.001),
        ConversionFactor("Centimeters", 0.01),
        ConversionFactor("Decimeters", 0.1),
        ConversionFactor("Meters", 1.0),
        ConversionFactor("Decameters", 10.0),
        ConversionFactor("Hectometers", 100.0),
        ConversionFactor("Kilometers", 1000.0),
        ConversionFactor("Inches", 0.0254),
        ConversionFactor("Feet", 0.3048),
        ConversionFactor("Yards", 0.9144),
        ConversionFactor("Miles", 1609.34),
        ConversionFactor("Nautical Miles", 1852.0),
        ConversionFactor("Astronomical Units", 1.496e+11),
        ConversionFactor("Light Years", 9.461e+15)
    )
}