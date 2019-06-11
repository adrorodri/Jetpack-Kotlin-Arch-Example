package com.adrorodri.jetpacktest.domain.useCases

import android.content.Context
import com.adrorodri.jetpacktest.data.RepositoryProvider
import com.adrorodri.jetpacktest.domain.entities.Ability

class GetAbilityById(context: Context, private val id: String?) {
    private val repository = RepositoryProvider(context).abilitiesRepository

    suspend fun invoke(): Ability? {
        return repository.getAbilityById(id)?.apply { pokemon = pokemon.map { it.apply { pokemon.url = pokemon.url.split("/").takeLast(2).first() } } }
    }
}