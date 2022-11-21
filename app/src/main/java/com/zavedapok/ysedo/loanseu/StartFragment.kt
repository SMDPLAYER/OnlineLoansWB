package com.zavedapok.ysedo.loanseu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.zavedapok.ysedo.R
import com.zavedapok.ysedo.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class StartFragment : Fragment(R.layout.activity_main) {

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load(R.drawable.asl_hospitality)
            .placeholder(R.drawable.progress_animation)
            .into(imgHolder)
        imgHolder3.setOnClickListener {
            toast("Please Try Later")
        }
    }
}
