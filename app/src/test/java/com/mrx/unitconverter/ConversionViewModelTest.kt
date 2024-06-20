package com.mrx.unitconverter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mrx.unitconverter.data.model.ConversionFactor
import com.mrx.unitconverter.data.repository.ConversionRepository
import com.mrx.unitconverter.helper.CommonUtil
import com.mrx.unitconverter.viewmodel.ConversionViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ConversionViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var conversionRepository: ConversionRepository

    private lateinit var viewModel: ConversionViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        val conversionFactors = listOf(
            ConversionFactor("Centimeters", 0.01),
            ConversionFactor("Meters", 1.0)
        )
        `when`(conversionRepository.conversionFactors).thenReturn(conversionFactors)
        viewModel = ConversionViewModel()
    }

    @Test
    fun testConvertUnits() {
        viewModel.setInputValue("100")
        viewModel.setInputUnit("Centimeters")
        viewModel.setOutputUnit("Meters")
        assertEquals("1", viewModel.outputValue.value)
    }

    @Test
    fun testFormatNumber_Integer() {
        val number = 1234.0
        val formatted = CommonUtil.formatNumber(number)
        assertEquals("1,234", formatted)
    }

    @Test
    fun testFormatNumber_Decimal() {
        val number = 1234.56789
        val formatted = CommonUtil.formatNumber(number)
        assertEquals("1,234.56789", formatted)
    }
}
