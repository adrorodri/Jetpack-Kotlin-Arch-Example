package com.adrorodri.jetpacktest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.adrorodri.jetpacktest.R
import com.adrorodri.jetpacktest.domain.entities.Ability
import com.adrorodri.jetpacktest.domain.entities.Pokemon
import com.adrorodri.jetpacktest.ui.presenter.ability.AbilityPresenter
import com.adrorodri.jetpacktest.ui.presenter.ability.AbilityPresenterInterface
import com.adrorodri.jetpacktest.ui.presenter.pokemons.PokemonsPresenter
import com.adrorodri.jetpacktest.ui.presenter.pokemons.PokemonsPresenterInterface
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_ability.*

class AbilityFragment : Fragment(), AbilityPresenterInterface, PokemonsPresenterInterface {

    private lateinit var abilityPresenter: AbilityPresenter
    private lateinit var pokemonsPresenter: PokemonsPresenter
    private lateinit var navController: NavController
    private var id: String? = null
    private val gson: Gson = Gson()

    companion object {
        @JvmStatic
        fun newInstance(id: String) = AbilityFragment().apply {
            arguments = Bundle().apply { putString("id", id) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        abilityPresenter = AbilityPresenter(context!!, this)
        pokemonsPresenter = PokemonsPresenter(context!!, this)
        id = arguments?.getString("id")
        return inflater.inflate(R.layout.fragment_ability, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        abilityPresenter.loadAbility(id)
    }

    override fun onAbilityLoaded(ability: Ability?) {
        tvNameValue.text = ability?.name

        btViewPokemons.isEnabled = true
        btViewPokemons.setOnClickListener {
            pokemonsPresenter.loadPokemons(ability?.pokemon?.map { it.pokemon.url }!!)
        }
    }

    override fun onPokemonsLoaded(pokemons: List<Pokemon?>) {
        navController.navigate(R.id.action_abilityFragment_to_pokemonsFragment,
            Bundle().apply { putString("pokemons", gson.toJson(pokemons)) })
    }

    override fun onError(reason: String?) {
        toast(reason ?: "unknown error")
        btViewPokemons.isEnabled = false
    }

    private fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
