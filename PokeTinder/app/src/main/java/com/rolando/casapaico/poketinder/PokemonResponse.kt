package com.rolando.casapaico.poketinder

data class PokemonResponse(
    val name: String,
    val url: String
) {


    fun getPokemonId() = getIdPokemonFromUrl(url)

    fun getIdPokemonFromUrl(url: String): String {
       val  data  =url.split("/").toTypedArray()[6]
         println( "[6]: ${data}")
        return  data;
    }

    fun getPokemonImage(): String {
        val data= "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonId()}.png"
        println("url imagen : ${data}")
        return  data;
    }
}
