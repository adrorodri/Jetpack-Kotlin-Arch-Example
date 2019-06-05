package com.adrorodri.jetpacktest.data.abilities

import com.adrorodri.jetpacktest.domain.interfaces.AbilitiesRepository
import com.adrorodri.jetpacktest.domain.entities.Ability

class AbilitiesRepositoryImp(private val network: AbilitiesApi, private val disk: AbilitiesDisk):
    AbilitiesRepository {
    override suspend fun getAllAbilities(): List<Ability>? {
        return try {
            val response = network.getAbilitiesAsync(20, 0).await()
            if (response.isSuccessful) {
                disk.setCachedAbilities(response.body()?.results)
                response.body()?.results
            } else {
                disk.getCachedAbilities()
            }
        } catch (e: Exception) {
            disk.getCachedAbilities()
        }
    }
}