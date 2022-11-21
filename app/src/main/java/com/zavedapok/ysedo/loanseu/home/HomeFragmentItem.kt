package com.zavedapok.ysedo.loanseu.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home_item.*
import com.zavedapok.ysedo.R
import com.zavedapok.ysedo.loanseu.home.DataStep

class HomeFragmentItem : Fragment(R.layout.fragment_home_item) {
    var data: DataStep? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        tvNAme.text = nAme
//
//        tvProf.text = length
//
        tvStep.text = data?.step ?: ""
        tvTitle.text = data?.title ?: ""
        tvDesc.text = data?.desc ?: ""
        Glide.with(requireActivity()).load(R.drawable.rectangle1).placeholder(R.drawable.progress_animation)
            .into(imgBgCard)
    }
}
