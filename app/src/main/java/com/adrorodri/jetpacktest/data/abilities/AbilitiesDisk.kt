package com.adrorodri.jetpacktest.data.abilities

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.adrorodri.jetpacktest.domain.entities.Ability
import com.adrorodri.jetpacktest.utils.fromJson
import com.google.gson.Gson

class AbilitiesDisk(private val context: Context) {

    private var prefs: SharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
    private val gson: Gson = Gson()

    companion object {
        private const val SHARED_PREFS = "pokemon"
        private const val SHARED_PREFS_KEY_ABILITIES = "abilities"
        private const val SHARED_PREFS_KEY_ABILITY = "ability_"
    }

    fun getCachedAbilities(): List<Ability>? {
        return gson.fromJson<List<Ability>>(prefs.getString(SHARED_PREFS_KEY_ABILITIES, "[]")!!)
    }

    fun setCachedAbilities(abilities: List<Ability>?) {
        return prefs.edit().putString(SHARED_PREFS_KEY_ABILITIES, gson.toJson(abilities)).apply()
    }

    fun getCachedAbility(id: String): Ability? {
        return gson.fromJson<Ability>(prefs.getString(SHARED_PREFS_KEY_ABILITY + id, "{}")!!)
    }

    fun setCachedAbility(id: String, ability: Ability?) {
        return prefs.edit().putString(SHARED_PREFS_KEY_ABILITY + id, gson.toJson(ability)).apply()
    }
}