package com.rolando.casapaico.poketinder

//estructura de jsom que se obtiene de la api
data class PokemonListResponse(
    val count: Int,
    val next: String,
    val results: List<PokemonResponse>
)

