package com.zavedapok.ysedo.loanseu.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeAdapter(activity: FragmentActivity, val searchRes: List<DataStep>) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = searchRes.size

    override fun createFragment(position: Int): Fragment = HomeFragmentItem().apply {
        data = searchRes[position]
    }
}
