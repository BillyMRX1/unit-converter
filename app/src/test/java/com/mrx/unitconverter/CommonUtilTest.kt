package com.mrx.unitconverter

import com.mrx.unitconverter.helper.CommonUtil
import org.junit.Assert.assertEquals
import org.junit.Test

class CommonUtilTest {

    @Test
    fun testFormatNumber_Integer() {
        val value = 123456.0
        val formatted = CommonUtil.formatNumber(value)
        assertEquals("123,456", formatted)
    }

    @Test
    fun testFormatNumber_Decimal() {
        val value = 1234.56789
        val formatted = CommonUtil.formatNumber(value)
        assertEquals("1,234.56789", formatted)
    }

    @Test
    fun testConversionFactors() {
        val conversionFactors = CommonUtil.conversionFactors
        assertEquals(1e-9, conversionFactors["Nanometers"])
        assertEquals(1e-6, conversionFactors["Micrometers"])
        assertEquals(0.001, conversionFactors["Millimeters"])
        assertEquals(0.01, conversionFactors["Centimeters"])
        assertEquals(0.1, conversionFactors["Decimeters"])
        assertEquals(1.0, conversionFactors["Meters"])
        assertEquals(10.0, conversionFactors["Decameters"])
        assertEquals(100.0, conversionFactors["Hectometers"])
        assertEquals(1000.0, conversionFactors["Kilometers"])
        assertEquals(0.0254, conversionFactors["Inches"])
        assertEquals(0.3048, conversionFactors["Feet"])
        assertEquals(0.9144, conversionFactors["Yards"])
        assertEquals(1609.34, conversionFactors["Miles"])
        assertEquals(1852.0, conversionFactors["Nautical Miles"])
        assertEquals(1.496e+11, conversionFactors["Astronomical Units"])
        assertEquals(9.461e+15, conversionFactors["Light Years"])
    }
}