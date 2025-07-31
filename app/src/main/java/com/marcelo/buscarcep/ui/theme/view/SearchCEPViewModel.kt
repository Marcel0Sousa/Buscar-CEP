package com.marcelo.buscarcep.ui.theme.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
class SearchCEPViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val _valor = MutableStateFlow("")
    val valorAlterado: StateFlow<String> = _valor
    var searchCepState by mutableStateOf(searchCepState())
        private set

    fun valor(): String {
        viewModelScope.launch {
            repository.valor()
        }

        return valorAlterado.toString()
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