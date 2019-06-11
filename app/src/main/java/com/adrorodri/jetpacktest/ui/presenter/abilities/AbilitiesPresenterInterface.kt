package com.adrorodri.jetpacktest.ui.presenter.abilities

import com.adrorodri.jetpacktest.domain.entities.Ability
import com.adrorodri.jetpacktest.ui.presenter.BasePresenterInterface

interface AbilitiesPresenterInterface : BasePresenterInterface {
    fun onAbilitiesLoaded(abilities: List<Ability>?)
}
