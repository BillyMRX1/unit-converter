package com.mrx.unitconverter.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrx.unitconverter.ui.theme.UnitConverterTheme

@Composable
fun NumberButton(value: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(100.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = value, fontSize = 32.sp)
    }
}

@Preview
@Composable
fun NumberButtonPreview() {
    UnitConverterTheme {
        NumberButton(value = "1", onClick = {})
    }
}