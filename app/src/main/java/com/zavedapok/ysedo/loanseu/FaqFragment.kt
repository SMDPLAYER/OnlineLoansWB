package com.zavedapok.ysedo.loanseu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.zavedapok.ysedo.R
import kotlinx.android.synthetic.main.fragment_faq.*

class FaqFragment : Fragment(R.layout.fragment_faq) {

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1.setOnClickListener {
            txt1.isGone = !txt1.isGone
            if (txt1.isGone) {
                Glide.with(this).load(R.drawable.img_bg_mini_card2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img1)
                img11.setImageResource(R.drawable.ic_baseline_add_circle_24)
            } else {
                img11.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                Glide.with(this).load(R.drawable.img_bg_card_small2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img1)
            }
        }
        btn2.setOnClickListener {
            txt2.isGone = !txt2.isGone
            if (txt2.isGone) {
                Glide.with(this).load(R.drawable.img_bg_mini_card2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img2)
                img22.setImageResource(R.drawable.ic_baseline_add_circle_24)
            } else {
                img22.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                Glide.with(this).load(R.drawable.img_bg_card_small2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img2)
            }
        }

        btn3.setOnClickListener {
            txt3.isGone = !txt3.isGone
            if (txt3.isGone) {
                Glide.with(this).load(R.drawable.img_bg_mini_card2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img3)
                img33.setImageResource(R.drawable.ic_baseline_add_circle_24)
            } else {
                img33.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                Glide.with(this).load(R.drawable.img_bg_card_small2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img3)
            }
        }
        btn4.setOnClickListener {
            txt4.isGone = !txt4.isGone
            if (txt4.isGone) {
                Glide.with(this).load(R.drawable.img_bg_mini_card2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img4)
                img44.setImageResource(R.drawable.ic_baseline_add_circle_24)
            } else {
                img44.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                Glide.with(this).load(R.drawable.img_bg_card_small2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img4)
            }
        }
        btn5.setOnClickListener {
            txt5.isGone = !txt5.isGone
            if (txt5.isGone) {
                Glide.with(this).load(R.drawable.img_bg_mini_card2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img5)
                img55.setImageResource(R.drawable.ic_baseline_add_circle_24)
            } else {
                img55.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                Glide.with(this).load(R.drawable.img_bg_card_small2)
                    .placeholder(R.drawable.progress_animation)
                    .into(img5)
            }
        }
//        btn6.setOnClickListener {
//            txt6.isGone = !txt6.isGone
//            if (txt2.isGone) {
//                Glide.with(this).load(R.drawable.img_bg_mini_card2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img6)
//                img66.setImageResource(R.drawable.ic_baseline_add_circle_24)
//            } else {
//                img22.setImageResource(R.drawable.ic_baseline_remove_circle_24)
//                Glide.with(this).load(R.drawable.img_bg_card_small2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img6)
//            }
//        }
//        btn7.setOnClickListener {
//            txt7.isGone = !txt7.isGone
//            if (txt7.isGone) {
//                Glide.with(this).load(R.drawable.img_bg_mini_card2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img7)
//                img77.setImageResource(R.drawable.ic_baseline_add_circle_24)
//            } else {
//                img77.setImageResource(R.drawable.ic_baseline_remove_circle_24)
//                Glide.with(this).load(R.drawable.img_bg_card_small2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img7)
//            }
//        }
//        btn8.setOnClickListener {
//            txt8.isGone = !txt8.isGone
//            if (txt8.isGone) {
//                Glide.with(this).load(R.drawable.img_bg_mini_card2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img8)
//                img88.setImageResource(R.drawable.ic_baseline_add_circle_24)
//            } else {
//                img88.setImageResource(R.drawable.ic_baseline_remove_circle_24)
//                Glide.with(this).load(R.drawable.img_bg_card_small2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img8)
//            }
//        }
//        btn9.setOnClickListener {
//            txt9.isGone = !txt9.isGone
//            if (txt9.isGone) {
//                Glide.with(this).load(R.drawable.img_bg_mini_card2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img9)
//                img99.setImageResource(R.drawable.ic_baseline_add_circle_24)
//            } else {
//                img99.setImageResource(R.drawable.ic_baseline_remove_circle_24)
//                Glide.with(this).load(R.drawable.img_bg_card_small2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img9)
//            }
//        }
//        btn10.setOnClickListener {
//            txt10.isGone = !txt10.isGone
//            if (txt10.isGone) {
//                Glide.with(this).load(R.drawable.img_bg_mini_card2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img10)
//                img1010.setImageResource(R.drawable.ic_baseline_add_circle_24)
//            } else {
//                img1010.setImageResource(R.drawable.ic_baseline_remove_circle_24)
//                Glide.with(this).load(R.drawable.img_bg_card_small2)
//                    .placeholder(R.drawable.progress_animation)
//                    .into(img10)
//            }
//        }
        Glide.with(this).load(R.drawable.img_bg_mini_card2)
            .placeholder(R.drawable.progress_animation)
            .into(img1)

        Glide.with(this).load(R.drawable.img_bg_card_small2)
            .placeholder(R.drawable.progress_animation)
            .into(img2)

        Glide.with(this).load(R.drawable.img_bg_mini_card2)
            .placeholder(R.drawable.progress_animation)
            .into(img3)

        Glide.with(this).load(R.drawable.img_bg_mini_card2)
            .placeholder(R.drawable.progress_animation)
            .into(img4)

        Glide.with(this).load(R.drawable.img_bg_mini_card2)
            .placeholder(R.drawable.progress_animation)
            .into(img5)

//        Glide.with(this).load(R.drawable.img_bg_mini_card2)
//            .placeholder(R.drawable.progress_animation)
//            .into(img6)
//
//        Glide.with(this).load(R.drawable.img_bg_mini_card2)
//            .placeholder(R.drawable.progress_animation)
//            .into(img7)
//
//        Glide.with(this).load(R.drawable.img_bg_mini_card2)
//            .placeholder(R.drawable.progress_animation)
//            .into(img8)
//
//        Glide.with(this).load(R.drawable.img_bg_mini_card2)
//            .placeholder(R.drawable.progress_animation)
//            .into(img9)
//
//        Glide.with(this).load(R.drawable.img_bg_mini_card2)
//            .placeholder(R.drawable.progress_animation)
//            .into(img10)
    }
}
