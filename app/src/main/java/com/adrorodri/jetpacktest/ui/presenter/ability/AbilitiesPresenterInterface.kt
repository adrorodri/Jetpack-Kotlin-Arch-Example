package com.adrorodri.jetpacktest.ui.presenter.ability

import com.adrorodri.jetpacktest.domain.entities.Ability

interface AbilityPresenterInterface {
    fun onAbilityLoaded(ability: Ability?)
    fun onError(reason: String?)
}
