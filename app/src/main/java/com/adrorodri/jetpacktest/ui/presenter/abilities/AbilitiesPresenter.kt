package com.adrorodri.jetpacktest.ui.presenter.abilities

import android.content.Context
import com.adrorodri.jetpacktest.domain.useCases.GetAbilities
import com.adrorodri.jetpacktest.ui.presenter.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AbilitiesPresenter(private val context: Context, override val presenter: AbilitiesPresenterInterface?) :
    BasePresenter(presenter) {

    fun loadAbilities() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val abilities = GetAbilities(context).invoke()
                presenter?.onAbilitiesLoaded(abilities)
            } catch (e: Exception) {
                e.printStackTrace()
                onError(e)
            }
        }
    }
}