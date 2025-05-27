package com.marcelo.buscarcep.ui.theme.Componentes

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.marcelo.buscarcep.ui.theme.Teal700
import com.marcelo.buscarcep.ui.theme.White

@Composable
fun ButtonCustom(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,

) {
    Button(
        onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Teal700
        ),
        modifier = modifier,
    ) {
        Text(text = text, fontSize = 18.sp, color = White, fontWeight = FontWeight.Bold)
    }
}