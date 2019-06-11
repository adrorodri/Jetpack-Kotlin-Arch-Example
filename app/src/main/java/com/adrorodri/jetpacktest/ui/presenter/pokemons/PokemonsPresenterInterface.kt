package com.adrorodri.jetpacktest.ui.presenter.pokemons

import com.adrorodri.jetpacktest.domain.entities.Pokemon
import com.adrorodri.jetpacktest.ui.presenter.BasePresenterInterface

interface PokemonsPresenterInterface: BasePresenterInterface {
    fun onPokemonsLoaded(pokemons: List<Pokemon?>)
}