package com.marcelo.buscarcep.ui.theme.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marcelo.buscarcep.ui.theme.Componentes.ButtonCustom
import com.marcelo.buscarcep.ui.theme.Componentes.InputTextFieldCustom
import com.marcelo.buscarcep.ui.theme.Teal700
import com.marcelo.buscarcep.ui.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCep(navController: NavController) {

    var inputCep by remember { mutableStateOf("") }
    var inputLogradouro by remember { mutableStateOf("") }
    var inputBairro by remember { mutableStateOf("") }
    var inputCidade by remember { mutableStateOf("") }
    var inputEstado by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Buscar CEP", fontSize = 18.sp)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Teal700,
                    titleContentColor = White
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())

        ) {

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                InputTextFieldCustom(
                    value = inputCep,
                    onValueChange = {
                        inputCep = it
                    },
                    placeholder = "Cep",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .width(200.dp)
                        .padding(20.dp, 50.dp, 20.dp, 10.dp)
                )

                ButtonCustom(
                    onClick = {

                    },
                    text = "Buscar CEP",
                    modifier = Modifier.padding(0.dp, 50.dp, 20.dp, 10.dp).height(55.dp).width(300.dp)
                )
            }

            Column (
                modifier = Modifier.fillMaxWidth()
            ) {
                InputTextFieldCustom(
                    value = inputLogradouro,
                    onValueChange = {
                        inputLogradouro = it
                    },
                    placeholder = "Logradouro",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                InputTextFieldCustom(
                    value = inputBairro,
                    onValueChange = {
                        inputBairro = it
                    },
                    placeholder = "Bairro",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                InputTextFieldCustom(
                    value = inputCidade,
                    onValueChange = {
                        inputCidade = it
                    },
                    placeholder = "Cidade",
                    modifier = Modifier.fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                ButtonCustom(
                    onClick = {

                    },
                    text = "Avançar",
                    modifier = Modifier.padding(start = 20.dp).height(55.dp)
                )

            }


        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun SearchPreview() {

    val navController = rememberNavController()
    SearchCep(navController = navController)
}