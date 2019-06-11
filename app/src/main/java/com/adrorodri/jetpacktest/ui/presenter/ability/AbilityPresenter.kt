package com.adrorodri.jetpacktest.ui.presenter.ability

import android.content.Context
import com.adrorodri.jetpacktest.domain.useCases.GetAbilityById
import com.adrorodri.jetpacktest.ui.presenter.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AbilityPresenter(private val context: Context, override val presenter: AbilityPresenterInterface?) :
    BasePresenter(presenter) {

    fun loadAbility(id: String?) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val ability = GetAbilityById(context, id).invoke()
                presenter?.onAbilityLoaded(ability)
            } catch (e: Exception) {
                e.printStackTrace()
                onError(e)
            }
        }
    }
}