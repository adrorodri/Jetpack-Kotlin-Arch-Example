package com.adrorodri.jetpacktest.domain.useCases

import android.content.Context
import com.adrorodri.jetpacktest.data.RepositoryProvider
import com.adrorodri.jetpacktest.domain.entities.Pokemon

class GetPokemonById(context: Context, private val id: String?) {
    private val repository = RepositoryProvider(context).pokemonRepository

    suspend fun invoke(): Pokemon? {
        return repository.getPokemonById(id)?.apply { url = url.split("/").takeLast(2).first() }
    }
}
