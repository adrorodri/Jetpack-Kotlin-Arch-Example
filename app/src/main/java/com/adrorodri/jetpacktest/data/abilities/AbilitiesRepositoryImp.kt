package com.adrorodri.jetpacktest.data.abilities

import com.adrorodri.jetpacktest.domain.entities.Ability
import com.adrorodri.jetpacktest.domain.interfaces.AbilitiesRepository

class AbilitiesRepositoryImp(private val network: AbilitiesApi, private val disk: AbilitiesDisk) :
    AbilitiesRepository {
    override suspend fun getAbilityById(id: String?): Ability? {
        return try {
            val response = network.getAbilityByIdAsync(id!!).await()
            if (response.isSuccessful) {
                disk.setCachedAbility(id, response.body())
                response.body()
            } else {
                disk.getCachedAbility(id)
            }
        } catch (e: Exception) {
            disk.getCachedAbility(id!!)
        }
    }

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