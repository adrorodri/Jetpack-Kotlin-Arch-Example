package com.adrorodri.jetpacktest.data

import android.content.Context
import com.adrorodri.jetpacktest.data.abilities.AbilitiesDisk
import com.adrorodri.jetpacktest.data.abilities.AbilitiesRepositoryImp
import com.adrorodri.jetpacktest.domain.interfaces.AbilitiesRepository

object RepositoryProvider {
    lateinit var abilitiesRepository: AbilitiesRepository

    operator fun invoke(context: Context): RepositoryProvider {
        abilitiesRepository = AbilitiesRepositoryImp(
            ApiFactory.makePokemonApi(),
            AbilitiesDisk(context)
        )
        return this
    }
}