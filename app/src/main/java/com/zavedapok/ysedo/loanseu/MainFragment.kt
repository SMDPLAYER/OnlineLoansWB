package com.zavedapok.ysedo.loanseu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zavedapok.ysedo.R
import kotlinx.android.synthetic.main.main_fragment.*
import com.zavedapok.ysedo.loanseu.home.HomeFragment

class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var viewModel: MainViewModel

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.beginTransaction().replace(R.id.mainContent, HomeFragment())
            .commit()
        btnHome.setColorFilter(ContextCompat.getColor(requireContext(), R.color.red))

        btnHome.setOnClickListener {
            openHome()
        }
        btnFav.setOnClickListener {
            openFav()
        }

        btnChat.setOnClickListener {
            openMessage()
        }
    }

    fun openFav() {
        parentFragmentManager.beginTransaction().replace(R.id.mainContent, FaqFragment())
            .commit()
        btnHome.setColorFilter(null)
        btnChat.setColorFilter(null)
        btnFav.setColorFilter(ContextCompat.getColor(requireContext(), R.color.red))
    }

    fun openMessage() {
        parentFragmentManager.beginTransaction().replace(R.id.mainContent, StartFragment())
            .commit()
        btnFav.setColorFilter(null)

        btnHome.setColorFilter(null)
        btnChat.setColorFilter(ContextCompat.getColor(requireContext(), R.color.red))
    }

    fun openHome() {

        parentFragmentManager.beginTransaction().replace(R.id.mainContent, HomeFragment())
            .commit()
        btnChat.setColorFilter(null)
        btnFav.setColorFilter(null)
        btnHome.setColorFilter(ContextCompat.getColor(requireContext(), R.color.red))
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.liveData.observe(this, {
        })
        // TODO: Use the ViewModel
    }
}
