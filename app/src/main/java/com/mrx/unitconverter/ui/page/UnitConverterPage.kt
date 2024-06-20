package com.mrx.unitconverter.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mrx.unitconverter.helper.CommonUtil.formatNumber
import com.mrx.unitconverter.ui.components.ConverterButtons
import com.mrx.unitconverter.ui.components.UnitDropdown
import com.mrx.unitconverter.ui.theme.UnitConverterTheme
import com.mrx.unitconverter.viewmodel.ConversionViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter(viewModel: ConversionViewModel = viewModel()) {
    val inputValue by viewModel.inputValue.observeAsState("0")
    val outputValue by viewModel.outputValue.observeAsState("0")
    val inputUnit by viewModel.inputUnit.observeAsState("Centimeters")
    val outputUnit by viewModel.outputUnit.observeAsState("Meters")
    val inputExpanded = viewModel.inputExpanded.observeAsState(false)
    val outputExpanded = viewModel.outputExpanded.observeAsState(false)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Unit Converter") }) }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    UnitDropdown(
                        selectedUnit = inputUnit,
                        onUnitChange = {
                            viewModel.setInputUnit(it)
                        },
                        expanded = inputExpanded.value,
                        onExpandedChange = { viewModel.setInputExpanded(it) }
                    )
                    Row {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            formatNumber(inputValue.toDouble()),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    UnitDropdown(
                        selectedUnit = outputUnit,
                        onUnitChange = {
                            viewModel.setOutputUnit(it)
                        },
                        expanded = outputExpanded.value,
                        onExpandedChange = { viewModel.setOutputExpanded(it) }
                    )
                    Row {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            outputValue,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
            Box(Modifier.padding(bottom = 16.dp)) {
                ConverterButtons(inputValue) { newValue ->
                    if (newValue.length < 20) {
                        viewModel.setInputValue(newValue.toLong().toString())
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}