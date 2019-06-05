package com.adrorodri.jetpacktest.ui.presenter

import com.adrorodri.jetpacktest.domain.entities.Ability

interface AbilitiesPresenterInterface {
    fun onAbilitiesLoaded(results: List<Ability>?)
    fun onError(reason: String?)
}
