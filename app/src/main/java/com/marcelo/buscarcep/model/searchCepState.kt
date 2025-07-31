package com.marcelo.buscarcep.model

data class searchCepState(
    var cep: String = "",
    var logradouro: String = "",
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = ""
)