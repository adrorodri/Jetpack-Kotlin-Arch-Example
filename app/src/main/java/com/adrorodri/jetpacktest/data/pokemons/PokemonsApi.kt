package com.adrorodri.jetpacktest.data.pokemons

import com.adrorodri.jetpacktest.domain.entities.Pokemon
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonsApi {
    @GET("/api/v2/pokemon/{id}")
    fun getPokemonAsync(
        @Path("id") id: String
    ): Deferred<Response<Pokemon>>
}