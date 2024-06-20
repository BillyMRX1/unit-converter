package com.mrx.unitconverter.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrx.unitconverter.helper.CommonUtil.conversionFactors

@Composable
fun UnitDropdown(
    selectedUnit: String,
    onUnitChange: (String) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
) {
    Box {
        Button(
            onClick = { onExpandedChange(true) },
            modifier = Modifier.width(150.dp)
        ) {
            Text(selectedUnit)
            Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) }
        ) {
            conversionFactors.forEach { (unit) ->
                DropdownMenuItem(text = { Text(unit) },
                    onClick = {
                        onExpandedChange(false)
                        onUnitChange(unit)
                    })
            }
        }
    }
}

@Preview
@Composable
fun UnitDropdownPreview() {
    UnitDropdown(
        selectedUnit = "Centimeters",
        onUnitChange = {},
        expanded = false,
        onExpandedChange = {})
}