package com.marcelo.buscarcep.ui.theme.datasource

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import javax.inject.Inject

class Server @Inject constructor() {

    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun searchCep(
        cep: String,
        responseServer: (String, String, String, String) -> Unit,
        messageError: (String) -> Unit
    ) {
        val responseServer = httpClient.get(
            urlString = "https://viacep.com.br/ws/${cep}/json/"
        )

        try {

            if (responseServer.status.value == 200) {
                val address = Json.parseToJsonElement(responseServer.bodyAsText()).jsonObject
                val logradouro = address["logradouro"]!!.jsonPrimitive.content
                val bairro = address["bairro"]!!.jsonPrimitive.content
                val localidade = address["localidade"]!!.jsonPrimitive.content
                val uf = address["uf"]!!.jsonPrimitive.content
                responseServer(logradouro, bairro, localidade, uf)
            } else {
                messageError("Cep inválido!")
            }

        } catch (e: Exception) {
            Log.d("ErrorServer", e.toString())
        }
    }
}