package com.adrorodri.jetpacktest.domain.interfaces

import com.adrorodri.jetpacktest.domain.entities.Ability

interface AbilitiesRepository {
    suspend fun getAllAbilities(): List<Ability>?
}