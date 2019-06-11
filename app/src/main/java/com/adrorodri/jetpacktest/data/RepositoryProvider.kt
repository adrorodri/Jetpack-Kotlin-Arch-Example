package com.adrorodri.jetpacktest.data

import android.content.Context
import com.adrorodri.jetpacktest.data.abilities.AbilitiesDisk
import com.adrorodri.jetpacktest.data.abilities.AbilitiesRepositoryImp
import com.adrorodri.jetpacktest.data.pokemons.PokemonsDisk
import com.adrorodri.jetpacktest.data.pokemons.PokemonsRepositoryImp
import com.adrorodri.jetpacktest.domain.interfaces.AbilitiesRepository
import com.adrorodri.jetpacktest.domain.interfaces.PokemonsRepository

object RepositoryProvider {
    lateinit var abilitiesRepository: AbilitiesRepository
    lateinit var pokemonRepository: PokemonsRepository

    operator fun invoke(context: Context): RepositoryProvider {
        abilitiesRepository = AbilitiesRepositoryImp(ApiFactory.makeAbilitiesApi(), AbilitiesDisk(context))
        pokemonRepository = PokemonsRepositoryImp(ApiFactory.makePokemonsApi(), PokemonsDisk(context))
        return this
    }
}