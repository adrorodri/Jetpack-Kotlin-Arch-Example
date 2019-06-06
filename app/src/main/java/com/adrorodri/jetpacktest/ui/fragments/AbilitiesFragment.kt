package com.adrorodri.jetpacktest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.adrorodri.jetpacktest.R
import com.adrorodri.jetpacktest.domain.entities.Ability
import com.adrorodri.jetpacktest.ui.adapters.AbilitiesRecyclerViewAdapter
import com.adrorodri.jetpacktest.ui.presenter.abilities.AbilitiesPresenter
import com.adrorodri.jetpacktest.ui.presenter.abilities.AbilitiesPresenterInterface
import kotlinx.android.synthetic.main.fragment_abilities.*

class AbilitiesFragment : Fragment(), AbilitiesPresenterInterface {
    private lateinit var presenter: AbilitiesPresenter
    private lateinit var adapter: AbilitiesRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = AbilitiesPresenter(context!!, this)
        return inflater.inflate(R.layout.fragment_abilities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AbilitiesRecyclerViewAdapter(context!!, mutableListOf()) {
            Navigation.findNavController(view)
                .navigate(
                    R.id.action_abilitiesFragment_to_abilityFragment,
                    Bundle().apply { putString("id", it.url) })
        }
        rvAbilities.adapter = adapter
        rvAbilities.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        presenter.loadAbilities()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AbilitiesFragment()
    }

    override fun onAbilitiesLoaded(abilities: List<Ability>?) {
        adapter.setItems(abilities)
    }

    override fun onError(reason: String?) {
        toast(reason ?: "unknown error")
    }

    private fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
