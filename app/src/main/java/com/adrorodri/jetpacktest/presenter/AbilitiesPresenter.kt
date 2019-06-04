package com.adrorodri.jetpacktest.presenter

import com.adrorodri.jetpacktest.repository.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class AbilitiesPresenter(private val presenterInterface: AbilitiesPresenterInterface) {
    private val service = RetrofitFactory.makeRetrofitService()
    fun loadAbilities() = CoroutineScope(Dispatchers.IO).launch {
        val request = service.getAbilitiesAsync(20, 0)
        withContext(Dispatchers.Main) {
            try {
                val response = request.await()
                if (response.isSuccessful) {
                    presenterInterface.onAbilitiesLoaded(response.body()?.results)
                } else {
                    presenterInterface.onError("Error: ${response.code()}")
                }
            } catch (e: HttpException) {
                presenterInterface.onError("Exception ${e.message}")
            } catch (e: Throwable) {
                presenterInterface.onError("Ooops: Something else went wrong")
            }
        }
    }
}