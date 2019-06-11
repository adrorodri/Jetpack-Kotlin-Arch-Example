package com.adrorodri.jetpacktest.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adrorodri.jetpacktest.R
import com.adrorodri.jetpacktest.domain.entities.Pokemon
import com.adrorodri.jetpacktest.ui.presenter.pokemons.PokemonsPresenterInterface
import com.adrorodri.jetpacktest.utils.fromJson
import com.google.gson.Gson

class PokemonsFragment : Fragment() {

    private var pokemons: List<Pokemon>? = listOf()
    private val gson: Gson = Gson()

    companion object {
        @JvmStatic
        fun newInstance() = PokemonsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemons =
                gson.fromJson<List<Pokemon>>(if (it.containsKey("pokemons")) it.getString("pokemons")!! else "[]")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemons, container, false)
    }
}
