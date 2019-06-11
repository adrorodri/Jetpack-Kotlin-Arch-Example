package com.adrorodri.jetpacktest.data.pokemons

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.adrorodri.jetpacktest.domain.entities.Pokemon
import com.adrorodri.jetpacktest.utils.fromJson
import com.google.gson.Gson

class PokemonsDisk(context: Context) {

    private var prefs: SharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
    private val gson: Gson = Gson()

    companion object {
        private const val SHARED_PREFS = "pokemon"
        private const val SHARED_PREFS_KEY_POKEMON = "pokemon_"
    }

    fun getCachedPokemon(id: String?): Pokemon? {
        return gson.fromJson<Pokemon>(prefs.getString(SHARED_PREFS_KEY_POKEMON + id, "{}")!!)
    }

    fun setCachedPokemon(id: String?, pokemon: Pokemon?) {
        return prefs.edit().putString(SHARED_PREFS_KEY_POKEMON + id, gson.toJson(pokemon)).apply()
    }
}