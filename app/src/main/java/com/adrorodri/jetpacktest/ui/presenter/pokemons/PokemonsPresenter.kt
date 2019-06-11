package com.adrorodri.jetpacktest.ui.presenter.pokemons

import android.content.Context
import com.adrorodri.jetpacktest.domain.useCases.GetPokemonById
import com.adrorodri.jetpacktest.ui.presenter.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonsPresenter(private val context: Context, override val presenter: PokemonsPresenterInterface?) :
    BasePresenter(presenter) {

    fun loadPokemons(ids: List<String>) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val pokemons = ids.map {
                    GetPokemonById(context, it).invoke()
                }
                presenter?.onPokemonsLoaded(pokemons)
            } catch (e: Exception) {
                e.printStackTrace()
                onError(e)
            }
        }
    }
}