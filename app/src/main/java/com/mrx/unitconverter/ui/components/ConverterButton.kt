package com.mrx.unitconverter.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrx.unitconverter.ui.theme.UnitConverterTheme

@Composable
fun ConverterButtons(inputValue: String, onInputChange: (String) -> Unit) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumberButton(value = "1") { onInputChange(inputValue + "1") }
            NumberButton(value = "2") { onInputChange(inputValue + "2") }
            NumberButton(value = "3") { onInputChange(inputValue + "3") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumberButton(value = "4") { onInputChange(inputValue + "4") }
            NumberButton(value = "5") { onInputChange(inputValue + "5") }
            NumberButton(value = "6") { onInputChange(inputValue + "6") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumberButton(value = "7") { onInputChange(inputValue + "7") }
            NumberButton(value = "8") { onInputChange(inputValue + "8") }
            NumberButton(value = "9") { onInputChange(inputValue + "9") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumberButton(value = "C") { onInputChange("0") }
            NumberButton(value = "0") { onInputChange(inputValue + "0") }
            NumberButton(value = "⌫") {
                if (inputValue.isNotEmpty()) {
                    if (inputValue.length == 1) {
                        onInputChange("0")
                    } else {
                        onInputChange(inputValue.dropLast(1))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ConverterButtonsPreview() {
    UnitConverterTheme {
        ConverterButtons(inputValue = "", onInputChange = {})
    }
}