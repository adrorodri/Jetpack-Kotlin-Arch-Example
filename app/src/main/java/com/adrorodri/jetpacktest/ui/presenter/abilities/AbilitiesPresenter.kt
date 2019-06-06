package com.adrorodri.jetpacktest.ui.presenter.abilities

import android.content.Context
import com.adrorodri.jetpacktest.domain.useCases.GetAbilities
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class AbilitiesPresenter(private val context: Context, private val presenterInterface: AbilitiesPresenterInterface?) {

    fun onError(error: Any) {
        when (error) {
            is HttpException -> presenterInterface?.onError("Exception ${error.message}")
            is Throwable -> presenterInterface?.onError("Ooops: Something else went wrong ${error.message}")
        }
    }

    fun loadAbilities() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val abilities = GetAbilities(context).invoke()
                presenterInterface?.onAbilitiesLoaded(abilities)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}