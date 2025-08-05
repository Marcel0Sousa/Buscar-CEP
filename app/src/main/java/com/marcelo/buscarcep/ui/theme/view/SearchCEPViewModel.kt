package com.marcelo.buscarcep.ui.theme.view

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcelo.buscarcep.model.searchCepState
import com.marcelo.buscarcep.ui.theme.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCEPViewModel @Inject constructor(
    private val repository: Repository,
    private val application: Application,
) : ViewModel() {


    val _valor = MutableStateFlow("")
    val valorAlterado: StateFlow<String> = _valor
    var searchCepState by mutableStateOf(searchCepState())
        private set

    fun searchCep(
        cep: String,
        responseServer: (String, String, String, String) -> Unit,
        messageError: (String) -> Unit,
    ) {
        viewModelScope.launch {
            repository.searchCep(cep, responseServer, messageError)
        }
    }

    fun onClick() {
        searchCep(
            searchCepState.cep,
            responseServer = { logradouro, bairro, cidade, estado ->
                searchCepState = searchCepState.copy(
                    logradouro = logradouro,
                    bairro = bairro,
                    cidade = cidade,
                    estado = estado
                )
            }, messageError = { messageError ->
                Toast.makeText(application, messageError, Toast.LENGTH_LONG).show()
            })
    }

    fun onCepChange(newCep: String) {
        searchCepState = searchCepState.copy(cep = newCep)
    }

    fun onLogradouroChange(newLogradouro: String) {
        searchCepState = searchCepState.copy(logradouro = newLogradouro)
    }

    fun onBairroChange(newBairro: String) {
        searchCepState = searchCepState.copy(bairro = newBairro)
    }

    fun onCidadeChange(newCidade: String) {
        searchCepState = searchCepState.copy(cidade = newCidade)
    }

    fun onEstadoChange(newEstado: String) {
        searchCepState = searchCepState.copy(estado = newEstado)
    }
}