package com.marcelo.buscarcep.ui.theme.repository

import com.marcelo.buscarcep.ui.theme.datasource.Server
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(private val server: Server){
    suspend fun searchCep(
        cep: String,
        responseServer: (String, String, String, String) -> Unit,
        messageError: (String) -> Unit
    ) {
        server.searchCep(cep, responseServer, messageError)
    }
}