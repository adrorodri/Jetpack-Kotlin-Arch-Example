package com.adrorodri.jetpacktest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.adrorodri.jetpacktest.R
import com.adrorodri.jetpacktest.domain.entities.Ability
import com.adrorodri.jetpacktest.ui.presenter.abilities.AbilitiesPresenter
import com.adrorodri.jetpacktest.ui.presenter.ability.AbilityPresenter
import com.adrorodri.jetpacktest.ui.presenter.ability.AbilityPresenterInterface
import kotlinx.android.synthetic.main.fragment_ability.*

class AbilityFragment : Fragment(), AbilityPresenterInterface {

    private lateinit var presenter: AbilityPresenter
    private var id: String? = null

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
        presenter = AbilityPresenter(context!!, this)
        id = arguments?.getString("id")
        return inflater.inflate(R.layout.fragment_ability, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadAbility(id)
    }

    override fun onAbilityLoaded(ability: Ability?) {
        tvNameValue.text = ability?.name
    }

    override fun onError(reason: String?) {
        toast(reason ?: "unknown error")
    }

    private fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
