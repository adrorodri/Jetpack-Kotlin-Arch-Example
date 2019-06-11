package com.adrorodri.jetpacktest.domain.interfaces

import com.adrorodri.jetpacktest.domain.entities.Pokemon

interface PokemonsRepository {
    suspend fun getPokemonById(id: String?): Pokemon?
}