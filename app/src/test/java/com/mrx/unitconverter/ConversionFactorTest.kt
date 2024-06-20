package com.mrx.unitconverter

import com.mrx.unitconverter.data.model.ConversionFactor
import org.junit.Assert.assertEquals
import org.junit.Test

class ConversionFactorTest {

    @Test
    fun testConversionFactorConstructor() {
        val unit = "Meters"
        val factor = 1.0
        val conversionFactor = ConversionFactor(unit, factor)

        assertEquals(unit, conversionFactor.unit)
        assertEquals(factor, conversionFactor.factor, 0.0)
    }

    @Test
    fun testConversionFactorEquality() {
        val unit1 = "Meters"
        val factor1 = 1.0
        val unit2 = "Meters"
        val factor2 = 1.0
        val conversionFactor1 = ConversionFactor(unit1, factor1)
        val conversionFactor2 = ConversionFactor(unit2, factor2)

        assertEquals(conversionFactor1, conversionFactor2)
    }

    @Test
    fun testConversionFactorToString() {
        val unit = "Meters"
        val factor = 1.0
        val conversionFactor = ConversionFactor(unit, factor)

        assertEquals("ConversionFactor(unit=$unit, factor=$factor)", conversionFactor.toString())
    }
}