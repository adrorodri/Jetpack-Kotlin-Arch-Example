package com.adrorodri.jetpacktest.domain.useCases

import android.content.Context
import com.adrorodri.jetpacktest.data.RepositoryProvider
import com.adrorodri.jetpacktest.domain.entities.Ability

class GetAbilities(context: Context) {
    private val repository = RepositoryProvider(context).abilitiesRepository

    suspend fun invoke(): List<Ability>? {
        return repository.getAllAbilities()
    }
}