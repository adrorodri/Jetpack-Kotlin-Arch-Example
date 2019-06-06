package com.adrorodri.jetpacktest.ui.presenter.abilities

import com.adrorodri.jetpacktest.domain.entities.Ability

interface AbilitiesPresenterInterface {
    fun onAbilitiesLoaded(abilities: List<Ability>?)
    fun onError(reason: String?)
}
