package com.adrorodri.jetpacktest.data.pokemons

import com.adrorodri.jetpacktest.domain.entities.Pokemon
import com.adrorodri.jetpacktest.domain.interfaces.PokemonsRepository

class PokemonsRepositoryImp(private val network: PokemonsApi, private val disk: PokemonsDisk) : PokemonsRepository {
    override suspend fun getPokemonById(id: String?): Pokemon? {
        return try {
            val response = network.getPokemonAsync(id!!).await()
            if (response.isSuccessful) {
                disk.setCachedPokemon(id, response.body())
                response.body()
            } else {
                disk.getCachedPokemon(id)
            }
        } catch (e: Exception) {
            disk.getCachedPokemon(id)
        }
    }
}