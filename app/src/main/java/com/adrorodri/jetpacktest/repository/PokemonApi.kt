package com.adrorodri.jetpacktest.repository

import com.adrorodri.jetpacktest.domain.model.Ability
import com.adrorodri.jetpacktest.domain.model.PokemonApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
    @GET("/api/v2/ability")
    fun getAbilitiesAsync(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Deferred<Response<PokemonApiResponse<Ability>>>
}