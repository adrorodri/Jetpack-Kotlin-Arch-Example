package com.adrorodri.jetpacktest.data.abilities

import com.adrorodri.jetpacktest.domain.entities.Ability
import com.adrorodri.jetpacktest.domain.entities.PokemonApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AbilitiesApi {
    @GET("/api/v2/ability")
    fun getAbilitiesAsync(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Deferred<Response<PokemonApiResponse<Ability>>>
}