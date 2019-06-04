package com.adrorodri.jetpacktest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.adrorodri.jetpacktest.R
import com.adrorodri.jetpacktest.domain.model.Ability
import com.adrorodri.jetpacktest.presenter.AbilitiesPresenter
import com.adrorodri.jetpacktest.presenter.AbilitiesPresenterInterface
import com.adrorodri.jetpacktest.ui.adapters.AbilitiesRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_red.*

class AbilitiesFragment : Fragment(), AbilitiesPresenterInterface {
    private var presenter: AbilitiesPresenter = AbilitiesPresenter(this)
    private lateinit var adapter: AbilitiesRecyclerViewAdapter

    override fun onError(reason: String) {
        toast(reason)
    }

    override fun onAbilitiesLoaded(results: List<Ability>?) {
        adapter.setItems(results)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_red, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AbilitiesRecyclerViewAdapter(context!!, mutableListOf())
        rvAbilities.adapter = adapter
        rvAbilities.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        presenter.loadAbilities()
    }

    private fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AbilitiesFragment()
    }
}
