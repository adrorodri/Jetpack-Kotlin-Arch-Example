package com.adrorodri.jetpacktest.ui.presenter.ability

import android.content.Context
import com.adrorodri.jetpacktest.domain.useCases.GetAbilityById
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class AbilityPresenter(private val context: Context, private val presenterInterface: AbilityPresenterInterface?) {

    fun onError(error: Any) {
        when (error) {
            is HttpException -> presenterInterface?.onError("Exception ${error.message}")
            is Throwable -> presenterInterface?.onError("Ooops: Something else went wrong")
        }
    }

    fun loadAbility(id: String?) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val ability = GetAbilityById(context, id).invoke()
                presenterInterface?.onAbilityLoaded(ability)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}