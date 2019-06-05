package com.adrorodri.jetpacktest.data

import com.adrorodri.jetpacktest.data.abilities.AbilitiesApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {
    private const val BASE_URL = "https://pokeapi.co"
    fun makePokemonApi(): AbilitiesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(AbilitiesApi::class.java)
    }
}