package com.adrorodri.jetpacktest.domain.entities

import com.google.gson.annotations.Expose

data class Pokemon(@Expose var abilities: List<Ability>,
                   @Expose var url: String,
                   @Expose var height: Int,
                   @Expose var id: Int,
                   @Expose var name: String,
                   @Expose var weigth: Int)
