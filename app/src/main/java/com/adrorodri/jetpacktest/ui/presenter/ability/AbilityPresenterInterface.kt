package com.adrorodri.jetpacktest.ui.presenter.ability

import com.adrorodri.jetpacktest.domain.entities.Ability
import com.adrorodri.jetpacktest.domain.entities.Pokemon
import com.adrorodri.jetpacktest.ui.presenter.BasePresenterInterface

interface AbilityPresenterInterface: BasePresenterInterface {
    fun onAbilityLoaded(ability: Ability?)
}
