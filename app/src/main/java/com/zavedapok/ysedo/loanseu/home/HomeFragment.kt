package com.zavedapok.ysedo.loanseu.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.android.material.tabs.TabLayoutMediator
import com.zavedapok.ysedo.R
import com.zavedapok.ysedo.loanseu.MainFragment
import com.zavedapok.ysedo.loanseu.StartFragment
import com.zavedapok.ysedo.loanseu.utils.toPx
import com.zavedapok.ysedo.utils.toast
import kotlinx.android.synthetic.main.fragment_home.*

data class DataStep(
    val step: String,
    val title: String,
    val desc: String,
)

class HomeFragment : Fragment(R.layout.fragment_home) {

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        switchTerms.setOnCheckedChangeListener { compoundButton, b ->
            if (switchTerms.isChecked){
                textView.alpha=1f
                textView.isClickable=true
            }else{
                textView.alpha=0.3f
                textView.isClickable=false
            }
        }
        switchHolder.setOnClickListener { switchTerms.isChecked = !switchTerms.isChecked }
        val list = arrayListOf(
            DataStep(
                "01",
                getString(R.string.submit_a_request),
                getString(R.string.all_paperwork),
            ),
            DataStep(
                "02",
                getString(R.string.check_offer),
                getString(R.string.deal)
            ),
            DataStep(
                "03",
                getString(R.string.recive_money),
                getString(R.string.funds)
            ),
        )
        pagerView.apply {
            clipToPadding = false // allow full width shown with padding
            clipChildren = false // allow left/right item is not clipped
            offscreenPageLimit = 2 // make sure left/right item is rendered
        }
        pagerView.setPadding(30.toPx.toInt(), 0, 30.toPx.toInt(), 0)
        // increase this offset to increase distance between 2 items
        val pageMarginPx = 10.toPx.toInt()
        val marginTransformer = MarginPageTransformer(pageMarginPx)
        pagerView.setPageTransformer(marginTransformer)

        pagerView.adapter = HomeAdapter(requireActivity(), list)

        TabLayoutMediator(tabLayout, pagerView) { tab, position ->
        }.attach()

        textView.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.mainContent, StartFragment())
                .commit()
        }
    }
}
