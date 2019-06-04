package com.adrorodri.jetpacktest.domain.model

import com.google.gson.annotations.Expose

data class PokemonApiResponse<T>(
    @Expose var count: Int,
    @Expose var next: String,
    @Expose var previous: String,
    @Expose var results: List<T>
)
