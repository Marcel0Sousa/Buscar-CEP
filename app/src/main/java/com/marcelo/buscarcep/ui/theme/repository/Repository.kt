package com.marcelo.buscarcep.ui.theme.repository

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(){

    fun valor(): String {
        return "Marcelo Sousa"
    }
}