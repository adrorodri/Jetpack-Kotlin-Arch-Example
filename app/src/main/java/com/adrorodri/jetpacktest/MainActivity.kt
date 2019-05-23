package com.adrorodri.jetpacktest

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), RedFragment.OnFragmentInteractionListener,
    blueFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        // TODO("not implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
