package com.adrorodri.jetpacktest.presenter

import com.adrorodri.jetpacktest.domain.model.Ability

interface AbilitiesPresenterInterface {
    fun onAbilitiesLoaded(results: List<Ability>?)
    fun onError(reason: String)
}
