package com.marcelo.buscarcep.ui.theme.Componentes

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.marcelo.buscarcep.ui.theme.Teal700
import com.marcelo.buscarcep.ui.theme.White

@Composable
fun InputTextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions

) {
    OutlinedTextField(
        value,
        onValueChange,
        placeholder = {
            Text(placeholder)
        },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Teal700,
            cursorColor = Teal700,
            focusedContainerColor = White,
            focusedIndicatorColor = Teal700,
            unfocusedContainerColor = White
        ),
        modifier = modifier,
        keyboardOptions = keyboardOptions

    )
}